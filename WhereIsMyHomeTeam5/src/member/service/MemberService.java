package member.service;

import java.util.List;

import member.dto.Member;

public interface MemberService {
	void insertMember(String userId, String userPw, String userName, String userEmail, String userPhoneNum) throws Exception;
	Member selectMember(String userId) throws Exception;
	List<Member> selectMember() throws Exception;
	void updateMember(String userId, String userPw, String userName, String userEmail, String userPhoneNum) throws Exception;
	void deleteMember(String userId) throws Exception;
	boolean login(String userId, String userPw) throws Exception;
}
