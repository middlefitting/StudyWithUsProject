import {Link} from "react-router-dom";
import React from "react";
import  "../../App.css";

function MyPage_Board(){
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
                    <Link to ="#" className="link">
                        개발중입니다.
                    </Link>
                </td>
                <td width="15%">개발중</td>
                <td width="15%">1818-18-18</td>
                <td width="10%">18</td>
            </tr>
            </tbody>
        </table>


    );
}
export default MyPage_Board;