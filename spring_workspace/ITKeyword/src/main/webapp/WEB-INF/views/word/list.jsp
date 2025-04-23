<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>
<!-- contnents -->

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
                            List
                            <a href="/word/register" class="btn btn-primary btn-xs pull-right">Register</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" >
                                <thead>
                                    <tr>
                                       	<th>번호</th>
										<th>단어</th>
										<th>뜻</th>
										<th>작성일</th>
										<!-- <th>수정일</th> -->
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${list}" var="board">
	                                    <tr>
	                                       	<td><c:out value="${board.no}" /></td>
											<td><a href='/word/get?no=<c:out value="${board.no}"/>'><c:out value="${board.keyword}"/></a></td>
											<%-- <td>
												<a class='move' href='<c:out value="${board.no}"/>'>
													<c:out value="${board.keyword}" />
												</a>
											</td> --%>
											<!-- <td><c:out value="${board.writer}" /></td> -->
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
											<!-- <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td> -->
	                                    </tr>
									</c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
                            <!-- 검색폼 -->
                            <div class="row">
								<col-lg-12>
									<form id="searchForm" action="/word/list" method="get">
										<select name="type">
											<option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>단어</option>
											<option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>뜻</option>
											<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>단어 &amp; 뜻</option>
										</select>
										<input name="searchkeyword" value='<c:out value="${pageMaker.cri.searchkeyword}"/>'>
										<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum}"/>'>
										<input type="hidden" name="amount" value='<c:out value="${pageMaker.cri.amount}"/>'>
										<button class="btn btn-default">Search</button>
									</form>
								</col-lg-12>
							</div>
                            
                            
                            <!-- 페이지 번호 생성 -->
                            
                            <div class='pull-right'>
								<ul class="pagination">
			
									<c:if test="${pageMaker.prev}">
										<li class="paginate_button previous"><a
											href="${pageMaker.startPage -1}">Previous</a></li>
									</c:if>
			
									<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
										<li class='paginate_button ${pageMaker.cri.pageNum == num ? "active":""}'>
											<a href="/word/list?pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&searchkeyword=${pageMaker.cri.searchkeyword}">${num}</a>
										</li>
									</c:forEach>
			
									<c:if test="${pageMaker.next}">
										<li class="paginate_button next"><a
											href="${pageMaker.endPage +1 }">Next</a></li>
									</c:if>
			
			
								</ul>
							</div>
							<!--  end Pagination -->
                            
                            <!-- 전송폼 -->
                            <form id='actionForm' action="/word/list" method='get'>
								<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
								<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
				
								<input type='hidden' name='type'
									value='<c:out value="${ pageMaker.cri.type }"/>'> <input
									type='hidden' name='keyword'
									value='<c:out value="${ pageMaker.cri.keyword }"/>'>
							</form>
                            
                            
                            <!-- Modal  추가 -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">알림</h4>
										</div>
										<div class="modal-body">처리가 완료되었습니다.</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

  <script>
    $(document).ready(function() {
       var result = '<c:out value="${result}"/>';
       checkModal(result);
       function checkModal(result) {
	       if (result === '' || history.state) {
				return;
			}
	
			if (parseInt(result) > 0) {
				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
       }
       var actionForm = $("#actionForm");
       $(".move").on("click", function(e){
    	   e.preventDefault(); // 링크를 클릭했을때 기본 이벤트처리(링크는 다른 페이지로 넘어가는 동작이 기본)을 취소
    	   actionForm.append("<input type='hidden' name='no' value='"+$(this).attr("href")+"'>");
    	   actionForm.attr("action","/word/get");
    	   actionForm.submit();
   	   });
       
   		$("#searchForm button").on("click",	function(e) {

				if (!searchForm.find("option:selected")
						.val()) {
					alert("검색종류를 선택하세요");
					return false;
				}

				if (!searchForm.find(
						"input[name='searchkeyword']").val()) {
					alert("키워드를 입력하세요");
					return false;
				}

				searchForm.find("input[name='pageNum']").val("1");
				e.preventDefault();

				searchForm.submit();

			});
       
       
    });
    </script>


<!-- contnents end -->
<%@include file="../includes/footer.jsp"%>