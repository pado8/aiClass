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
                            List
                            <a href="/board/register" class="btn btn-primary btn-xs pull-right">Register</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th class="text-center">번호</th>
                                        <th width="50%">제목</th>
                                        <th class="text-center">작성자</th>
                                        <th class="text-center">작성일</th>
                                        <th class="text-center">수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="board">
                                    <tr>
                                        <td class="text-center"><c:out value="${board.bno}"/></td>
                                        <td>
	                                        <a class="move" href='<c:out value="${board.bno}"/>'>
	                                        	<c:out value="${board.title}"/>  <b>[  <c:out value="${board.replyCnt}" />  ]</b>
	                                        </a>
                                        </td>
                                        <td class="text-center"><c:out value="${board.writer}"/></td>
                                        <td class="text-center">
											<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/>
										</td>
										<td class="text-center">
											<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/>
                                        </td>
                                    </tr>
                                </c:forEach>    
                                    
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
                            <!-- 검색폼 ----------------------------------------------------------------------->
                            <div class="row">
                            	<div class="col-lg-12">
                            		<form id="searchForm" action="/board/list" method="get">
                            			<select name="type">
                            				<option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
                            				<option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
                            				<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 &amp; 내용</option>
                            			</select>
                            			<input name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>'>
                            			<input type="hidden" name="pageNum" value='<c:out value="${pageMaker.cri.pageNum}"/>'>
                            			<input type="hidden" name="amount" value='<c:out value="${pageMaker.cri.amount}"/>'>
                            			<button class="btn btn-default">Search</button>
                            		</form>
                            	</div>
                            </div>
                            
                            
                            <!-- 페이지번호 생성 ---------------------------------------------------------------->
                            <div class="pull-right">
                            	<ul class="pagination">
                            		<c:if test="${pageMaker.prev}">
                            			<li class="paginate_button previous">
                            				<a href="${pageMaker.startPage-1}">Previous</a>
                            			</li>
                            		</c:if>
                            		
                            		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                            			<li class='paginate_button ${pageMaker.cri.pageNum==num?"active":""}'>
                            				<a href="${num}">${num}</a>
                            			</li>
                            		</c:forEach>                            		
                            		
                            		
                            		<c:if test="${pageMaker.next}">
                            			<li class="paginate_button next">
                            				<a href="${pageMaker.endPage+1}">Next</a>
                            			</li>
                            		</c:if>
                            	</ul>
                            </div>
                            
                            
                            
                            <!-- 전송폼 ---------------------------------------------------------------------->
                            <form id="actionForm" action="/board/list">
                            	<input type="hidden" name="pageNum" value='${pageMaker.cri.pageNum}'>
                            	<input type="hidden" name="amount" value='${pageMaker.cri.amount}'>
                            	<input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type }"/>'>
                            	<input type='hidden' name='keyword'	value='<c:out value="${ pageMaker.cri.keyword }"/>'>
                            </form>
                           
                           
                           <!-- Modal  추가 ------------------------------------------------------------------>
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">알림</h4>
										</div>
										<div class="modal-body">처리가 완료되었습니다.</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>											
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal. end -------------------------------------------- -->
                           
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

<script>
	$(document).ready(function(){
		var result='<c:out value="${result}"/>';
		
		checkModal(result);
		
		function checkModal(result){
			if(result===''){
				return;
			}
			if(parseInt(result)>0){
				$(".modal-body").html("게시글"+parseInt(result)+"번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
		
		/* Event 처리 **************************************************************************************/
		var actionForm = $("#actionForm");
		$(".move").on("click",function(e){
			e.preventDefault();// 링크를 클릭했을 때 기본 이벤트처리(링크는 다른 페이지로 넘어가는 동작이 기본)를 취소.
			actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>"); // form에 히든태그추가
			actionForm.attr("action","/board/get"); // form에 action을 변경
			actionForm.submit(); // form전송
		});
		
		$(".paginate_button a").on("click",function(e){
			e.preventDefault(); //링크를 클릭했을 때 기본 이벤트처리(링크는 다른 페이지로 넘어가는 동작이 기본)를 취소.
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit(); //form전송
		});
		
		var searchForm=$("#searchForm");
		$(searchForm).find("button").on("click",function(e){
			e.preventDefault();//폼 전송방지
			
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			searchForm.find("input[name='pageNum']").val("1");
			
			searchForm.submit(); //폼전송
		});
		
	});
</script>


<!--  contents. end. -->
<%@include file="../includes/footer.jsp"%> 
