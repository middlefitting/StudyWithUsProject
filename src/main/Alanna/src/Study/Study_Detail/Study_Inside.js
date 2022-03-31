import React from 'react';
import {Link, useHistory} from "react-router-dom";
import '../Css/Study_Detail.css';
import '../../Board/Write_Details/Details.css';
import '../../App.css';
import Study_Info from "./Study_Info";
import StudyBoardDetail from "./Study_Board_Detail";

function Study_Inside(){

    const history = useHistory();
    return (
        <div className="Study_Detail">
            <div className="study_inside_container">
                <Study_Info />
                <div className="study_inside_container_right">
                    <div className="study_go_back" onClick={()=> history.push('/Study_List')}>스터디목록 > </div>
                    <div className="board_con_top">
                        <div className="top_txt">
                            게시글
                        </div>
                        <button type="submit" id="study_write" value="글씨기">
                            <Link to='/Study_Write' className="link">
                                글쓰기
                            </Link>
                        </button>
                    </div>
                    <div className="study_board_container">
                        <table className="study_board">
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

                            <tr id="board_body" >

                                <td width="10%" className="listTableNum">1</td>
                                <td width="50%" className= "listTableTitle">
                                    <Link to ="/Study_Board_Detail" className="link">
                                        가입인사 드립니다
                                    </Link>
                                </td>
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
            </div>
        </div>
    );
};

export default Study_Inside;