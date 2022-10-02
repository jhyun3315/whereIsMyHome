package map.dto;

public class InterestDto { 
	private String userId;
	private String sidoName;
	private String gugunName;
	private String dongName;

	public InterestDto(String sidoName, String gugunName, String dongName) {
		super();  
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}

 
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

}
