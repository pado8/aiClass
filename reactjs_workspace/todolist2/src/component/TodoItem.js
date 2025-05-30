import "./TodoItem.css";

const TodoItem=({id,content,isDone,createdDate,onUpdate,onDelete,onContentUpdate,onContentModify})=>{

    //체크박스변경시 실행되는 함수
    const onChangeCheckbox=(e)=>{
        onUpdate(id,e.target.checked); //app component의 onUpdate함수 호출
    };
    //삭제버튼시 실행되는 함수
    const onClickDelete=()=>{
        onDelete(id); //app component의 onDelete함수 호출
    };
    //Todo변경시 실행되는 함수
    const onInputChange=(e)=>{
        onContentUpdate(id,e.target.value); // app component의 onContentUpdate호출
    };
    //Enter키를 눌렀을 때 호출하는 함수
    const onKeyDown=(e)=>{
        console.log("====keydown=========================")
        if(e.keyCode==13){ // 13번은 enter key
            console.log("엔터키");
            console.log(id,e.target.value);
            // onContentModify(id,e.target.value); // app component의 onContentModify호출
            e.target.blur(); // focusout
        }
    };
    //content수정후 blur시 호출하는 함수
    const onBlur=(e)=>{
        console.log("====Blur=========================");
        onContentModify(id,e.target.value); // app component의 onContentModify호출
    };

    

    return (
        <div className="TodoItem">
            <div className="checkbox_col">
                <input type="checkbox" checked={isDone} onChange={onChangeCheckbox}/>
            </div>
            <input className="title_col" value={content} onChange={onInputChange} onKeyDown={onKeyDown} onBlur={onBlur}/>
            <div className="date_col">{new Date(createdDate).toLocaleDateString()}</div>
            <div>
                <button className="btn btn-primary" onClick={onClickDelete}>삭제</button>
            </div>
        </div>
    );
}

export default TodoItem;