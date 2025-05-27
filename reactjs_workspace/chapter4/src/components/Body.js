// import "./Body.css";
// hook이란 추가된 기능이라는 뜻
// function 컴포넌트에서는 처음에 state 를 사용할 수 없었음
// 후에 추가된 기능 (hook)
import { useState } from "react"; //useState hook import

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
    
    function Body() {
        // count state 생성
        const [count, setCount] = useState(0); //구조분해할당사용. count 의 초기값 0 setCount 는 setter 

        // event처리 count 변경
        const onIncrease = () => {
            setCount(count + 1);
        };

        return (
            <div>
                <div>
                    {/* count state와 binding */}
                    <h2>{count}</h2>
                    <button onClick={onIncrease}>+</button>
                </div>
            </div>
            );
    }
    
    export default Body; //외부에서 접근 가능 하도록.