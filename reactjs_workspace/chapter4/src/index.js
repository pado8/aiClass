import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // <React.StrictMode> //개발용 모드로 좀더 엄격한 모드(렌더링이 2번되는 경우가 있어 주석처리)
    <App />
  //</React.StrictMode>
);


// 이것도 개발용 모드로 성능 측정 관련
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals(console.log);
