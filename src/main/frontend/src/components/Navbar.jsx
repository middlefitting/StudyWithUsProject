import React, {useState} from 'react';
import '../styles/css/Navbar.css';
import {BrowserRouter as Router, Link} from "react-router-dom";


const Navbar = () => {

    const [active, setActive] = useState('nav_menu');

    const [toggleIcon, setToggleIcon] = useState("nav_toggler");

    const navToggle = () => {
        active === 'nav_menu' ? setActive('nav_menu nav_active') : setActive('nav_menu');

        // 토글러 아이콘
        toggleIcon === 'nav_toggler'
        ? setToggleIcon('nav_toggler toggle')
        : setToggleIcon('nav_toggler')
    };

    return (
        <nav className="nav">
            <Link to = "/" className="brand">StudyWithUs</Link>
            <ul className={active}>
                <li className="nav_item1"><Link to = "#" className="nav_link">공지사항</Link></li>
                <li className="nav_item2"><Link to = "#" className="nav_link">게시판</Link></li>
                <li className="nav_item3"><Link to = "#" className="nav_link">스터디</Link></li>
                <li className="nav_item4"><Link to = "#" className="nav_link">강좌</Link></li>
                <Link to = "/aa"><button className="btn_login">sign in</button></Link>
                <Link to = "#"><button className="btn_account">sign up</button></Link>
            </ul>
            <div onClick={navToggle} className={toggleIcon}>
                <div className="line1"></div>
                <div className="line2"></div>
                <div className="line3"></div>
            </div>
        </nav>
    );
};

export default Navbar;
