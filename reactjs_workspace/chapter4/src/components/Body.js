// import "./Body.css";
// hook이란 추가된 기능이라는 뜻
// function 컴포넌트에서는 처음에 state 를 사용할 수 없었음
// 후에 추가된 기능 (hook)
import { useState, useRef } from "react"; //useState hook import

// props를 구조분해할당해서 처리
// function Body({name, location, favorList=[]}) {
//     console.log(name, location, favorList);
//     return(
//        <>
//             {/* <div style={{backgroundColor:"cyan",color:"blue"}}> */}
//             <div className="body">
//                 {/* <h1>body</h1> */}
//                 {name}은 {location}에 거주합니다.
//                 <br/>
//                 {favorList.length}개의 음식을 좋아합니다.
//             </div>
//        </>
//     );
// }

// function Body({children}) {
//     return <div className="body">{children}</div>
// }
// function Body() {
//     // innder function
//     function handleOnClick(e) {
//         console.log(e);
//         console.log(e.target.name);
//     }

//     return (
//         <div className="body">
//             <button name="A버튼" onClick={handleOnClick}>
//                 A버튼
//             </button>
//             <button name="B버튼" onClick={handleOnClick}>
//                 B버튼
//             </button>
//         </div>
//     );
// }

// function Body() {
//     // count state 생성
//     const [count, setCount] = useState(0); //구조분해할당사용. count 의 초기값 0 setCount 는 setter 

//     // event처리 count 변경
//     const onIncrease = () => {
//         setCount(count + 1);
//     };

//     return (
//         <div>
//             <div>
//                 {/* count state와 binding */}
//                 <h2>{count}</h2>
//                 <button onClick={onIncrease}>+</button>
//             </div>
//         </div>
//         );
// }

// ***********************************************************************************************************************************
// function Body() {
//     // 객체형태 state 생성. 구조분해할당 사용
//     const [state, setState] = useState({
//         name: "",
//         gender: "",
//         birth: "",
//         bio: ""
//     });
//     // 이벤트 처리 함수. state를 변경
//     const handleOnChange = (e) => {
//         console.log("현재 수정 대상:", e.target.name);
//         console.log("수정값:", e.target.value);
//         setState({
//             ...state,
//             [e.target.name]: e.target.value,
//         });
//     };
//     return (
//         <div>
//             <div>
//                 <input name="name" value={state.name} onChange={handleOnChange} placeholder="이름" />
//             </div>
//             <div>
//                 <select name="gender" value={state.gender} onChange={handleOnChange} >
//                     <option value="">성별</option>
//                     <option value="남자">남자</option>
//                     <option value="여자">여자</option>
//                 </select>
//             </div>
//             <div>
//                 <input name="birth" type="date" value={state.birth} onChange={handleOnChange} />
//             </div>
//             <div>
//                 <textarea name="bio" value={state.bio} onChange={handleOnChange} placeholder="자기소개"></textarea>
//             </div>
//         </div>
//     )
// }
// ***********************************************************************************************************************************
// function Viewer({ number }) {
//     console.log("viewer render");
//   return <div>{number % 2 === 0 ? <h3>짝수</h3> : <h3>홀수</h3>}</div>;
// }

// function Body() {
//   const [number, setNumber] = useState(0);

//   const onIncrease = () => {
//     setNumber(number + 1);
//   };
//   const onDecrease = () => {
//     setNumber(number - 1);
//   };

//   return (
//     <div>
//       <h2>{number}</h2>
//       <Viewer number={number} />
//       <div>
//         <button onClick={onDecrease}>-</button>
//         <button onClick={onIncrease}>+</button>
//       </div>
//     </div>
//   );
// }
// ***********************************************************************************************************************************
function Body() {
  const [text, setText] = useState("");
  const textRef = useRef();

  const handleOnChange = (e) => {
    setText(e.target.value); //text state 변경
  };
  const handleOnClick = () => {
      if (text.length < 5) { 
    //   textRef.current.focus(); //input 태그에 focus주기
      textRef.current.select(); //input 태그에 select주기
    } else {
      alert(text);
      setText(""); //text state 값 초기화 => input 태그의 value와 binding 되어 있으므로, input 초기화
    }
  };

  return (
    <div>
        {/* input 태그를 textRef가 가리키도록 설정 */}
      <input ref={textRef} value={text} onChange={handleOnChange} />
      <button onClick={handleOnClick}>작성 완료</button>
    </div>
  );
}
// ***********************************************************************************************************************************

export default Body; //외부에서 접근 가능 하도록.