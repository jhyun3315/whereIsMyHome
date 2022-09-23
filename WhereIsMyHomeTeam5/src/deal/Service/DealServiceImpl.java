package deal.Service;

import java.util.List;
  
import deal.dao.DealDaoImpl;
import deal.dto.DealDto;
import deal.dao.DealDao;

public class DealServiceImpl implements DealService {
	private DealDao dao;
	
	public DealServiceImpl() {
		dao = new DealDaoImpl(); 
	}

	@Override
	public List<DealDto> aptlist(String aptCode) throws Exception { 
		List<DealDto> aptlist = dao.aptlist(aptCode);
		return aptlist;
	}

 
	
}
