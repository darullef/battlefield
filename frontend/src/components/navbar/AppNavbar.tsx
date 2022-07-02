import React from 'react';
import styles from './NavBar.module.scss'
import {Link} from "react-router-dom";
import ClickableButton from "../buttons/clickable_button/ClickableButton";

const AppNavbar = () => (
    <div className={styles.navbar}>
        <Link to="/">Home page</Link>
        <Link to="/login">Login</Link>
        <Link to="/register">Register</Link>
        <ClickableButton buttonName={"Register!"}/>
    </div>
)

export default AppNavbar;
