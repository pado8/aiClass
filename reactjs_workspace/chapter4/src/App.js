import "./App.css";
import Body from "./components/Body";
import Footer from "./components/Footer";
import Header from "./components/Header";

// ChildComp 컴포넌트
function ChildComp() {
  return <div>자식 컴포넌트</div>;
}


// App 컴포넌트
function App() {
  const name="홍길동";
  const BodyProps={
    name:"이정환",
    location:"부천시",
    favorList:["파스타","빵","떢볶이"]
  }
  return (
    <div className="App">
      <Header />
      {/* name, location은 props */}
      {/* <Body name={name} location={"부천시"} /> */}
      {/* 전개구문을 이용한 props */}
      {/* <Body  {...BodyProps} /> */}
      <Body>
        <ChildComp />
      </Body>
      <Footer />
    </div>
  );
  
}

export default App;