package com.kh.klibrary.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.klibrary.admin.studyroom.model.vo.AdminStudyroomBooking;
import com.kh.klibrary.admin.studyroom.model.vo.AdminStudyroomHistory;
import com.kh.klibrary.book.model.vo.WishBook;
import com.kh.klibrary.member.model.vo.Booking;
import com.kh.klibrary.member.model.vo.Lending;
import com.kh.klibrary.member.model.vo.LendingHistory;
import com.kh.klibrary.member.model.vo.Likes;
import com.kh.klibrary.member.model.vo.Member;
import com.kh.klibrary.member.model.vo.MemberDrop;

@Repository
public class MemberDaoImpl implements MemberDao {
	//dg
	@Override
	public int insertMember(SqlSessionTemplate session, Member m) {
		
		return session.insert("member.insertMember", m);
		
	}

	
	
	@Override
	public int enrollIdCheck(SqlSessionTemplate session, Member m) {
		
		return session.selectOne("member.enrollIdCheck", m);
	}



	@Override
	public Member memberFindId(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		
		return session.selectOne("member.findId", param);
	}

	@Override
	public int memberFindPw(SqlSessionTemplate session, Member m) {
		// TODO Auto-generated method stub
		return session.update("member.findPw", m);
	}

	@Override
	public Member selectMember1(SqlSessionTemplate session, Map param) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectMember1", param);
	}
	
	
	//cg
	
	@Override
	public Member selectMember(SqlSessionTemplate session, Map m1) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectMember", m1);
	}
	
	@Override
	public int updateMember(SqlSessionTemplate session, Member m) {
		// TODO Auto-generated method stub
		return session.update("member.updateMember", m);
	}
	
	@Override
	public List<LendingHistory> selectLHList(SqlSessionTemplate session, String userId, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectLHList", userId, new RowBounds((cPage-1)*numPerpage, numPerpage));
	}
	
	@Override
	public List<Lending> selectLendingList(SqlSessionTemplate session, String userId, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectLendingList", userId, new RowBounds((cPage-1)*numPerpage, numPerpage));
	}
	
	@Override
	public List<LendingHistory> selectDate(SqlSessionTemplate session, Map m1, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectDate", m1, new RowBounds((cPage-1)*numPerpage, numPerpage));
	}

	@Override
	public List<Booking> selectBookingList(SqlSessionTemplate session, String userId, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectBookingList", userId, new RowBounds((cPage-1)*numPerpage, numPerpage));
	}
	
	@Override
	public List<Likes> selectBookMarkList(SqlSessionTemplate session, String userId, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectBookMarkList", userId , new RowBounds((cPage-1)*numPerpage, numPerpage));
	}
	
	@Override
	public List<WishBook> selectHopeRecordList(SqlSessionTemplate session, String userId, int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectHopeRecordList", userId , new RowBounds((cPage-1)*numPerpage, numPerpage));
	}
	
	@Override
	public MemberDrop selectMemberDropRequestList(SqlSessionTemplate session, Map m1) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectMemberDropRequestList", m1);
	}
	
	@Override
	public int selectLendingCount(SqlSessionTemplate session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectLendingCount", userId);
	}
	
	@Override
	public int selectLHCount(SqlSessionTemplate session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectLHCount", userId);
	}
	
	@Override
	public int selectBookingCount(SqlSessionTemplate session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectBookingCount", userId);
	}
	
	@Override
	public int selectDateCount(SqlSessionTemplate session, Map m1) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectDateCount", m1);
	}
	
	@Override
	public int cancelBooking(SqlSessionTemplate session, Map m1) {
		// TODO Auto-generated method stub
		return session.delete("member.cancelBooking", m1);
	}
	
	@Override
	public int cancelBookingUpdate(SqlSessionTemplate session, Map m1) {
		// TODO Auto-generated method stub
		return session.update("member.cancelBookingUpdate",m1);
	}
	
	@Override
	public int selectBookMarkCount(SqlSessionTemplate session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectBookMarkCount", userId);
	}
	
	@Override
	public int cancelMark(SqlSessionTemplate session, Map m1) {
		// TODO Auto-generated method stub
		return session.delete("member.cancelMark", m1);
	}
	
	@Override
	public int selectHopeRecordCount(SqlSessionTemplate session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectHopeRecordCount", userId);
	}
	
	@Override
	public int insertMemberDropRequest(SqlSessionTemplate session, Map m1) {
		// TODO Auto-generated method stub
		return session.insert("member.insertMemberDropRequest", m1);
	}
	
	@Override
	public int countUser(SqlSessionTemplate session,String today) {
		return session.insert("member.countUser",today);
	}
	
	@Override
	public AdminStudyroomBooking selectSRBooing(SqlSessionTemplate session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectSRBooking", userId);
	}
	
	@Override
	public int cancelSRBooking(SqlSessionTemplate session, String bookingNo) {
		// TODO Auto-generated method stub
		return session.delete("member.cancelSRBooking", bookingNo);
	}
	
	@Override
	public List<AdminStudyroomHistory> selectSRHList(SqlSessionTemplate session, String userId, int cPage,int numPerPage) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectSRHList", userId, new RowBounds((cPage-1)*numPerPage, numPerPage));
	}
	
	@Override
	public int selectSRHCount(SqlSessionTemplate session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne("member.selectSRHCount", userId);
	}
}
