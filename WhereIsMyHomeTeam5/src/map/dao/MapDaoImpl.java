package map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;  

import map.dto.DealDto;
import map.dto.HomeDto;
import util.DBUtil;

public class MapDaoImpl implements MapDao{
	private static MapDao mapdao = new MapDaoImpl();
	private DBUtil dbutil;
	
	private MapDaoImpl() {
		dbutil = DBUtil.getInstance();
	}
	
	public static MapDao getMapDao() {
		return mapdao;
	}

	@Override
	public ArrayList<DealDto> gethomelist(String dongCode, String year, String month) {   

		ArrayList<DealDto> lst = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			conn = dbutil.getConnection();
			String sql="SELECT houseinfo.apartmentName, houseinfo.dong,  houseinfo.roadName, houseinfo.roadNameBonbun, houseinfo.lng, houseinfo.lat, housedeal.* FROM houseinfo, housedeal, dongcode where dongcode.dongCode = ? and  dongcode.dongCode = houseinfo.dongCode and houseinfo.aptCode = housedeal.aptCode and housedeal.dealYear = ? and housedeal.dealMonth = ? limit 10";
			st = conn.prepareStatement(sql);
			st.setString(1, dongCode);
			st.setString(2, year);
			st.setString(3, month);
			rs = st.executeQuery(); 
			
			while(rs.next()) {
				lst.add(new DealDto(rs.getString(1), rs.getString(2), dongCode, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(15)));				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}  
		
		dbutil.close(conn, st, rs);
		return  lst;
	}

	@Override
	public ArrayList<HomeDto> getdeallist(String aptCode, String aptName) {

		ArrayList<HomeDto> lst = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		System.out.println(aptCode+","+aptName);
				
		try {
			conn = dbutil.getConnection();
			String sql="SELECT dealAmount, dealYear, dealMonth, dealDay, area, floor FROM housedeal where aptCode = ? limit 10;";
			st = conn.prepareStatement(sql);
			st.setString(1, aptCode); 
			rs = st.executeQuery(); 
			
			while(rs.next()) {
				lst.add(new HomeDto(rs.getString(1), aptName, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));				
			}
			 
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}  
		
		dbutil.close(conn, st, rs);
		return  lst;
	}

	
	  

}
