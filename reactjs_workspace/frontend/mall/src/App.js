
import { RouterProvider } from "react-router-dom";
import root from "./router/root";

function App() {
  return (
    // router 사용
    <RouterProvider router={root}></RouterProvider>
  );
}

export default App;