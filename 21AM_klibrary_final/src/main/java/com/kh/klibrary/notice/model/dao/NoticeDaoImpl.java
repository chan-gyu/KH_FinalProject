package com.kh.klibrary.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.klibrary.admin.notice.model.vo.Notice;
@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Override
	public List<Notice> selectNoticeList(SqlSessionTemplate session,int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return session.selectList("notice.selectNoticeList",null,new RowBounds(((cPage-1)*numPerpage),numPerpage));
	}

	@Override
	public int selectNoticeCount(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectOne("notice.selectNoticeCount");
	}

	@Override
	public Notice selectNoticeView(SqlSessionTemplate session, int no) {
		// TODO Auto-generated method stub
		return session.selectOne("notice.selectNoticeView",no);
	}

	@Override
	public List<Notice> searchnotice(SqlSessionTemplate session, String text) {
		// TODO Auto-generated method stub
		return session.selectList("notice.searchnotice",text);
	}

	@Override
	public List<Notice> searchnoticecontent(SqlSessionTemplate session, String text) {
		// TODO Auto-generated method stub
		return session.selectList("notice.searchnoticecontent",text);
	}
	
	
	
	

	

	

	
	
	

}
