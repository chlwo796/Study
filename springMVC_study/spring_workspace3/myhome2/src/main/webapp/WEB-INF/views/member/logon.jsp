<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- CDN  서비스-->
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="/sms/list">게시판</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="">상품</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="">Logout</a>
    </li>
    </ul>
</nav>

<div class="container mt-3">
  <h1>로그온</h1>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="아이디" id="userid" name="userid">
  </div>

  <div class="input-group mb-3">
    <input type="password" class="form-control" placeholder="페스워드" id="passwd" name="passwd">
  </div>


  
  	<div class="container" style="text-align:right">
	 
	  <div class="btn-group">
	    
       <button type="button" class="btn btn-primary" onclick="goWrite()">로그온</button>&nbsp;&nbsp;
      
	    <button type="button" class="btn btn-primary" onclick="goCancel()">취소</button>&nbsp;&nbsp;
	  </div>
	</div>
</form>	
</div>

</body>
</html>

<script>
function goWrite()
{
	 $.ajax({
	        url:"<%=request.getContextPath()%>/member/logon_proc", //요청 url정보
	        data:{userid:$("#userid").val(), passwd:$("#passwd").val()},   //서버로 전달할 데이터정보: JSON형태
	        dataType:"json",  //결과를 jSON으로 받겠다. 결과가 text로 온다
	        type:"POST"
	     })
	     .done((data)=>{
	        console.log(data.result);
	        if( data.result =="fail1")
	        {
	        	alert("아이디가 일치하지 않습니다.");
	        }
	        else if(data.result=="fail2")
	        {
	        	alert("패스워드가 일치하지 않습니다.");
	        }
	        else
	        {
	        	alert("로그온 성공");
	        	location="<%=request.getContextPath()%>/board/list";
	        }
	     })
	     .fail((error)=>{
	        //통신에러, 오류에 관한 것
	           console.log(error)
	     })
}


</script>