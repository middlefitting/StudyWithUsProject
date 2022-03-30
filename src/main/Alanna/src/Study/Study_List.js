import React from 'react';
import '../App.css';
import './Css/Study_List.css';
import {Link} from "react-router-dom";



function StudyList(){
    return (

            <div className="container">
                <div className="mid_container">
                    <div className="studyPage_con">
                        <div className="studyPage_name">
                        스터디
                        </div>
                        <Link to='/Study_Make'>
                            <button type="submit" id="make" value="만들기">Study 만들기</button>
                        </Link>
                    </div>
                    <div className="cont_container">

                        <div className="list_con">
                            <div className="mid_container">
                                <table id="study_board">
                                    <thead>
                                    <tr id="board_head">
                                        <td width="10%">No.</td>
                                        <td width="50%%">스터디명</td>
                                        <td width="15%">스터디장</td>
                                        <td width="15%">생성날짜</td>
                                        <td width="10%">회원수</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr id="board_body">
                                        <td width="10%">1</td>
                                        <Link to="/Study_Inside"  className="link">
                                            <td width="50%%">KGIt AWS 스터디</td>
                                        </Link>
                                        <td width="15%">김아무개</td>
                                        <td width="15%">2022-03-18</td>
                                        <td width="10%">12</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>


            </div>



    );
};

export default StudyList;