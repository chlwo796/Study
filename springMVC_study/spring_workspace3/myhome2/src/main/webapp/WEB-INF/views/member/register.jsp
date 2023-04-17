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
<form name="myform" id="myform">
	<input type="hidden" name="idcheck" id="idcheck" value="N">
	
   <h1>회원가입</h1>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="아이디" name="userid" id="userid">
    <div class="input-group-append">
      <button class="btn btn-success" type="button" id="btnDuplicate">중복체크</button>  
     </div>
  </div>

  <div class="input-group mb-3">
    <input type="password" class="form-control" name="password" id="password" placeholder="페스워드">
  </div>

  <div class="input-group mb-3">
    <input type="password" class="form-control" name="password2" id="password2" placeholder="패스워드확인">
  </div>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="이름" name="username" id="username">
  </div>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="닉네임" name="nickname" id="nickname">
  </div>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="email" name="email" id="email">
  </div>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="전화번호" name="phone" id="phone">
  </div>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="우편번호" name="zipcode" id="zipcode">
  </div>
  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="도로주소" name="address1" id="address1">
  </div>

  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="상세주소" name="address2" id="address2">
  </div>    
  


  <!-- 다음 우편 api :주소체계 번지 -> 길  -->
  
  	<div class="container" style="text-align:right">
	 
	  <div class="btn-group">
	    
       <button type="button" class="btn btn-primary" onclick="goWrite()">등록</button>&nbsp;&nbsp;
      
	    <button type="button" class="btn btn-primary" onclick="goCancel()">취소</button>&nbsp;&nbsp;
	  </div>
	</div>
</form>	
</div>

</body>
</html>

<script>
$(()=>{
    $("#btnDuplicate").click(()=>{
       $.ajax({
          url:"<%=request.getContextPath()%>/member/isDuplicate", //요청 url정보
          data:{userid:$("#userid").val()},   //서버로 전달할 데이터정보: JSON형태
          dataType:"json",  //결과를 jSON으로 받겠다. 결과가 text로 온다
          type:"POST"
       })
       .done((data)=>{
          //데이터가 정상적으로 수신되면 done메서드 호출되면서 매개변수는 전달받은 값
          //값은 dataType 속성을 안주면 text로 온다.
          console.log(data.result);
          if( data.result =="success")
          {
        	  $("#idcheck").val("Y"); //hidden태그를 만들고 아이디 체크가 통과했음을 알려주기 위한 태그
              $("#userid").prop("readonly", true);  //수정못하게 막는 기능
              //prop함수는 속성을 읽거나 변경하는 기능을 갖는다. jquery1.4부터 이전버전 attribute사용
          }
          else
          {
        	   alert("이미 사용중인 아이디입니다.");
        	   return;
          }
       })
       .fail((error)=>{
          //통신에러, 오류에 관한 것
             console.log(error)
       })
    })
 })

 
 function goWrite()
 {
	
	 //파일을 전송할때  form태그에 enctype="multipart/form-data"
	 //var frmData = new FormData(document.myform);
	 
	 //파일 전송이 아닐때는 
	 var queryString = $("form[name=myform]").serialize(); 
	 console.log(queryString);
	   
	 $.ajax({
        url:"<%=request.getContextPath()%>/member/insert", //요청 url정보
        data:queryString,
        //data:{userid:$("#userid").val(), passwd:$("#passwd").val()},   //서버로 전달할 데이터정보: JSON형태
        dataType:"json",  //결과를 jSON으로 받겠다. 결과가 text로 온다
        type:"POST"
     })
     .done((data)=>{
        //데이터가 정상적으로 수신되면 done메서드 호출되면서 매개변수는 전달받은 값
        //값은 dataType 속성을 안주면 text로 온다.
        console.log(data.result);
        if( data.result =="success")
        {
        	alert("회원가입이 되었습니다");
        	location="<%=request.getContextPath()%>/board/list";
        }
        else
        {
        }
     })
     .fail((error)=>{
        //통신에러, 오류에 관한 것
           console.log(error)
     })
 }
 
 
 
</script>













