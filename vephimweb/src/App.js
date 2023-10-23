import 'bootstrap/dist/css/bootstrap.min.css';
import 'moment/locale/vi';
import { createContext, useReducer } from 'react';
import { Container } from "react-bootstrap";
import cookie from "react-cookies";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Booking from './components/Booking';
import Home from "./components/Home";
import Login from './components/Login';
import MovieDetail from './components/MovieDetail';
import Register from './components/Register';
import Showtime from './components/Showtime';
import TicketDetail from './components/TicketDetail';
import UserDetail from './components/UserDetail';
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import MyUserReducer from './reducers/MyUserReducer';

export const MyUserContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);

  return (
    <MyUserContext.Provider value={[user, dispatch]}>
      <BrowserRouter>
      <div style={{ display: 'flex', flexDirection: 'column', minHeight: '100vh' }}>
        <Header/>
         <Container style={{ flex: '1' }}>
          <Routes>
              <Route path="/" element={<Home />}/>
              <Route path="/showtime/:phimID" element={<Showtime />}/>
              <Route path="/login" element={<Login />}/>
              <Route path="/register" element={<Register />}/>
              <Route path="/booking/:suatChieuID" element={<Booking />}/>
              <Route path="/user/:nguoiDungID" element={<UserDetail />}/>
              <Route path="/movie/:phimID" element={<MovieDetail />}/>
              <Route path="/ticket/:veID" element={<TicketDetail />}/>
          </Routes>
          </Container>
        <Footer/>
        </div>
      </BrowserRouter>
    </MyUserContext.Provider>
  )
}

export default App;