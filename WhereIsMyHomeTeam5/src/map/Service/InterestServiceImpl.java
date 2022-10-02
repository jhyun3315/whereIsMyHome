package map.Service;

import java.util.List;

import map.dao.InterestDao;
import map.dao.InterestDaoImpl;
import map.dto.InterestDto;

public class InterestServiceImpl implements InterestService {

	private static InterestService service = new InterestServiceImpl();
	private InterestDao dao;
	
	public InterestServiceImpl() {
		dao = InterestDaoImpl.getInterestDao();
	}
	
	public static InterestService getInterestService() {
		return service;
	}
	
	@Override
	public int insertInterest(String userId, String sidoName, String gugunName, String dongName, String dongCode) throws Exception { 
		return dao.insertInterest(userId, sidoName, gugunName, dongName, dongCode);
	}

	@Override
	public List<InterestDto> selectInterest(String userId) throws Exception {
		List<InterestDto> selectList = dao.selectInterest(userId);
		return selectList;
	}

	@Override
	public int deleteInterest(String userId, String idx) throws Exception {
		return dao.deleteInterest(userId, idx);
	}

}
