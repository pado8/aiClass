import "./App.css";
import Header from "./component/Header";
import TodoEditor from "./component/TodoEditor";
import TodoList from "./component/TodoList";
import { useState, useRef, useEffect } from "react";
import axios from "axios";

// 기본데이터
const mockTodo = [];

function App() {
  const [todo, setTodo] = useState(mockTodo);
  //변경여부 플래그값
  const updateRef = useRef(false);

  /*********************** Ajax 요청 함수 ********************************/
  //목록을 Ajax요청하는 함수
  const getList = () => {
    axios
      .get("http://127.0.0.1:52273/list")
      .then((result) => {
        console.log("############list###############");
        console.log(result);
        console.log(result.data);
        setTodo(result.data);
      })
      .catch((error) => {});
  };
  //키워드 검색 Ajax요청 함수
  const getSearch = (keyword) => {
    axios
      .get("http://127.0.0.1:52273/list/" + keyword)
      .then((result) => {
        console.log("############search###############");
        console.log("keyword", keyword);
        console.log(result);
        console.log(result.data);
        setTodo(result.data);
      })
      .catch((error) => {});
  };
  //content 수정 Ajax요청 함수
  const modifyContent = (targetId, updatedContent) => {
    const formData = new FormData(); //form에 대응하는 객체생성
    formData.append("content", updatedContent);
    axios({
      method: "put",
      url: "http://127.0.0.1:52273/modify/" + targetId,
      data: formData,
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
    })
      .then(() => {
        getList(); //목록갱신
      })
      .catch(() => {});
  };
  /* Ajax요청함수 .끝 */

  //Ajax요청
  useEffect(() => {
    axios
      .get("http://127.0.0.1:52273/list")
      .then((result) => {
        console.log("############list###############");
        console.log(result);
        console.log(result.data);
        setTodo(result.data);
      })
      .catch((error) => {});
  }, []);

  // todo를 추가하는 함수
  const onCreate = (content) => {
    const newItem = {
      id: 0,
      content,
      isDone: false,
      createdDate: new Date().getTime(),
    };
    setTodo([newItem, ...todo]); //전개구문사용

    //Ajax요청
    const formData = new FormData(); //form에 대응되는 객체생성
    formData.append("content", content);
    axios({
      method: "post",
      url: "http://127.0.0.1:52273/regist",
      data: formData,
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
    })
      .then((result) => {
        //insert가 성공했을 때 목록갱신
        getList();
      })
      .catch((error) => {});
  };
  //isDone수정함수
  const onUpdate = (targetId) => {
    // setTodo(
    //   todo.map((it)=>
    //     it.id===targetId?{...it, isDone:!it.isDone } : it
    //   )
    // );
  };
  //todo삭제함수
  const onDelete = (targetId) => {
    //삭제하려는id와 같지 않은것만 필터링
    // setTodo(todo.filter((it)=>it.id!==targetId));
    axios({
      method: "delete",
      url: "http://127.0.0.1:52273/remove/" + targetId,
    })
      .then((result) => {
        console.log("영향을 받은 행의 수 " + result.data.affectedRows);
        //delete가 성공했을 때 목록갱신
        getList();
      })
      .catch((error) => {});
  };
  //todo content변경함수
  const onContentUpdate = (targetId, updatedConent) => {
    setTodo(
      todo.map((it) =>
        it.id === targetId ? { ...it, content: updatedConent } : it
      )
    );
  };
  // content수정시 focusout될 때 실행되는 함수
  const onContentModify = (targetId, updatedConent) => {
    modifyContent(targetId, updatedConent);
  };
  //검색시 호출하는 함수
  const onSearch = (keyword) => {
    getSearch(keyword);
  };

  return (
    <div className="App">
      <Header />
      <TodoEditor onCreate={onCreate} />
      <TodoList
        todo={todo}
        onUpdate={onUpdate}
        onDelete={onDelete}
        onContentUpdate={onContentUpdate}
        onContentModify={onContentModify}
        onSearch={onSearch}
      />
    </div>
  );
}

export default App;
