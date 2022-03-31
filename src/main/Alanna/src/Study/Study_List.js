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
                        <button type="submit" id="make" value="만들기">
                            <Link to='/Study_Make' className="link">Study 만들기</Link>
                        </button>
                    </div>
                    <div className="cont_container">
                            <div className="mid_container">
                                <table id="study_board">
                                    <thead>
                                        <tr id="board_head">
                                            <th width="10%">No.</th>
                                            <th width="50%%">스터디명</th>
                                            <th width="15%">스터디장</th>
                                            <th width="15%">생성날짜</th>
                                            <th width="10%">회원수</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr id="board_body">
                                            <td width="10%">1</td>
                                            <td width="50%">
                                                <Link to="/Study_Inside"  className="link">
                                                    KGIt AWS 스터디
                                                </Link>
                                            </td>
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



    );
};

export default StudyList;