package map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List; 

import map.dto.HomeDto;
import map.dto.MapDto;
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
	public List<HomeDto> gethomelist(String dongCode, String year, String month) {  
		
		ArrayList<HomeDto> lst = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			conn = dbutil.getConnection();
			String sql="SELECT * FROM houseinfo where dongCode? and buildYear =? and ";
			conn.prepareStatement(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
		
		
		return  lst;
	}

	  

}
