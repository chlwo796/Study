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
BoardDto dto=(BoardDto)request.getAttribute("boardDto");
%>
	<form name="myform" method="post" enctype="multipart/form-data">
		<input type="hidden" name="seq" id="seq" value="<%=dto.getSeq()%>" />
    <div class="container" style="margin-top:80px">
        <h2>게시판 쓰기</h2>

        <table class="table table-hover " style="margin-top: 30px;">
            <colgroup>
                <col width="25%">
                <col width="*">
            </colgroup>
        
            <tbody>
              <tr>
                <td>제목</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <input type="text" class="form-control" id="title" name="title" 
                        value="<%=dto.getTitle()%>"
                        placeholder="제목을 입력하세요" >
                    </div>
                </td>
              </tr>       
              <tr>
                <td>작성자</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <input type="text" class="form-control" id="userid" name="userid"
                        value="<%=dto.getUserid()%>" 
                        placeholder="이름을 입력하세요" >
                    </div>
                </td>
              </tr>      
              <tr>
                <td>내용</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                      <textarea class="form-control" rows="5" id="contents" name="contents"><%=dto.getContents()%></textarea>
                    </div>
                </td>
              </tr>    
              
              <tr >
		        <td>첨부파일1</td>
		        <td>
		        	<div class="input-group mb-3">
					    <input type="file" class="form-control" name="file1">
					</div>
				</td>
		      </tr>
		      <tr >
		        <td>첨부파일2</td>
		        <td>
		        	<div class="input-group mb-3">
					    <input type="file" class="form-control" name="file2">
					</div>
				</td>
		      </tr>
		      <tr >
		        <td>첨부파일3</td>
		        <td>
		        	<div class="input-group mb-3">
					    <input type="file" class="form-control" name="file3">
					</div>
				</td>
		  	 </tr>      
            </tbody>
          </table>
       
          <div class="container mt-3" style="text-align:right;">
            <a href="#none" class="btn btn-secondary" onclick="goWrite()">등록</a>
            <button type="button" class="btn btn-secondary">Button</button>
          </div>
    </div>
    
    </form>
</body>
</html>


<script>
function goWrite()
{
	var frm = document.myform;
	frm.action = "<%=request.getContextPath()%>/board/save";
	frm.submit();
}
</script>


