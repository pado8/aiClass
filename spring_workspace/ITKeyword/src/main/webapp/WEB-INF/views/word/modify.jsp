<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Modify</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

		<form role="form" action="/word/modify" method="post">
      
	        <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
	        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
		    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
			<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
			 
			<div class="form-group">
			  <label>Bno</label> 
			  <input class="form-control" name='no' 
			     value='<c:out value="${board.no }"/>' readonly="readonly">
			</div>
			
			<div class="form-group">
			  <label>Title</label> 
			  <input class="form-control" name='keyword' 
			    value='<c:out value="${board.keyword }"/>' >
			</div>
			
			<div class="form-group">
			  <label>Text area</label>
			  <textarea class="form-control" rows="3" name='description' ><c:out value="${board.description}"/></textarea>
			</div>
			
			<div class="form-group">
			  <label>Writer</label> 
			  <input class="form-control" name='writer'
			    value='<c:out value="${board.writer}"/>' readonly="readonly">            
			</div>
			
			<div class="form-group">
			  <label>RegDate</label> 
			  <input class="form-control" name='regDate'
			    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regdate}" />'  readonly="readonly">            
			</div>
			
			<div class="form-group">
			  <label>Update Date</label> 
			  <input class="form-control" name='updateDate'
			    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.updateDate}" />'  readonly="readonly">            
			</div>
			
			<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
			<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
			<button type="submit" data-oper='list' class="btn btn-info">List</button>
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


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/word/remove");
	      
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action", "/word/list").attr("method","get");
	      
	      var pageNumTag = $("input[name='pageNum']").clone();
	      var amountTag = $("input[name='amount']").clone();
	      var keywordTag = $("input[name='keyword']").clone();
	      var typeTag = $("input[name='type']").clone();      
	      
	      formObj.empty();
	      
	      formObj.append(pageNumTag);
	      formObj.append(amountTag);
	      formObj.append(keywordTag);
	      formObj.append(typeTag);	       
	    }
	    
	    formObj.submit();
	  });

});
</script>
  




<%@include file="../includes/footer.jsp"%>
