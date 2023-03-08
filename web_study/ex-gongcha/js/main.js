$('.mobileHeader .menuicon').click(function(){
	$('.bgBk').stop().fadeIn(500);
	$("#side").stop().animate({right:"0px"},500);
	return false;
});

// 모바일메뉴영역 닫기
$(".closeMenu").click(function(){
	$('.bgBk').stop().fadeOut(500);
	$("#side").stop().animate({right:"-100%"},500);
	return false;
});

// 공지사항
/* setInterval()명령 : 특정동작을 시간마다 반복시켜주는 명령
   setInterval(함수,시간); */
// 공지사항제목 리스트를 저장하는 변수nList를 만듬.
var nList = $(".notice_list li");
// 변수nStart를 만들어 0을 저장함. 이때 0은 최초로 화면에 출력되고 있는 제목의 순서값을 나타냄.
var nStart = 0;
setInterval(function(){
	// 변수nNext를 만들어 변수nStart+1의 값을 저장함. 이값은 다음으로 출력될 제목의 순서값이 될 것임.
	var nNext = nStart+1;
	// 만약 nNext값이 4와 같다면 => nNext의 값을 0으로 지정함.
	if(nNext==4) nNext=0;
	// 리스트가 움직이도록 명령
	nList.css({zIndex:0});
	nList.eq(nNext).css({top:"100%",zIndex:1}).animate({top:0},500);	
	// 동작이 완료 된 후 nStart변수의 값이 nNext변수값으로 변경되도록 명령
	nStart = nNext;
},3000); 	


// slider
// mobileboardslider, PCboradslider

$(".slider").slick({
	autoplaySpeed:3500,
	autoplay:true,
	dots: true,
	infinite: true,
	slidesToShow: 1,
	slidesToScroll: 1,
	arrows:false,
	centerMode: false,
	// prevArrow : '.best .button .button_prev',
	// nextArrow : '.best .button .button_next',
	customPaging : function(s,i){
		return '<a href="#"></a>';
	},
	});