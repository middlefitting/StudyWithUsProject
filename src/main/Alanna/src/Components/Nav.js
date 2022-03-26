import React from 'react';
import {Link} from "react-router-dom";

function Nav(){
    return (
        <div className="navigation_bar">
            <Link to ="/NoticeList" className="link">
                <button className="notice_nav">공지사항</button>
            </Link>

            <Link to ="/BoardList" className="link">
                <div className="board_nav">게시판</div>
            </Link>

            <Link to ="/Study_List" className="link">
                <div className="study_nav">스터디</div>
            </Link>
             <div className="class_nav">강좌</div>

        </div>
    );
};

export default Nav;