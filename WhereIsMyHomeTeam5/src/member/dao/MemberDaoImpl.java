package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import member.dto.Member;
import util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao dao = new MemberDaoImpl();

	public static MemberDao getMemberDao() {
		return dao;
	}

	@Override
	public void insertMember(Member m) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into members \n");
		sql.append("values (?,?,?,?,?)");
		pstmt = con.prepareStatement(sql.toString());
		int idx = 0;
		pstmt.setString(++idx, m.getUserId());
		pstmt.setString(++idx, m.getUserPw());
		pstmt.setString(++idx, m.getUserName());
		pstmt.setString(++idx, m.getUserEmail());
		pstmt.setString(++idx, m.getUserPhoneNum());
		pstmt.executeUpdate();

		DBUtil.close(pstmt, con);
	}

	@Override
	public Member selectMember(String userId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;

		con = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * \n");
		sql.append("from members");
		sql.append("where id=?");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, userId);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}

		DBUtil.close(rs, pstmt, con);

		return m;
	}

	@Override
	public List<Member> selectMember() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		List<Member> list = new ArrayList<>();

		con = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * \n");
		sql.append("from members");
		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();

		while (rs.next()) {
			m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			list.add(m);
		}

		DBUtil.close(rs, pstmt, con);

		return list;
	}

	@Override
	public void updateMember(Member m) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("update members \n");
		sql.append("set pw=?, name=?, email=?, phonenumber=? \n");
		sql.append("where id=?");
		pstmt = con.prepareStatement(sql.toString());
		int idx = 0;
		pstmt.setString(++idx, m.getUserPw());
		pstmt.setString(++idx, m.getUserName());
		pstmt.setString(++idx, m.getUserEmail());
		pstmt.setString(++idx, m.getUserPhoneNum());
		pstmt.setString(++idx, m.getUserId());
		pstmt.executeUpdate();

		DBUtil.close(pstmt, con);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("delete from members \n");
		sql.append("where id=?");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, userId);
		pstmt.executeUpdate();

		DBUtil.close(pstmt, con);
	}

	@Override
	public boolean login(String userId, String userPw) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * \n");
		sql.append("from members \n");
		sql.append("where id=? and pw=?");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, userId);
		pstmt.setString(2, userPw);
		rs = pstmt.executeQuery();
				
		boolean result = false;
		if (rs.next()) {
			result = true;
		}
		
		return result;
	}

}
