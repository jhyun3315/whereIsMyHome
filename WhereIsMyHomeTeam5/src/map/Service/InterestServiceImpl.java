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
	public void insertInterest(String userId, String sidoName, String gugunName, String dongName)
			throws Exception {
		dao.insertInterest(userId, sidoName, gugunName, dongName);
	}

	@Override
	public List<InterestDto> selectInterest(String userId) throws Exception {
		List<InterestDto> selectList = dao.selectInterest(userId);
		return selectList;
	}

	@Override
	public void deleteInterest(String userId) throws Exception {
		dao.deleteInterest(userId);
	}

}
