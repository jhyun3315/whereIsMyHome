package deal.dao;

import java.util.List; 
import deal.dto.DealDto;

public interface DealDao {
	
	public List<DealDto> aptlist(String aptCode) throws Exception;
}
