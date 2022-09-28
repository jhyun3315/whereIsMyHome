package map.Service;

import java.util.List;
 
import map.dao.MapDao;
import map.dao.MapDaoImpl;
import map.dto.MapDto;

public class MapServiceImpl implements MapService{
	private MapDao dao;
	
	public MapServiceImpl() {
		dao = new MapDaoImpl(); 
	}
	
	@Override
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception {
		
		List<MapDto> selectMember = dao.selectmap(sidoName, gugunName, dongName);
		return selectMember; 
	}

}
