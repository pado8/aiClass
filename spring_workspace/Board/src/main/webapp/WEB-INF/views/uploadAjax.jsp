<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 100px;
}
</style>

<style>
.bigPictureWrapper {
  position: absolute;
  display: none;
  justify-content: center;
  align-items: center;
  top:0%;
  width:100%;
  height:100%;
  background-color: gray; 
  z-index: 100;
}

.bigPicture {
  position: relative;
  display:flex;
  justify-content: center;
  align-items: center;
}
</style>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>

<script>
	

	function checkExtension(fileName,fileSize){
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz|js|jar)$");
		var maxSize = 5242880; //5MB
		
		if(fileSize>=maxSize){
			alert("파일 사이즈 초과 : 최대크기 5MB");
			return false;
		}
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	function showUploadedFile(uploadResultArr){
		var str="";
		$(uploadResultArr).each(function(i,obj){
			if(!obj.image){ //image가 아니면 attach.png 출력
				var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				
				
				str+="<li><div><a href='download?fileName="+fileCallPath+"'>"
						+"<img src='/resources/img/attach.png'>"+obj.fileName+"</a>"+
						"<span data-file='"+fileCallPath+"' data-type='file'>x</span></div></li>";
				
			}else{ //image이면 썸네일 출력
				//한글파일명 깨짐방지 인코딩
				var fileCallPath=encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
				//원본파일경로
				var originPath=obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
				originPath=originPath.replace(new RegExp(/\\/g),"/"); // '\\'를 '/'로 변경
				str+="<li><a href=\"javascript:showImage('"+originPath+"')\">"+
						"<img src='/display?fileName="+fileCallPath+"'></a>"+
						"<span data-file='"+fileCallPath+"' data-type='image'>x</span></li>";
			}
		});
		
		var uploadResult = $(".uploadResult ul");
		uploadResult.append(str);
		
	}
	
	function showImage(fileCallPath){
		$(".bigPictureWrapper").css("display","flex").show();//보이게
		//원본이미지 출력. 애니메이션적용.
		$(".bigPicture").html("<img src='/display?fileName="+encodeURI(fileCallPath)+"'>")
						.animate({width:'100%',height:'100%'},1000);		
	}

	


	$(document).ready(function(){
		$("#uploadBtn").on("click",function(){
			//form태그 역할을 하는 객체
			var formData=new FormData();
			var inputFile=$("input[name='uploadFile']");
			var files=inputFile[0].files;//선택한 파일목록
			//formData에 파일목록추가
			for(var i=0;i<files.length;i++){
				//파일확장자체크
				if(!checkExtension(files[i].name,files[i].size)){
					return false;
				}
				
				formData.append("uploadFile",files[i]);
			}
			$.ajax({
				url:"uploadAjaxAction",
				processData:false, // 파일업로드시 설정
				contentType:false, // 파일업로드시 설정
				data: formData, //전송할 데이터
				type: "post", //전송방식
				success:function(result){
					console.log(result);
					
					showUploadedFile(result);//썸네일출력
					
					
				}
			});
		});
		
		
		//animate(animation구현객체,animation duration,callback함수(animation종료후 호출됨))
		$(".bigPictureWrapper").on("click", function(e){
		  $(".bigPicture").animate({width:'0%', height: '0%'}, 1000,function() {
			  $(".bigPictureWrapper").hide();
		  });	  
		});
				
		// 'x'버튼 이벤트 처리. 파일삭제
		$(".uploadResult").on("click","span",function(){
			var targetFile=$(this).data("file");
			var type=$(this).data("type");
			$.ajax({
				url:"/deleteFile", //서버주소
				data:{fileName:targetFile,type:type}, // 서버로 전송되는 데이터
				dataType:"text", // 서버에서 넘어오는 데이터의 형식
				type:"POST", // 전송방식
				success:function(result){ // 서버로부터 응답이 성공했을 때 호출되는 함수
					alert(result);					
				}
			});
		});
		
	});
</script>

		
</head>
<body>
	<h1>업로드테스트 by Ajax</h1>
	
	<!-- 원본이미지 출력 ---------------------------------------->
	<div class="bigPictureWrapper">
		<div class="bigPicture"></div>
	</div>
	<!-- 원본이미지 출력.end -->
	
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	<button id="uploadBtn">Upload</button>
	
	<!-- 썸네일 목록 ---------------------------------------->
	<div class="uploadResult">
		<ul></ul>
	</div>
</body>
</html>