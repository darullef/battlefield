import React from 'react';
import {Route, Routes} from 'react-router-dom';
import LoginPage from "./pages/login/LoginPage";
import HomePage from "./pages/home/HomePage";
import RegisterPage from "./pages/register/RegisterPage";
import AppNavbar from "./components/navbar/AppNavbar";

function App() {
    return (
        <div className="App">
            <AppNavbar/>
            <Routes>
                <Route path="/" element={<HomePage/>}/>
                <Route path="login" element={<LoginPage/>}/>
                <Route path="register" element={<RegisterPage/>}/>
            </Routes>
        </div>
    );
}

export default App;
