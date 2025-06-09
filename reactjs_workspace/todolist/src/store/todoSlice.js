
import { createSlice } from '@reduxjs/toolkit';

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

let idRef=3; // mock data가 2번까지 있으므로 다음 번호 3입력.

const todoSlice = createSlice({
  name: 'todo',
  initialState : mockTodo,
  reducers: {
    onCreate: (state, action) => {
      const newItem = {
        id: idRef++, // idRef의 현재값으로 저장후 1증가
        content:action.payload, //action.payload는 전달되는 데이터
        isDone: false,
        createdDate: new Date().getTime(),
      };

      state.unshift(newItem); // 새로운 할일 배열 앞부분에 추가     
    },
    onUpdate: (state, action) => {
      const todo = state.find((it) => it.id === action.payload);
      if (todo){
        todo.isDone = !todo.isDone;
      } 
    },
    onDelete: (state, action) => {     
      return state.filter((it) => it.id !== action.payload);
    },
   
  },
});

export const { onCreate, onUpdate, onDelete} = todoSlice.actions;
export default todoSlice.reducer;
