var replyService=(function(){
	function add(reply, callback, error){
		$.ajax({
			type:"post", //전송방식
			url:"/replies/new", //서버주소
			data:JSON.stringify(reply), //서버로 전달되는 데이터
			contentType:"application/json; charset=utf-8", //서버에서 넘어오는 데이터의 형식
			success:function(result,status,xhr){ // sucess일 때 호출되는 함수				
				if(callback){					
					callback(result);
				}
			},
			error:function(xhr,status,er){ // error일 때 호출되는 함수. 책에서 사용 안함.
				if(error){
					error(er);
				}
			}
			
		});
	}
	
	function getList(param,callback,error){
		var bno=param.bno; //부모글번호
		var page=param.page || 1; //페이지번호
		
		$.getJSON("/replies/pages/"+bno+"/"+page+".json",function(data){
			//callback함수가 있으면 callback함수 호출
			if(callback){
				callback(data.replyCnt, data.list);
			}
		}).fail(function(xhr,status,err){
			// error함수가 있으면 error함수 호출
			if(error){
				error();
			}
		});
		
	
	}
	
	function remove(rno,callback,error){
		$.ajax({
			type:"delete", // 전송방식
			url:"/replies/"+rno, // 서버주소
			success:function(deleteResult,status,xhr){ //성공했을 때 호출하는 함수
				if(callback){
					callback(deleteResult);
				}
			},
			error:function(xhr,status,er){ //에러났을 때 호출하는 함수
				if(error){
					error(er);
				}
			}
		});
	
	}
	
	function update(reply,callback,error){
		$.ajax({
			type:"put", //전송방식
			url: "/replies/"+reply.rno, //서버주소
			data:JSON.stringify(reply), // 서버에 전달할 데이터
			contentType:"application/json; charset=utf-8", // 서버에서 넘어오는 데이터의 타입
			success:function(result,status,xhr){ // 성공일때 호출하는 함수
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){ // 에러일때 호출하는 함수
				if(error){
					error(er);
				}
			}
		});
	}
	
	function get(rno,callback,error){
		// $.get()은 get방식 처리 전용 함수
		$.get("/replies/"+rno+".json",function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	
	function displayTime(timeValue){
		 var today = new Date();

	    var gap = today.getTime() - timeValue;
	
	    var dateObj = new Date(timeValue);
	    var str = "";
	
	    //댓글을 작성한지 24시간이 안됐으면 시:분:초 만 출력
	    if (gap < 1000 * 60 * 60 * 24) {
	      var hh = dateObj.getHours();
	      var mi = dateObj.getMinutes();
	      var ss = dateObj.getSeconds();
	
	      return [
	        (hh > 9 ? "" : "0") + hh,
	        ":",
	        (mi > 9 ? "" : "0") + mi,
	        ":",
	        (ss > 9 ? "" : "0") + ss,
	      ].join("");
	    } else {
	      var yy = dateObj.getFullYear();
	      var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
	      var dd = dateObj.getDate();
	
	      return [
	        yy,
	        "/",
	        (mm > 9 ? "" : "0") + mm,
	        "/",
	        (dd > 9 ? "" : "0") + dd,
	      ].join("");
	    }
	}

	return {
		add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get,
		displayTime:displayTime	
		
		
	};

})();