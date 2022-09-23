package map.dto;

public class MapDto {
	private String aptNo;
	private String sidoName;
	private String gugunName;
	private String dongCode;
	private String lat;
	private String lng;
	 

	public MapDto(String aptNo, String sidoName, String gugunName, String dongCode, String lat, String lng) {
		super();
		this.aptNo = aptNo;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongCode = dongCode;
		this.lat = lat;
		this.lng = lng;
	}

	public String getAptNo() {
		return aptNo;
	}

	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
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

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
}
