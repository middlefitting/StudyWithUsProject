import {Link} from "react-router-dom";
import React from "react";
import  "../../App.css";

function  QNA_Board(){
    return(

            <table id="main_board">
                <thead>
                <tr id="board_head">
                    <th width="10%" className="listHeadNum">No.</th>
                    <th width="50%" className="listHeadTitle">제목</th>
                    <th width="15%" className="listHeadAuthor">작성자</th>
                    <th width="15%" className="listHeadDate">작성날짜</th>
                    <th width="10%" className="listHeadViews">조회</th>
                </tr>
                </thead>
                <tbody>
                <tr id="board_body">
                    <td width="10%">1</td>
                    <td width="50%">
                        <Link to ="/QNA_Detail" className="link">
                        질문게시판입니다
                        </Link>
                    </td>
                    <td width="15%">김아무개</td>
                    <td width="15%">2022-03-18</td>
                    <td width="10%">3</td>
                </tr>
                </tbody>
            </table>


    );
}
export default QNA_Board;