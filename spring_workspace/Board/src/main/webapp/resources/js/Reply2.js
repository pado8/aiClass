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
	
	function getList(param, callback, error) {

	    var bno = param.bno; // 부모글번호
	    var page = param.page || 1; //페이지번호
	    
	    $.getJSON("/replies/pages/" + bno + "/" + page + ".json", function(data) {
			// callback함수가 있으면 callback 함수 호출
	          if (callback) {
	            callback(data.replyCnt, data.list);
	          }
	        }).fail(function(xhr, status, err) {
				// error 함수가 있으면 error 함수 호출
	      if (error) {
	        error();
	      }
	    });
	  }
	
	function remove(){}
	
	function update(){}
	
	function get(){}
	
	function displayTime(){}

	return {
		add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get,
		displayTime:displayTime	
		
		
	};

})();