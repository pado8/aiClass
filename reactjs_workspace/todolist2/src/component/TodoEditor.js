import { useState, useRef } from 'react';
import './TodoEditor.css';

const TodoEditor=({onCreate})=>{
    // content state생성
    const [content,setContent]=useState("");
    // content를 변경하는 함수
    const onChangeContent=(e)=>{
        setContent(e.target.value);
    }

    // input태그를 가리키는 ref생성
    const inputRef=useRef();

    //등록버튼을 눌렀을 때 실행되는 함수
    const onSubmit=()=>{
        //content값이 없으면 input 태그에 focus
        if(!content){
            alert("Todo를 입력하세요");
            inputRef.current.focus();
            return;
        }
        onCreate(content); // 부모컴포넌트 App에 있는 onCreate함수가 호출됨
        setContent(""); // content값을 초기화해서 input 태그 초기화
    };
    //Enter키를 눌렀을 때 호출하는 함수
    const onKeyDown=(e)=>{
        if(e.keyCode==13){ // 13번은 enter key
            onSubmit();
        }
    };

    return (
        <div className="TodoEditor">
            <h4>새로운 Todo 작성하기 ✏️</h4>
            <div className="editor_wrapper">
                <input ref={inputRef} value={content} 
                    onChange={onChangeContent} 
                    onKeyDown={onKeyDown}
                    placeholder="새로운 todo를 입력하세요"/>
                <button onClick={onSubmit}>추가</button>
            </div>
        </div>
    );
};

export default TodoEditor;