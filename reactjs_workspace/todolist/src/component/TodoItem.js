import "./TodoItem.css";
import { useDispatch } from "react-redux";
import { onUpdate, onDelete } from "../store/todoSlice";

const TodoItem=({id,content,isDone,createdDate})=>{  

  const dispatch = useDispatch();
  
  return (
    <div className="TodoItem">
      <div className="checkbox_col">
        <input onChange={() => dispatch(onUpdate(id))} checked={isDone} type="checkbox" />
      </div>
      <div className="title_col">{content}</div>
      <div className="date_col">{new Date(createdDate).toLocaleDateString()}</div>
      <div className="btn_col">
        <button onClick={() => dispatch(onDelete(id))}>삭제</button>
      </div>
    </div>
  );
};

export default TodoItem;