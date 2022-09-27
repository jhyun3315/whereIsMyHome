package member.service;

import java.util.List;

import member.dao.MemberDao;
import member.dao.MemberDaoImpl;
import member.dto.Member;

public class MemberServiceImpl implements MemberService {

	private static MemberService service = new MemberServiceImpl();
	private MemberDao dao;

	public MemberServiceImpl() {
		dao = MemberDaoImpl.getMemberDao();
	}

	public static MemberService getMemberService() {
		return service;
	}

	@Override
	public void insertMember(String userId, String userPw, String userName, String userEmail, String userPhoneNum)
			throws Exception {
		Member m = new Member(userId, userPw, userName, userEmail, userPhoneNum);
		dao.insertMember(m);
	}

	@Override
	public Member selectMember(String userId) throws Exception {
		return dao.selectMember(userId);
	}

	@Override
	public List<Member> selectMember() throws Exception {
		List<Member> selectList = dao.selectMember();
		return selectList;
	}

	@Override
	public void updateMember(String userId, String userPw, String userName, String userEmail, String userPhoneNum)
			throws Exception {
		Member m = new Member(userId, userPw, userName, userEmail, userPhoneNum);
		dao.updateMember(m);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		dao.deleteMember(userId);
	}

	@Override
	public boolean login(String userId, String userPw) throws Exception {
		return dao.login(userId, userPw);
	}

}
