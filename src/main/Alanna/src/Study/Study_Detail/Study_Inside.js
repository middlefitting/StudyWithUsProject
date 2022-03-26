import React from 'react';
import {Link} from "react-router-dom";
import '../Css/Study_Detail.css';
import Study_Info from "./Study_Info";
import StudyBoardDetail from "./Study_Board_Detail";

function Study_Inside(){
    return (
        <div className="Study_Detail">
            <div className="container_top">
                <Study_Info />
                <div className="studyBoard_con">
                    <div className="board_con_top">
                        <div className="top_txt">
                            게시글
                        </div>
                        <Link to='/Study_Write' className="link">
                            <button type="submit" id="study_write" value="글씨기">글쓰기</button>
                        </Link>
                    </div>
                    <table className="study_board">
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
                            <Link to ="/Study_Board_Detail" className="link">
                                <td width="50%" className= "listTableTitle">가입인사 드립니다</td>
                            </Link>
                            <td width="15%" className="listTableAuthor">하이</td>
                            <td width="15%" className="listTableDate">2022-03-25</td>
                            <td width="10%" className="listTableViews">5</td>
                        </tr>



                        {/*                    <tr id="board_body">
                        <td width="10%" className="listTableNum"></td>
                        <td width="90%" className="listNoData">작성된 글이 없습니다</td>
                    </tr>*/}


                        </tbody>
                    </table>

                </div>
            </div>
            <div className="container_bottom">

            </div>

        </div>
    );
};

export default Study_Inside;