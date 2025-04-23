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
                            Read
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">                           	
                        	<div class="form-group">
	                        	<label>Bno</label>
	                        	<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly> 
                        	</div>
                        	<div class="form-group">
	                        	<label>Title</label>
	                        	<input class="form-control" name="title" value='<c:out value="${board.title}"/>' readonly> 
                        	</div>
                        	<div class="form-group">
	                        	<label>Content</label>
	                        	<textarea class="form-control" rows="3" name="content" readonly><c:out value="${board.content}"/></textarea> 
                        	</div>
                        	<div class="form-group">
	                        	<label>Writer</label>
	                        	<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly> 
                        	</div>
                        	<button data-oper="modify" class="btn btn-default">Modify</button>
                        	<button data-oper="list" class="btn btn-default">List</button> 
                        	
                        	<!-- 전송에 사용되는 Form ------------------------------------------->
                        	<form id="operForm" action="/board/modify" method="get">
                        	  <input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
                       		  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
							  <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
							  <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
							  <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>  
                        	
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
            		var operForm=$("#operForm");
            		$("button[data-oper='modify']").on("click",function(){
            			operForm.attr("action","/board/modify").submit();
            		});
            		$("button[data-oper='list']").on("click",function(){
            			operForm.find("#bno").remove(); //목록에서는 bno가 필요없으므로 삭제
            			operForm.attr("action","/board/list").submit();
            		});
            		
            	});
            </script>


<!--  contents. end. -->
<%@include file="../includes/footer.jsp"%> 
