import {Link} from "react-router-dom";
import React from "react";
import  "../../App.css";

function  Notice_Board(){
    return(
        <div className="mid_container">
                        <table id="main_board">
                            <thead>
                            <tr id="board_head">
                                <td width="10%">No.</td>
                                <td width="50%%">제목</td>
                                <td width="15%">작성자</td>
                                <td width="15%">작성날짜</td>
                                <td width="10%">조회</td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr id="board_body">
                                <td width="10%">1</td>
                                <td width="50%%">공지사항입니다</td>
                                <td width="15%">김아무개</td>
                                <td width="15%">2022-03-18</td>
                                <td width="10%">3</td>
                            </tr>
                            </tbody>
                        </table>
        </div>

    );
}
export default Notice_Board;