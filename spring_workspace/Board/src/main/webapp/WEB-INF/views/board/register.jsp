<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<%@include file="../includes/header.jsp"%>   
<!-- cotnents --------------------------------------------------------->

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

       <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Board</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        
        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Regist
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                           	<form role="form" action="/board/register" method="post">
	                        	<div class="form-group">
		                        	<label>Title</label>
		                        	<input class="form-control" name="title"> 
	                        	</div>
	                        	<div class="form-group">
		                        	<label>Content</label>
		                        	<textarea class="form-control" rows="3" name="content"></textarea> 
	                        	</div>
	                        	<div class="form-group">
		                        	<label>Writer</label>
		                        	<input class="form-control" name="writer"> 
	                        	</div>
	                        	
	                        	<!-- 첨부파일 -------------------------------------------------->
	                        	<div class="row">
								  <div class="col-lg-12">
								    <div class="panel panel-default">
								
								      <div class="panel-heading">File Attach</div>
								      <!-- /.panel-heading -->
								      <div class="panel-body">
								        <div class="form-group uploadDiv">
								            <input type="file" name='uploadFile' multiple>
								        </div>
								        
								        <div class='uploadResult'> 
								          <ul>
								          
								          </ul>
								        </div>								        
								        
								      </div>
								       <!--  end panel-body -->								
								    </div>
								    <!--  end panel-body -->
								  </div>
								  <!-- end panel -->
								</div>
								<!-- /.row -->
								<!-- 첨부파일.end ------------------------------------------------------->
	                        	
	                        	
	                        	<button type="submit" class="btn btn-default">Submit</button>
	                        	<button type="reset" class="btn btn-default">Reset Button</button>
                           	</form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

			<script>
				$(document).ready(function(){
					var formObj=$("form[role='form']"); //form을 미리 찾아놓는다.
					//전송버튼 이벤트 처리
					$("button[type='submit']").on("click",function(e){
						e.preventDefault(); //전송방지
						
						var str="";
						$(".uploadResult ul li").each(function(i,obj){
							var jobj=$(obj);//배열의 아이템
							str+="<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
							str+="<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
							str+="<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
							str+="<input type='hidden' name='attachList["+i+"].fileType' value='"+jobj.data("type")+"'>";
													
						});
						console.log("!!!!!!!!!!!!!!!!!!!");
						console.log(str);
						//폼에 추가.전송
						formObj.append(str).submit();
					});
					
					/* 파일확장자체크함수 *******************************************************/
					var regex = new RegExp("(.*?)\.(exe|sh|zip|alz|js|jar)$");
					var maxSize = 5242880; //5MB
					
					function checkExtension(fileName, fileSize){
					  
					  if(fileSize >= maxSize){
					    alert("파일 사이즈 초과");
					    return false;
					  }
					  
					  if(regex.test(fileName)){
					    alert("해당 종류의 파일은 업로드할 수 없습니다.");
					    return false;
					  }
					  return true;
					}
					/* 파일확장자체크함수.end *******************************************************/
					
					//파일선택시 파일업로드 이벤트 처리
					$("input[type='file']").change(function(){
					    var formData = new FormData();	//폼태그 역할을 하는 객체					    
					    var inputFile = $("input[name='uploadFile']");					    
					    var files = inputFile[0].files;
					    
					    for(var i = 0; i < files.length; i++){
					      if(!checkExtension(files[i].name, files[i].size) ){ //확장자.파일사이즈 체크
					        return false;
					      }
					      formData.append("uploadFile", files[i]);					      
					    }
					    
					    $.ajax({
					      url: '/uploadAjaxAction',
					      processData: false, // 파일업로드시 필요
					      contentType: false, // 파일업로드시 필요
					      data:formData,
					      type: 'POST',
					      dataType:'json',
					      success: function(result){
					          console.log(result); 
							  showUploadResult(result); //업로드 결과 처리 함수 

					      }
					    }); //$.ajax
					});
					
					/* 썸네일을 출력하는 함수 ****************************************************************/
					function showUploadResult(uploadResultArr){
						//첨부파일이 없으면 중지
						if(!uploadResultArr || uploadResultArr.length==0){
							return;
						}
						var uploadUL=$(".uploadResult ul");//썸네일이 출력되는 UL태그를 찾아놓음
						var str="";
						$(uploadResultArr).each(function(i,obj){
							if(obj.image){//이미지이면
								//파일경로.한글깨지지않게 인코딩
								var fileCallPath=encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
								str+="<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
								str+="	<div>";
								str+="		<span>"+obj.fileName+"</span>";
								str+="		<button type='button' data-file='"+fileCallPath+"' data-type='image' class='btn btn-warning btn-circle'>";
								str+="			<i class='fa fa-times'></i>";
								str+="		</button><br>";
								str+="		<img src='/display?fileName="+fileCallPath+"'>";								
								str+="	</div>";
								str+="</li>";	
							}else{//이미지가 아니면
								//파일경로.한글깨지지않게 인코딩
								var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
								str+="<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
								str+="	<div>";
								str+="		<span>"+obj.fileName+"</span>";
								str+="		<button type='button' data-file='"+fileCallPath+"' data-type='file' class='btn btn-warning btn-circle'>";
								str+="			<i class='fa fa-times'></i>";
								str+="		</button><br>";
								str+="		<img src='/resources/img/attach.png'>";								
								str+="	</div>";
								str+="</li>";	
							}
						});
						// ul태그에 출력
						uploadUL.append(str);
						
					}
					
					/* 썸네일을 출력하는 함수 ****************************************************************/
					
				});
			</script>


<!--  contents. end. -->
<%@include file="../includes/footer.jsp"%> 
