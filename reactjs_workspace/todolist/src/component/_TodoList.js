import "./TodoList.css";
import TodoItem from "./TodoItem";
import { useState } from "react"; 

// props를 받아서 처리. 구조분해할당 사용
const TodoList=({todo, onUpdate, onDelete })=>{
  //search state생성. 구조분해할당 사용
  const [search,setSearch]=useState("");
  //search state변경함수
  const onChangeSearch=(e)=>{
    setSearch(e.target.value);
  };
  //검색어가 포함된 데이터만 구하는 함수
  const getSearchResult=()=>{
    //대소문자구분없이 검색
    return search==="" ? todo : todo.filter((it)=>it.content.toLowerCase().includes(search.toLowerCase()));
  };

  return (
    <div className="TodoList">
      <h4>Todo List 🌱</h4>
      <input value={search} onChange={onChangeSearch} className="searchbar" placeholder="검색어를 입력하세요" />
      <div className="list_wrapper">
        {getSearchResult().map((it) => (
          <TodoItem
            key={it.id}
            {...it}
            onUpdate={onUpdate}
            onDelete={onDelete}
          />
        ))}
      </div>     
    </div>
  );
};

export default TodoList;