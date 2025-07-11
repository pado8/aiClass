import "./TodoEditor.css";
import { useState, useRef } from "react";
import { useDispatch } from "react-redux";
import { onCreate } from "../store/todoSlice";

const TodoEditor=()=>{

  const dispatch = useDispatch(); //dispatch

  const [content, setContent] = useState("");//content state
  const inputRef = useRef(); // input 태그를 가리키는 ref   

  // cotent 변경 함수
  const onChangeContent = (e) => {
    setContent(e.target.value);
  };
  // 추가버튼 클릭시 호출되는 함수
  const onSubmit=()=>{
    //content가 없으면 focus처리
    if(!content){
      inputRef.current.focus();
      return;
    }
    
    dispatch(onCreate(content)); // dispatch

    setContent(""); // content state초기화=>input 태그 초기화
  }
  //enter키 누를 때 처리
   const onKeyDown = (e) => {
    if (e.keyCode === 13) {
      onSubmit();
    }
  };

  return (
    <div className="TodoEditor">
      <h4>새로운 Todo 작성하기 ✏️ </h4>
      <div className="editor_wrapper">
        <input ref={inputRef} value={content} onChange={onChangeContent} onKeyDown={onKeyDown} placeholder="새로운 Todo..." />
        <button onClick={onSubmit}>추가</button>
      </div>
    </div>
  );
};

export default TodoEditor;