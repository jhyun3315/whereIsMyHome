package deal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import deal.dto.DealDto;
import util.DBUtil;

public class DealDaoImpl implements DealDao {
	@Override
	public List<DealDto> aptlist(String aptCode) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<DealDto> list = new ArrayList<DealDto>();
		DealDto m = null;
		
		con = DBUtil.getConnection();
		String q = "Select * from housedeal where aptCode= ?";// 3
		st = con.prepareStatement(q);
		st.setString(1, aptCode); 
		
		st = con.prepareStatement(q);
		rs = st.executeQuery();
 
		while (rs.next()) {
			m = new DealDto(rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getString(9),
					rs.getString(10));
			list.add(m);				
		}
	
		DBUtil.close(rs, st, con); 
		return list;  
	}
}
