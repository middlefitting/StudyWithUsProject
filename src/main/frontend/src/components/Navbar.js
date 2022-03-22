import React from 'react';
import {Link} from "react-router-dom";
import './Navbar.css';

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
                    <li><Link to ="/">공지사항</Link></li>
                    <li><Link to="/">게시판</Link></li>
                    <li><Link to="/">스터디</Link></li>
                    <li><Link to="/">강좌</Link></li>
                </ul>

                <ul className="navbar_links">
                    <Link to = "/" className="navbar-account">
                        <img className="AccountImage" alt="AccountImg" src="images/Account.png"
                             height="100px" />
                    </Link>
                </ul>

                {/*<a href="/" className="navbar_toogleBtn">
                    <img className="ToogleImage" alt="ToogleImg" src="images/Toogle.png"
                         height="100px" />
                </a>*/}

            </nav>
        </>
    );
};

export default Navbar;
