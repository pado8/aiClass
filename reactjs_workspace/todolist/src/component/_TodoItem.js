import "./TodoItem.css";

const TodoItem=({id,content,isDone,createdDate,onUpdate,onDelete})=>{
  //checkbox변경시 호출하는 함수
  const onChangeCheckbox = () => {
    onUpdate(id);
  };
  //삭제버튼클릭시 호출하는 함수
  const onClickDelete = () => {
    onDelete(id);
  };
  
  return (
    <div className="TodoItem">
      <div className="checkbox_col">
        <input onChange={onChangeCheckbox} checked={isDone} type="checkbox" />
      </div>
      <div className="title_col">{content}</div>
      <div className="date_col">{new Date(createdDate).toLocaleDateString()}</div>
      <div className="btn_col">
        <button onClick={onClickDelete}>삭제</button>
      </div>
    </div>
  );
};

export default TodoItem;