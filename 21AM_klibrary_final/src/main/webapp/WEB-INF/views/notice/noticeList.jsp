<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>    
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="title" value="공지사항목록"/>
</jsp:include>
<body>
    <div class="divcontainer1">
    <br>
    	<h2 id="title11">공지사항</h2>
    <br>
  </div>
    <section id="ad_containerad">
        <div class="list-group-containers" >
            <ul class="list-group">
              <li class="list-group-item" id="menutitle">이용안내</li>
              <li class="list-group-item" onclick="location.assign('${path}/notice/noticeList.do')">공지사항</li>
              <li class="list-group-item" onclick="location.assign('${path}/faq/faqList.do')">자주묻는질문</li>
              <li class="list-group-item" onclick="location.assign('${path}/qna/qnaList.do')">QNA</li>
            </ul>
        </div>
        
        <div id="he_right">
            <div id="titleheadnamec">공지사항</div>
            <div id="contbody" class="sech">
                <form action="${path }/notice/noticesearch.do" method="post">
                    <select class="fontsize" name="searchOption" aria-label="Default select example">
                        <option selected>검색옵션</option>
                        <option value="notice_title" ${param.searchOption =="notice_title"? "selected":""}>제목</option>
                        <option value="notice_content" ${param.searchOption =="notice_content"? "selected":""}>내용</option>
                   	</select>
                    <input type="search" class="textbox" name="searchWord"
                    placeholder="입력" aria-label="Search" value='${param.searchWord!=null?param.searchWord:"" }' required>
                    <button id="search" class="btn btn-outline-secondary" type="submit" style="margin-bottom: 4px;">검색</button>
                </form>
            </div>
            <div class="tableMap">
                <table class="table">
                    <tr>
                        <th class="head2">번호</th>
                        <th class="head">제목</th>
                        <th class="head2">첨부파일</th>
                        <th class="head3">등록일</th>
                        <th class="head2">조회수</th>
                    </tr>
                    <!-- 게시글 출력 -->
                    <c:choose>
                    	<c:when test="${not empty list }">
                    		<c:forEach var="n" items="${list }">
                    			<tr>
                    				<td class="head2">
                    				<c:out value="${n.noticeNo }"/></td>
                    				<td class="head">
	                    				<a href="${path }/notice/noticeEnd.do?no=${n.noticeNo }"/>
	                    				<c:out value="${n.noticeTitle }"/>
                    				</td>
                    				<td class="head2"><c:out value="${n.originalFileName }"/></td>
                    				<td class="head3"><c:out value="${n.noticeDate }"/></td>
                    				<td class="head2"><c:out value="${n.noticeCount }"/></td>
                    			</tr>
                    		</c:forEach>
                    	</c:when>
		                <c:otherwise>
		                   <tr>
		                   	<td clospan="6">조회된 공지사항이 없습니다</td>
		                   </tr>
		                </c:otherwise>
                    </c:choose>
                </table>
                <!-- 페이징처리 -->
               <div id="pageBar" style="margin-top:8px">
	               	<c:out value="${pageBar }" escapeXml="false"/>
	           </div>
            </div>
        </div>
    </section>
</body>
    <script>
    
    
    
    const fn_searchKey = function(cPage){
    	const searchKey = $("#searchOption").val();
     	const searchWord = $("#searchWord").val();
		location.assign('${path}/admin/member/SearchMember.do?cPage='+cPage+"&searchOption="+searchKey+"&searchWord="+searchWord);
	}
    
	/* // 페이지 이동 
    const fn_paging = function(cPage){
    	location.assign('${path}/admin/member/memberList.do?cPage='+cPage);
    } */
    
    $(function(){
	   $('.list-group-item').click(function(){
	      $('.list-group-item').removeClass('on')
	        $(this).addClass('on')
	   })
	})
	
	 $(function(){
		console.log(window.location.href );
		
		  
		  $(".list-group").children().eq(1).css({"backgroundColor" : "lightgrey"})
		  
			 	   
		})

	
	</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>