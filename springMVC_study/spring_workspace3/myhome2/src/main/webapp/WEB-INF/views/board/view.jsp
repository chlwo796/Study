<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.woori.myhome.board.*" %>
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
    <nav class="navbar navbar-expand-sm bg-light navbar-light fixed-top">
        <div class="container-fluid">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" href="#">Active</a>
            </li>
           <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#">Disabled</a>
            </li>
          </ul>
        </div>
    </nav>


<%
BoardDto dto = (BoardDto)request.getAttribute("boardDto");
%>
    <div class="container" style="margin-top:80px">
        <h2>게시판 상세보기</h2>


        <table class="table table-hover " style="margin-top:30px;">
            <tbody>
              <tr class="table-secondary">
                <th>제목</th>
                <td colspan="5"><%=dto.getTitle()%></td>
              </tr>
              <tr>
                <th >작성자</th>
                <td><%=dto.getUserid()%></td>
                <th >작성일</th>
                <td><%=dto.getRegdate()%></td>
                <th  >조회수</th>
                <td>7</td> 
              </tr>
              <tr>
                <th colspan="6"  class="table-secondary">내용</td>
              </tr>
              <tr>
                <td colspan="6"><%=dto.getContents()%></td>
              </tr>
              
              <tr>
              	<td colspan="6"><a href="<%=request.getContextPath()%>/down?id=board&filename=<%=dto.getFilename1()%>">
              	<%=dto.getFilename1()%></a></td>
              </tr>	
              <tr>
              	<td colspan="6"><a href="<%=request.getContextPath()%>/down?id=board&filename=<%=dto.getFilename2()%>">
              	<%=dto.getFilename2()%></a></td>
              </tr>	
               <tr>
              	<td colspan="6"><a href="<%=request.getContextPath()%>/down?id=board&filename=<%=dto.getFilename3()%>">
              	<%=dto.getFilename3()%></a></td>
              </tr>	
            </tbody>
          </table>

 
         
       
          <div class="container mt-3" style="text-align:right;">
            <button type="button" class="btn btn-secondary" onclick="goModify()">수정</button>
            <button type="button" class="btn btn-secondary" onclick="goDelete()">삭제</button>
            
          </div>
          
    </div>
</body>
</html>

<script>
function goModify()
{
	location.href="<%=request.getContextPath()%>/board/modify?seq=<%=request.getParameter("seq")%>";
}

function goDelete()
{
	location.href="<%=request.getContextPath()%>/board/delete?seq=<%=request.getParameter("seq")%>";
}


</script>




