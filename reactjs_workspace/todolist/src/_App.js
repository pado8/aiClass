import "./App.css";
import Header from "./component/Header";
import TodoEditor from "./component/TodoEditor";
import TodoList from "./component/TodoList";

import { useState, useRef } from "react";

// mock data
const mockTodo = [
  {
    id: 0, // id는 0부터
    isDone: false,
    content: "React 공부하기",
    createdDate: new Date().getTime(),
  },
  {
    id: 1,
    isDone: false,
    content: "빨래 널기",
    createdDate: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: "노래 연습하기",
    createdDate: new Date().getTime(),
  },
];

function App() {
  //todo state 생성
  const [todo, setTodo] = useState(mockTodo);// mock data사용
  // id ref
  const idRef=useRef(3); // mock data가 2번까지 있으므로 다음 번호 3입력.

  //할일 추가 함수
  const onCreate = (content) => {
    const newItem = {
      id: idRef.current, // idRef의 현재값으로 저장
      content, // content:content 와 같은 의미
      isDone: false,
      createdDate: new Date().getTime(),
    };
    setTodo([newItem, ...todo]); // 추가된 할일먼저 뒤에 기존데이터. 전개구문 사용
    idRef.current+=1; //idRef의 현재값 1증가. 다음 할 일 추가시 사용
  };
  //할일 수정 함수
  const onUpdate = (targetId) => {
    setTodo(
      todo.map((it) =>
        it.id === targetId ? { ...it, isDone: !it.isDone } : it
      )
    );
  };
  //할일 삭제 함수. 삭제할 id를 제외하고 나머지를 구해서 저장.
  const onDelete = (targetId) => {
    setTodo(todo.filter((it) => it.id !== targetId));
  };


  return (
    <div className="App">
      <Header />
      {/* onCreate props에 onCreate 함수명 지정. onCreate(함수명)은 함수를 가리키는 레퍼런스 */}
      <TodoEditor onCreate={onCreate} /> 
      {/* todo를 props를 사용해서 전달 */}
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}
export default App;