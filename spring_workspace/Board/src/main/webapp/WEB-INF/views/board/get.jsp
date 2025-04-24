<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp" %>
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
					<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>'
						readonly>
				</div>
				<div class="form-group">
					<label>Title</label>
					<input class="form-control" name="title" value='<c:out value="${board.title}"/>'
						readonly>
				</div>
				<div class="form-group">
					<label>Content</label>
					<textarea class="form-control" rows="3" name="content"
						readonly><c:out value="${board.content}"/></textarea>
				</div>
				<div class="form-group">
					<label>Writer</label>
					<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>'
						readonly>
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

<!-- 댓글목록 -->

<div class='row'>
	<div class="col-lg-12">
		<!-- /.panel -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<ul class="chat">

				</ul>
				<!-- ./ end ul -->
			</div>
			<!-- /.panel .chat-panel -->
			<div class="panel-footer"></div>
		</div>
	</div>
	<!-- ./ end row -->
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label>
					<input class="form-control" name='reply'>
				</div>
				<div class="form-group">
					<label>Replyer</label>
					<input class="form-control" name='replyer'>
				</div>
				<div class="form-group">
					<label>Reply Date</label>
					<input class="form-control" name='replyDate'>
				</div>

			</div>
			<div class="modal-footer">
				<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
				<button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script src="/resources/js/Reply.js"></script>

<script>


	$(document).ready(function () {
		var bnoValue = '<c:out value="${board.bno}"/>'; //부모글번호
		var replyUL = $(".chat"); //댓글목록을 출력하는 ul태그
		showList(1); // 댓글목록을 출력하는 함수.

		//댓글 목록 보여주는 함수
		function showList(page) {
			replyService.getList({ bno: bnoValue, page: page || 1 }, function (replyCnt, list) {
				//댓글등록시 마지막페이지로 이동
				if (page == -1) {
					pageNum = Math.ceil(replyCnt / 10.0);
					showList(pageNum);
					return;
				}
				var str = "";
				//목록이 없으면 종료
				if (list == null || list.length == 0) {
					return;
				}
				// <li>태그를 동적생성
				for (var i = 0, len = list.length || 0; i < len; i++) {
					str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>";
					str += "  <div><div class='header'><strong class='primary-font'>[" + list[i].rno + "] " + list[i].replyer + "</strong>";
					str += "    <small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate) + "</small></div>";
					str += "    <p>" + list[i].reply + "</p></div></li>";
				}
				replyUL.html(str);
				showReplyPage(replyCnt);
			});
		}
		var pageNum = 1;
		var replyPageFooter = $(".panel-footer");

		function showReplyPage(replyCnt) {
			var endNum = Math.ceil(pageNum / 10.0) * 10;
			var startNum = endNum - 9;
			var prev = startNum != 1;
			var next = false;
			if (endNum * 10 >= replyCnt) {
				endNum = Math.ceil(replyCnt / 10.0);
			}
			if (endNum * 10 < replyCnt) { // 끝번호 * 10 보다 댓글갯수가 크면 next 가 존재
				next = true;
			}

			//페이지번호를 출력하는 ul태그 생성
			var str = "<ul class='pagination pull-right'>";
			if (prev) {
				str += "<li class='page-item'><a class='page-link' href='" + (startNum - 1) + "'>Previous</a></li>";
			}
			for (var i = startNum; i <= endNum; i++) {
				var active = pageNum == i ? "active" : "";
				str += "<li class='page-item " + active + " '><a class='page-link' href='" + i + "'>" + i + "</a></li>";
			}
			if (next) {
				str += "<li class='page-item'><a class='page-link' href='" + (endNum + 1) + "'>Next</a></li>";
			}
			str += "</ul></div>";
			replyPageFooter.html(str);
		}

		//delegate.위임 중요 ***
		replyPageFooter.on("click", "li a", function (e) {
			e.preventDefault();
			var targetPageNum = $(this).attr("href");
			pageNum = targetPageNum;
			showList(pageNum);
		});


		// 모달창의 태그들을 미리 찾아놓음
		var modal = $(".modal");
		var modalInputReply = modal.find("input[name='reply']");
		var modalInputReplyer = modal.find("input[name='replyer']");
		var modalInputReplyDate = modal.find("input[name='replyDate']");
		
		var modalModBtn = $("#modalModBtn");
		var modalRemoveBtn = $("#modalRemoveBtn");
		var modalRegisterBtn = $("#modalRegisterBtn");

		$("#modalCloseBtn").on("click", function(e){
			modal.modal('hide');
		});
		// new reply버튼 클릭시 모달창 보이게
		$("#addReplyBtn").on("click", function(e){
			modal.find("input").val("");
			modalInputReplyDate.closest("div").hide();
			modal.find("button[id !='modalCloseBtn']").hide();
			modalRegisterBtn.show();
			$(".modal").modal("show");
		});
		//모달창의 등록버튼 이벤트처리
		modalRegisterBtn.on("click",function(e){
			//전송할 데이터
			var reply = {
				reply: modalInputReply.val(),
				replyer:modalInputReplyer.val(),
				bno:bnoValue
			};
			// Reply.js의 add 함수 호출
			replyService.add(reply, function(result){
				alert(result); //success 알림창 출력
				modal.find("input").val("");// input 태그 초기화
				modal.modal("hide"); //modal창 안보이게
				showList(-1); // 마지막 페이지로 이동. 등록된 글을 보기 위해서.
			});
			
    	});


 		 //댓글 조회 클릭 이벤트 처리 
		$(".chat").on("click", "li", function(e){
			var rno = $(this).data("rno");
			replyService.get(rno, function(reply){
				modalInputReply.val(reply.reply);
				modalInputReplyer.val(reply.replyer);
				modalInputReplyDate.val(replyService.displayTime( reply.replyDate)).attr("readonly","readonly");
				modal.data("rno", reply.rno);
				modal.find("button[id !='modalCloseBtn']").hide();
				modalModBtn.show();
				modalRemoveBtn.show();
				$(".modal").modal("show");
			});
		});

		modalModBtn.on("click", function(e){
		  var reply = {rno:modal.data("rno"), reply: modalInputReply.val()};
		  replyService.update(reply, function(result){
			alert(result);
			modal.modal("hide");
			showList(pageNum);
		  });
		});
 
		modalRemoveBtn.on("click", function (e){
		  var rno = modal.data("rno");
		  replyService.remove(rno, function(result){
			  alert(result);
			  modal.modal("hide");
			  showList(pageNum);
		  });
		});

	});



</script>

<script>
	var bnoValue = '<c:out value="${board.bno}"/>';
	replyService.add({
		reply: "JS Test", replyer: "tester", bno: bnoValue
	}, function (result) {
		console.log(result);
		//alert("RESULT : " + result);
	});


</script>


<script>
	$(document).ready(function () {
		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function () {
			operForm.attr("action", "/board/modify").submit();
		});
		$("button[data-oper='list']").on("click", function () {
			operForm.find("#bno").remove(); //목록에서는 bno가 필요없으므로 삭제
			operForm.attr("action", "/board/list").submit();
		});

	});
</script>


<!--  contents. end. -->
<%@include file="../includes/footer.jsp" %>