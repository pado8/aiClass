console.log("Reply Module........");

//즉시실행함수. 익명함수정의와 동시에 실행.
var replyService = {
    add:function (reply, callback, error) {
      console.log("add reply...............");

    $.ajax({
      type: "post",
      url: "/replies/new",
      data: JSON.stringify(reply),
      contentType: "application/json; charset=utf-8",
      success: function (result, status, xhr) {
        if (callback) {
          callback(result);
        }
      },
      error: function (xhr, status, er) {
        if (error) {
          error(er);
        }
      },
    });
    },  
    getList:function (param, callback, error) {
    var bno = param.bno;
    var page = param.page || 1;

    $.getJSON("/replies/pages/" + bno + "/" + page + ".json", function (data) {
      if (callback) {
        //callback(data); // 댓글 목록만 가져오는 경우
        callback(data.replyCnt, data.list); //댓글 숫자와 목록을 가져오는 경우
      }
    }).fail(function (xhr, status, err) {
      if (error) {
        error();
      }
    });
    },
    remove:function (rno, callback, error) {
    $.ajax({
      type: "delete",
      url: "/replies/" + rno,
      success: function (deleteResult, status, xhr) {
        if (callback) {
          callback(deleteResult);
        }
      },
      error: function (xhr, status, er) {
        if (error) {
          error(er);
        }
      },
    });
    },
    update:function (reply, callback, error) {
    console.log("RNO: " + reply.rno);

    $.ajax({
      type: "put",
      url: "/replies/" + reply.rno,
      data: JSON.stringify(reply),
      contentType: "application/json; charset=utf-8",
      success: function (result, status, xhr) {
        if (callback) {
          callback(result);
        }
      },
      error: function (xhr, status, er) {
        if (error) {
          error(er);
        }
      },
    });
    },
    get:function (rno, callback, error) {
    $.get("/replies/" + rno + ".json", function (result) {
      if (callback) {
        callback(result);
      }
    }).fail(function (xhr, status, err) {
      if (error) {
        error();
      }
    });
     },
    displayTime:function (timeValue) {
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
};
