package map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<MapDto> list = new ArrayList<MapDto>();
		
		try { 

			MapDto m = null;
			con = dbutil.getConnection();
			String q = "Select * from baseaddress where sidoName= ? , gugunName= ?, dongName= ?";// 3
			st = con.prepareStatement(q);
			st.setString(1, sidoName);
			st.setString(2, gugunName);
			st.setString(3, dongName);  
			
			st = con.prepareStatement(q);
			rs = st.executeQuery();
	 
			while (rs.next()) {
				m = new MapDto(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6));
				list.add(m);				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	
		DBUtil.close(rs, st, con); 
		return list; 
	}

	@Override
	public List<String> sidoNamelist() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		
		try { 
 
			con = dbutil.getConnection(); 
			String q = "SELECT sidoName FROM whereismyhome.sidocode";// 3
			st = con.prepareStatement(q); 
			
			st = con.prepareStatement(q);
			rs = st.executeQuery();
			while(rs.next()) { 
				list.add(rs.getString("sidoName"));
			};
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
		DBUtil.close(rs, st, con); 
		return list; 
		 
	}

 

	@Override
	public Map<String, String[]> select() {
		// TODO Auto-generated method stub
		return null;
	} 
	

}
