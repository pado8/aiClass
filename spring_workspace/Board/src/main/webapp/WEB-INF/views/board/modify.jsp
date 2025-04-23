<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<%@include file="../includes/header.jsp"%>   
<!-- cotnents --------------------------------------------------------->

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
            
            <script>
            	$(document).ready(function(){
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
            			}
            			formObj.submit();
            		});
            	});
            </script>


<!--  contents. end. -->
<%@include file="../includes/footer.jsp"%> 
