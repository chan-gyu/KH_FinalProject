package com.kh.klibrary.notice.model.service;

import java.util.List;

import com.kh.klibrary.admin.notice.model.vo.Notice;

public interface NoticeService {
	
	List<Notice> selectNoticeList(int cPage,int numPerpage);
	int selectNoticeCount();
	Notice selectNoticeView(int no);
	List<Notice> searchnotice(String text);
	List<Notice> searchnoticecontent(String text);
	

}
