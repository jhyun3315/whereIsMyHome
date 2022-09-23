package map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import map.dto.MapDto;
import util.DBUtil;

public class MapDaoImpl implements MapDao{

	@Override
	public List<MapDto> selectmap(String sidoName, String gugunName, String dongName) throws Exception {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<MapDto> list = new ArrayList<MapDto>();
		MapDto m = null;
		
		con = DBUtil.getConnection();
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
	
		DBUtil.close(rs, st, con); 
		return list; 
	}


	

}
