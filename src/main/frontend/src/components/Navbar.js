import React from 'react';
import {Link} from "react-router-dom";
import './style/css/Navbar.css';
import Navbar_HorizontoalLine from "./Navbar_HorizontoalLine";
import {Button, NavLink} from "react-bootstrap";

/*
const navToogleBtn = document.querySelector('.navbar_toogleBtn');
const navMenu = document.querySelector('.navbar_menu');
const navLinks = document.querySelector('.navbar_links');

navToogleBtn.addEventListener('click', () => {
    navMenu.classList.toggle('active');
    navLinks.classList.toggle('active');
})
*/

const Navbar = () => {

    return (
        <>
            <nav className="navbar">

                <div className="navbar_logo">
                    <Link to = "/" className="navbar-logo" >
                        <img className="HomeImage" alt="HomeLogo" src="images/HomeLogo.png"
                             height="80px" width="300px"/>
                    </Link>
                </div>

                <ul className="navbar_menu" >
                    <li><Link to ="/" >공지사항</Link></li>
                    <li><Link to="/">게시판</Link></li>
                    <li><Link to="/">스터디</Link></li>
                    <li><Link to="/">강좌</Link></li>
                </ul>

                
                <ul className="navbar_signin">
                    {/*<Link to = "/login" className="navbar-login">로그인
                        <img className="LoginImage" alt="LoginImg" src="images/Account.png"
                             height="100px" />
                    </Link>*/}
                    <NavLink>
                        <Button variant="primary">로그인</Button>
                    </NavLink>
                </ul>

                <ul className="navbar_signup">
                    {/*<Link to = "/account" className="navbar-account">회원가입
                        <img className="LoginImage" alt="LoginImg" src="images/Account.png"
                             height="100px" />
                    </Link>*/}
                    <NavLink>
                        <Button variant="secondary">회원가입</Button>
                    </NavLink>
                </ul>

                {/*<a href="/" className="navbar_toogleBtn">
                    <img className="ToogleImage" alt="ToogleImg" src="images/Toogle.png"
                         height="100px" />
                </a>*/}

            </nav>

            <Navbar_HorizontoalLine text="Study With Us " />
        </>
    );
};

export default Navbar;
