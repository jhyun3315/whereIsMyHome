package map.dto;

public class DealDto {
	private String apartmentName;
	private String dongName;
	private String dongCode;
	private String roadName;
	private String roadNameBonbun;
	private String lng;
	private String lat;
	private String no;
	private String dealAmount;
	private String dealYear;
	private String dealMonth;
	private String dealDat;
	private String area;
	private String floor;
	private String aptCode; 
	
	
	public DealDto(String apartmentName, String dongName, String dongCode, String roadName, String roadNameBonbun,String lng, String lat, String no, String dealAmount, String dealYear, String dealMonth,
			String dealDat, String area, String floor, String aptCode) {
		super();
		this.apartmentName = apartmentName;
		this.dongName = dongName; 
		this.dongCode = dongCode;
		this.roadName = roadName;
		this.roadNameBonbun = roadNameBonbun;
		this.lng = lng;
		this.lat = lat;
		this.no = no;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDat = dealDat;
		this.area = area;
		this.floor = floor;
		this.aptCode = aptCode;
	}
 
	public String getRoadName() {
		return roadName;
	}



	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}



	public String getRoadNameBonbun() {
		return roadNameBonbun;
	}



	public void setRoadNameBonbun(String roadNameBonbun) {
		this.roadNameBonbun = roadNameBonbun;
	}



	public String getDongCode() {
		return dongCode;
	} 


	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}



	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getLng() {
		return lng;
	}
	
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public String getLat() {
		return lat;
	}
	
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	public String getNo() {
		return no;
	}
	
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getDealAmount() {
		return dealAmount;
	}
	
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	
	public String getDealYear() {
		return dealYear;
	}
	
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
 
	
	public String getDealDat() {
		return dealDat;
	}
	
	public void setDealDat(String dealDat) {
		this.dealDat = dealDat;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	
	public String getFloor() {
		return floor;
	}
	
	
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getAptCode() {
		return aptCode;
	}
	
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}
 
	
}
