import TodoItem from "./TodoItem";
import "./TodoList.css";
import { useState } from "react";
import axios from "axios";

const TodoList = ({
  todo,
  onUpdate,
  onDelete,
  onContentUpdate,
  onContentModify,
  onSearch,
}) => {
  //search state생성
  const [search, setSearch] = useState("");
  //검색어를 입력할때마다 호출하는 함수. search를 변경
  const onChangeSearch = (e) => {
    console.log("keyword", e.target.value);
    setSearch(e.target.value); // stae의 setter는 비동기로 처리됨.
    // App component의 검색하는 함수 호출.
    let keyword = e.target.value;
    onSearch(keyword);
  };
  //검색어로 filtering
  // const getSearchResult=()=>{
  //     axios.get("http://127.0.0.1:52273/list")
  //   .then((result)=>{
  //     console.log("############list###############");
  //     console.log(result);
  //     console.log(result.data);
  //     setTodo(result.data);
  //   })
  //   .catch((error)=>{})

  // filter함수의 return값은 배열.
  // return search===""
  //     ? todo
  //     : todo.filter((it)=>  // 대소문자 구분없이 검색
  //         it.content.toLowerCase().includes(search.toLowerCase()));//검색어가 포함된것만 배열에 넣어서 리턴
  //};

  return (
    <div className="TodoList">
      <h4>Todo List 🌱</h4>
      <input
        value={search}
        onChange={onChangeSearch}
        className="searchbar"
        placeholder="검색어를 입력하세요"
      />
      <div className="list_wrapper">
        {todo.map((it) => (
          // 전개구문사용. props를 여러개 전달
          <TodoItem
            key={it.id}
            {...it}
            onUpdate={onUpdate}
            onDelete={onDelete}
            onContentUpdate={onContentUpdate}
            onContentModify={onContentModify}
          />
          // <TodoItem key={it.id} id={it.id} content={it.content} isDone={it.isDone} createdDate={it.createdDate} />
        ))}
      </div>
    </div>
  );
};

export default TodoList;
