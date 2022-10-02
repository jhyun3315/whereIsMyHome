package map.dto;

public class HomeDto {
	private String dealAmount; 
	private String aptName;
	private String dealYear; 
	private String DealMonth; 
	private String DealDay; 
	private String area; 
	private String floor;
	
	
	public HomeDto(String dealAmount, String aptName, String dealYear, String dealMonth, String dealDay, String area,
			String floor) {
		super();
		this.dealAmount = dealAmount;
		this.aptName = aptName;
		this.dealYear = dealYear;
		this.DealMonth = dealMonth;
		this.DealDay = dealDay;
		this.area = area;
		this.floor = floor;
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
	public String getDealMonth() {
		return DealMonth;
	}
	public void setDealMonth(String dealMonth) {
		DealMonth = dealMonth;
	}
	public String getDealDay() {
		return DealDay;
	}
	public void setDealDay(String dealDay) {
		DealDay = dealDay;
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
	
	 
	 
	
 
	
}
