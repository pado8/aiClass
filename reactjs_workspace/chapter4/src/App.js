import "./App.css";

// Header 컴포넌트
function Header() {
  return (
    <header>
      <h1>header</h1>
    </header>
  );
}

// App 컴포넌트
function App() {
  return (
    <div className="App">
      <Header />
    </div>
  );
  
}

export default App;