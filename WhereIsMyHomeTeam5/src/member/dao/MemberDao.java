package member.dao;

import java.util.List;

import member.dto.Member;

public interface MemberDao {
	void insertMember(Member m) throws Exception;
	Member selectMember(String userId) throws Exception;
	List<Member> selectMember() throws Exception;
	void updateMember(Member m) throws Exception;
	void deleteMember(String userId) throws Exception;
	boolean login(String userId, String userPw) throws Exception;
}
