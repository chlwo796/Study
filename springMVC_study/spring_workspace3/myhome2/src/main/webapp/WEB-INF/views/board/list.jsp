<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.woori.myhome.common.*" %>
<%@page import="com.woori.myhome.board.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>


<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      <div class="d-flex">
        <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      </div>
    </div>
  </div>
</nav>

<%
	String pg = StringUtil.nullToValue(request.getParameter("pg"), "0");
	int totalCnt = (Integer)request.getAttribute("totalCnt");
%>
    <div class="container" style="margin-top:80px">
    	<form name="myform" >
    		<input type="text" name="pg" id="pg" value="<%=pg%>">
    	
        <h2>게시판 목록</h2>

        <div class="input-group mb-3" style="margin-top:20px;">
            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
                선택하세요
            </button>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">제목</a></li>
              <li><a class="dropdown-item" href="#">내용</a></li>
              <li><a class="dropdown-item" href="#">제목+내용</a></li>
            </ul>
            <input type="text" class="form-control" placeholder="Search">
            <button class="btn btn-secondary" type="submit">Go</button>
          </div>

        <table class="table table-hover ">
        	<colgroup>
        		<col width="8%">
        		<col width="*">
        		<col width="12%">
        		<col width="12%">
        	</colgroup>
            <thead class="table-secondary">
              <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
              </tr>
            </thead>
            <tbody>
	            <c:forEach var="dto" items="${boardList}">
	              <tr>
	                <td><c:out value="${dto.seq}"/></td>
	                <td><a href="${pageContext.request.contextPath}/board/view?seq=<c:out value="${dto.seq}"/>">
	                	<c:out value="${dto.title}"/></a>
	                </td>
	                <td><c:out value="${dto.userid}"/></td>
	                <td><c:out value="${dto.regdate}"/></td>
	              </tr>
	           </c:forEach>
           
            </tbody>
          </table>

 		<!--  
          <ul class="pagination  justify-content-center">
            <li class="page-item disabled"><a class="page-link" href="#">first</a></li>
            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
            <li class="page-item"><a class="page-link" href="#">last</a></li>
          </ul>
       -->
       	  <%=Pager.makeTag(request, 10, totalCnt)%>
          <div class="container mt-3" style="text-align:right;">
            <a href="<%=request.getContextPath()%>/board/write" class="btn btn-secondary">글쓰기</a>
            
          </div>
        </form>
    </div>
</body>
</html>

<script>
function goPage(pg)
{
	var frm = document.myform;
	frm.pg.value = pg;
	frm.action="${pageContext.request.contextPath}/board/list";
	frm.submit();
}

</script>




