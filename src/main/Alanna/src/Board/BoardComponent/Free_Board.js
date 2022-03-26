import {Link} from "react-router-dom";
import React, {useEffect, useRef, useState} from "react";
import  "../../App.css";



function  Free_Board(){

    return(
        <div className="mid_container">
            <table id="main_board">
                <thead>
                <tr id="board_head">
                    <td width="10%" className="listHeadNum">No.</td>
                    <td width="50%" className="listHeadTitle">제목</td>
                    <td width="15%" className="listHeadAuthor">작성자</td>
                    <td width="15%" className="listHeadDate">작성날짜</td>
                    <td width="10%" className="listHeadViews">조회</td>
                </tr>
                </thead>
                <tbody>

                    <tr id="board_body" >

                        <td width="10%" className="listTableNum">1</td>
                        <Link to ="/Free_Detail" className="link">
                            <td width="50%%" className= "listTableTitle">자유게시글</td>
                        </Link>
                        <td width="15%" className="listTableAuthor">자유</td>
                        <td width="15%" className="listTableDate">2022-03-18</td>
                        <td width="10%" className="listTableViews">3</td>
                    </tr>



{/*                    <tr id="board_body">
                        <td width="10%" className="listTableNum"></td>
                        <td width="90%" className="listNoData">작성된 글이 없습니다</td>
                    </tr>*/}


                </tbody>
            </table>
        </div>

    );
}
export default Free_Board;