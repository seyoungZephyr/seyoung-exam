<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : ComtccmmndetailcodeList.jsp
  * @Description : Comtccmmndetailcode List 화면
  * @Modification Information
  * 
  * @author testCRUD
  * @since 2016.11.25
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>목록</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 수정 화면 function */


function fn_egov_select(codeId, code) {
	document.getElementById("listForm").codeId.value = codeId;
	document.getElementById("listForm").code.value = code;
   	document.getElementById("listForm").action = "<c:url value='/comtccmmndetailcode/updateComtccmmndetailcodeView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/comtccmmndetailcode/addComtccmmndetailcodeView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/comtccmmndetailcode/ComtccmmndetailcodeList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="codeId" />
	<input type="hidden" name="code" />
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt="title" /> List </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
							</colgroup>		  
			<tr>
								<th align="center">CodeId</th>
								<th align="center">Code</th>
								<th align="center">CodeNm</th>
								<th align="center">CodeDc</th>
								<th align="center">UseAt</th>
								<th align="center">FrstRegistPnttm</th>
								<th align="center">FrstRegisterId</th>
								<th align="center">LastUpdtPnttm</th>
								<th align="center">LastUpdusrId</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																			<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.codeId}"/>', '<c:out value="${result.code}"/>')"><c:out value="${result.codeId}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.codeId}"/>', '<c:out value="${result.code}"/>')"><c:out value="${result.code}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.codeNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.codeDc}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.useAt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.frstRegistPnttm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.frstRegisterId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.lastUpdtPnttm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.lastUpdusrId}"/>&nbsp;</td>
				    			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	<div id="paging">
		<ui:pagination paginationInfo = "${paginationInfo}"
				   type="image"
				   jsFunction="fn_egov_link_page"
				   />
		<form:hidden path="pageIndex" />
	</div>
	<div id="sysbtn1">
		<ul>
			<li>
				<div id="sysbtn">
					<span class="btn_blue_l"><a href="javascript:fn_egov_addView();">등록</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" alt="" />
					</span>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>
</html>
