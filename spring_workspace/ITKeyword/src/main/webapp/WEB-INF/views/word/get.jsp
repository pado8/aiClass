<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Read</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

        <div class="form-group">
          <label>no</label> <input class="form-control" name='no' value='<c:out value="${board.no }"/>' readonly>
        </div>

        <div class="form-group">
          <label>keyword</label> <input class="form-control" name='keyword' value='<c:out value="${board.keyword }"/>' readonly>
        </div>

        <div class="form-group">
          <label>description</label>
          <textarea class="form-control" rows="3" name='description' readonly="readonly"><c:out value="${board.description}" /></textarea>
        </div>

        <!-- <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer' value='<c:out value="${board.writer }"/>' readonly>
        </div> -->
	
		<button data-oper='modify' class="btn btn-default">Modify</button>
		<button data-oper='list' class="btn btn-info">List</button>
		
		<form id='operForm' action="/word/modify" method="get">
		  <input type='hidden' id='no' name='no' value='<c:out value="${board.no}"/>'>
		  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
		  <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
		  <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
		  <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
		 
		</form>
	


      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
  var operForm = $("#operForm"); 
  $("button[data-oper='modify']").on("click", function(e){
    operForm.attr("action","/word/modify").submit();
  });
  $("button[data-oper='list']").on("click", function(e){
    operForm.find("#no").remove();
    operForm.attr("action","/word/list").submit();
  });  
});
</script>


<%@include file="../includes/footer.jsp"%>
