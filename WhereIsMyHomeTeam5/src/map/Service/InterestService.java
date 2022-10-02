package map.Service;

import java.util.List;

import map.dto.InterestDto;

public interface InterestService {
	public int insertInterest(String userId, String sidoName, String gugunName, String dongName, String dongCode) throws Exception;
	public List<InterestDto> selectInterest(String userId) throws Exception;
	public int deleteInterest(String userId, String idx) throws Exception;
}
