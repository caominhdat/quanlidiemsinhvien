import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/course/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import CourseDetails from "./components/course/CourseDetails";
import Header from "./components/commons/Header";
import Login from "./components/course/Login";
import Register from "./components/course/Register";
import { MyDispatchContext, MyUserContext } from "./configs/contexts";

const App = () => {
  return (
    <BrowserRouter>
    <MyUserContext.Provider>
      <MyDispatchContext.Provider>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/course/:courseId" element={<CourseDetails />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Routes>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
    </BrowserRouter>
  );
}

export default App;