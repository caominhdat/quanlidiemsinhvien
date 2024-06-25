import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/course/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import CourseDetails from "./components/course/CourseDetails";
import Header from "./components/commons/Header";
import Login from "./components/course/Login";
import Register from "./components/course/Register";
import { MyDispatchContext, MyUserContext } from "./configs/contexts";
import { useReducer } from "react";
import { MyUserReducer } from "./configs/Reducers";

const App = () => {
  const [user, userDispatch] = useReducer(MyUserReducer, null);

  return (
    <BrowserRouter>
    <MyUserContext.Provider value={user}>
      <MyDispatchContext.Provider value={userDispatch}>
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