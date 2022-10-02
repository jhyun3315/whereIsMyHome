package map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import map.dto.InterestDto;
import util.DBUtil;

public class InterestDaoImpl implements InterestDao {

	private static InterestDao dao = new InterestDaoImpl();
	private DBUtil dbUtil;
	
	public InterestDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static InterestDao getInterestDao() {
		return dao;
	}
	
	@Override
	public int insertInterest(String userId, String sidoName, String gugunName, String dongName) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		con = dbUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into interests \n");
		sql.append("values (?,0,?,?,?)");
		pstmt = con.prepareStatement(sql.toString());
		
		int idx = 0; 
		pstmt.setString(++idx, userId);
		pstmt.setString(++idx, sidoName);
		pstmt.setString(++idx, gugunName);
		pstmt.setString(++idx, dongName);
		result = pstmt.executeUpdate();
		
		DBUtil.close(pstmt, con); 
		
		return result;
	}

	@Override
	public List<InterestDto> selectInterest(String userId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		InterestDto inter = null;
		List<InterestDto> list = new ArrayList<>();
		
		con = dbUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select sido, gugun, dong \n");
		sql.append("from interests \n");
		sql.append("where id=?");		
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, userId);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			inter = new InterestDto(rs.getString(1), rs.getString(2), rs.getString(3));
			list.add(inter);
		}
		
		DBUtil.close(rs, pstmt, con);
		
		return list;
	}

	@Override
	public void deleteInterest(String userId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		con = dbUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from interests \n");
		sql.append("where id=?");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, userId);
		pstmt.executeUpdate();
		
		DBUtil.close(pstmt, con);
	}

}
