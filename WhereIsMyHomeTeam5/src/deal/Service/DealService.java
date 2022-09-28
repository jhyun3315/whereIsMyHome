package deal.Service;

import java.util.List;
import deal.dto.DealDto;

public interface DealService {
	
	public List<DealDto> aptlist(String aptCode) throws Exception;
}
