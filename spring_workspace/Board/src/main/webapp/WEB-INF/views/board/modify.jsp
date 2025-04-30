<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<%@include file="../includes/header.jsp"%>   
<!-- cotnents --------------------------------------------------------->

<style>
.uploadResult {
  width:100%;
  background-color: gray;
}
.uploadResult ul{
  display:flex;
  flex-flow: row;
  justify-content: center;
  align-items: center;
}
.uploadResult ul li {
  list-style: none;
  padding: 10px;
  align-content: center;
  text-align: center;
}
.uploadResult ul li img{
  width: 100px;
}
.uploadResult ul li span {
  color:white;
}
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
  background:rgba(255,255,255,0.5);
}
.bigPicture {
  position: relative;
  display:flex;
  justify-content: center;
  align-items: center;
}

.bigPicture img {
  width:600px;
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
                            Modify
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">    
                        
                        	<form action="/board/modify" method="post">
							    
							    <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
						        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
							    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
								<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>                   	
	                        	
	                        	<div class="form-group">
		                        	<label>Bno</label>
		                        	<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly> 
	                        	</div>
	                        	<div class="form-group">
		                        	<label>Title</label>
		                        	<input class="form-control" name="title" value='<c:out value="${board.title}"/>'> 
	                        	</div>
	                        	<div class="form-group">
		                        	<label>Content</label>
		                        	<textarea class="form-control" rows="3" name="content"><c:out value="${board.content}"/></textarea> 
	                        	</div>
	                        	<div class="form-group">
		                        	<label>Writer</label>
		                        	<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>'> 
	                        	</div>
	                        	<div class="form-group">
		                        	<label>RegDate</label>
		                        	<input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}"/>' readonly> 
	                        	</div>
	                        	<div class="form-group">
		                        	<label>updateDate</label>
		                        	<input class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>' readonly> 
	                        	</div>
	                        	
	                        	<!-- 첨부파일목록 ---------------------------------------------------->
	                        	<div class="row">
								  <div class="col-lg-12">
								    <div class="panel panel-default">
								
								      <div class="panel-heading">Files</div>
								      <!-- /.panel-heading -->
								      <div class="panel-body">
								        <div class="form-group uploadDiv">
								            <input type="file" name='uploadFile' multiple="multiple">
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
	                        	
	                        	<button data-oper="modify" class="btn btn-default">Modify</button>
	                        	<button data-oper="remove" class="btn btn-default">Remove</button>
	                        	<button data-oper="list" class="btn btn-default">List</button> 
	                        	
                        	</form>
                        	
                        	
                        	
                        	                          
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <!-- 원본이미지보기 ------------------------------------------------------->
            <div class='bigPictureWrapper'>
			  <div class='bigPicture'>
			  </div>
			</div>
			
			
            <script>
            	$(document).ready(function(){
            		
            		/* 첨부파일목록 ---------------------------------------------------------------------*/
            		var bno = '<c:out value="${board.bno}"/>';
    
				    $.getJSON("/board/getAttachList", {bno: bno}, function(arr){				    
				      console.log(arr);				      
				      var str = "";				
				
				      $(arr).each(function(i, attach){				          
				          //image type
				          if(attach.fileType){
				            var fileCallPath =  encodeURIComponent( attach.uploadPath+ "/s_"+attach.uuid +"_"+attach.fileName);
				            
				            str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' "
				            str +=" data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"' ><div>";
				            str += "<span> "+ attach.fileName+"</span>";
				            str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' "
				            str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
				            str += "<img src='/display?fileName="+fileCallPath+"'>";
				            str += "</div>";
				            str +"</li>";
				          }else{
				              
				            str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' "
				            str += "data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"' ><div>";
				            str += "<span> "+ attach.fileName+"</span><br/>";
				            str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' "
				            str += " class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
				            str += "<img src='/resources/img/attach.png'></a>";
				            str += "</div>";
				            str +"</li>";
				          }
				       });
								      
				      $(".uploadResult ul").html(str);
				      
				    });//end getjson
				    /* 첨부파일목록.end --------------------------------------------------*/
            		
            		/* event처리 --------------------------------------------------------------------*/
            		
            		// 'x'버튼 클릭시 이벤트 처리. 화면에서만 삭제. 실제파일은 삭제하지 않음
            		$(".uploadResult").on("click","button",function(){
            			if(confirm("Remove this file?")){
            				var targetLi=$(this).closest("li"); // 가장 가까이 있는 부모태그 li 삭제
            				targetLi.remove();
            			}
            		});
				    
				  // 파일확장자체크
            	  var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
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
           		  
           		  //첨부파일업로드
           		  $("input[type='file']").change(function(e){
           		    var formData = new FormData();           		    
           		    var inputFile = $("input[name='uploadFile']");           		    
           		    var files = inputFile[0].files;
           		    
           		    for(var i = 0; i < files.length; i++){

           		      if(!checkExtension(files[i].name, files[i].size) ){
           		        return false;
           		      }
           		      formData.append("uploadFile", files[i]);
           		      
           		    }
           		    
           		    $.ajax({
           		      url: '/uploadAjaxAction',
           		      processData: false, 
           		      contentType: false,data: 
           		      formData,type: 'POST',
           		      dataType:'json',
           		        success: function(result){
           		          console.log(result); 
           				  showUploadResult(result); //업로드 결과 처리 함수 

           		      }
           		    }); //$.ajax
           		    
           		  });    

           		  //썸네일 출력 함수
           		  function showUploadResult(uploadResultArr){           			    
           		    if(!uploadResultArr || uploadResultArr.length == 0){ return; }           		    
           		    var uploadUL = $(".uploadResult ul");           		    
           		    var str ="";
           		    
           		    $(uploadResultArr).each(function(i, obj){           				
           				if(obj.image){
           					var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid +"_"+obj.fileName);
           					str += "<li data-path='"+obj.uploadPath+"'";
           					str +=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'"
           					str +" ><div>";
           					str += "<span> "+ obj.fileName+"</span>";
           					str += "<button type='button' data-file=\'"+fileCallPath+"\' "
           					str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
           					str += "<img src='/display?fileName="+fileCallPath+"'>";
           					str += "</div>";
           					str +"</li>";
           				}else{
           					var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);			      
           				    var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
           				      
           					str += "<li "
           					str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
           					str += "<span> "+ obj.fileName+"</span>";
           					str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' " 
           					str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
           					str += "<img src='/resources/img/attach.png'></a>";
           					str += "</div>";
           					str +"</li>";
           				}
           		    });
           		    
           		    uploadUL.append(str);
           		  }
			    
			                		
            		//삭제,목록,수정 버튼 이벤트처리
            		var formObj=$("form"); //form을 미리 찾아놓음
            		$("button").on("click",function(e){
            			e.preventDefault(); //전송방지
            			var operation=$(this).data("oper"); // data-oper 사용자속성의 값을 구함
            			if(operation==="remove"){
            				formObj.attr("action","/board/remove"); // action을 '/board/remove' 로 변경
            			}else if(operation==="list"){
            				formObj.attr("action","/board/list").attr("method","get"); // action을 '/board/list' 로 변경. 전송방식 get을 변경
            				
            				//hidden tag들을 먼저 복제해둔다.
	           				var pageNumTag = $("input[name='pageNum']").clone();
	         			    var amountTag = $("input[name='amount']").clone();
	         			    var keywordTag = $("input[name='keyword']").clone();
	         			    var typeTag = $("input[name='type']").clone();      
	         			    
	         			    //form태그 안의 자식태그들을 모두 삭제
	         			    formObj.empty();
	         			    
	         			    //hidden tag들을 다시 form에 추가
	         			    formObj.append(pageNumTag);
	         			    formObj.append(amountTag);
	         			    formObj.append(keywordTag);
	         			    formObj.append(typeTag);	  
            			}else if(operation=="modify"){
            				 
            		        var str = "";            		        
            		        $(".uploadResult ul li").each(function(i, obj){            		          
            		          var jobj = $(obj);            		          
            		          console.dir(jobj);
            		          
            		          str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
            		          str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
            		          str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
            		          str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+ jobj.data("type")+"'>";
            		          
            		        });
            		        formObj.append(str).submit();
            			}
            			formObj.submit();
            		});
            		
            		
            		
            	});
            </script>


<!--  contents. end. -->
<%@include file="../includes/footer.jsp"%> 
