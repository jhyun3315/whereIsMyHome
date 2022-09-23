package map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List; 

import map.dto.MapDto;
import util.DBUtil;

public class MapDaoImpl implements MapDao{

	@Override
	public List<MapDto> selectMember() throws Exception {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		MapDto m = null;
		con = DBUtil.getConnection();// 2
		String q = "Select * from baseaddress where id=?";// 3
		st = con.prepareStatement(q);
		st.setInt(1, id);
		rs = st.executeQuery();// 4

		if (rs.next()) {// 5
			m = new MapDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		
		close(rs, st, con);

		return m; 
	}

	@Override
	public MapDto selectMember(String aptNo) throws Exception {
		
		return null;
	}
	

}
