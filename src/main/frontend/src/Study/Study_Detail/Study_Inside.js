import React, {useEffect, useState} from 'react';
import {Link, useHistory} from "react-router-dom";
import '../Css/Study_Detail.css';
import '../../Board/Write_Details/Details.css';
import '../../App.css';
import Study_Info from "./Study_Info";
import AxiosURL from "../../Services/AxiosURL";
import $ from 'jquery';

function Study_Inside() {

    const token = JSON.parse(localStorage.getItem('user-info'))

    let beforeStudyId = String((String(window.location.pathname).toString())).split("/studies/");
    let studyId = beforeStudyId[1]

    const [board, setBoard] = useState({});
    const [message, setMessage] = useState('');

    useEffect(() => {

        AxiosURL.isMember(studyId, token.authorization)
            .then((response) => {
                console.log(response)
                setMessage(response.data.message)
            }).catch(error => {
            console.log(error)
        })

        AxiosURL.pullBoard(studyId, token.authorization)
            .then((response) => {
                console.log(response)
                setBoard(response.data.data.content)
            }).catch(error => {
            console.log(error)
        })

        setTimeout(() => {
            $('.study_inside_container').css('opacity', '1');
        }, 300);

    }, [])

    const _handleSubmit = e => {
        e.preventDefault();

        $('.study_inside_container').css('opacity', '0');

        setTimeout(() => {
            AxiosURL.joinMember(studyId, token.authorization)
                .then((response) => {
                    console.log(response)
                    window.location.reload()
                }).catch(error => {
                console.log(error)
            })
        });
    }

    const history = useHistory();
    return (
        <div className="Study_Detail">
            <div className="study_inside_container">
                <Study_Info/>
                <div className="study_inside_container_right">
                    <div className="study_go_back" onClick={() => history.push('/Study_List')}>스터디목록 ></div>
                    <div className="board_con_top">
                        <div className="top_txt">
                            게시글 [{message}]
                        </div>
                        {message === "스터디 멤버입니다." ?
                            <button type="submit" id="study_write_input"
                                    onClick={(e) => _handleSubmit(e)}
                            >
                                탈퇴
                            </button>
                            :
                            <button type="submit" id="study_write_input"
                                    onClick={(e) => _handleSubmit(e)}
                            >
                                가입
                            </button>
                        }
                        <button type="submit" id="study_write_input">
                            <Link to={`/Study_Write/${studyId}`} className="link">
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
                            {board.length ?
                                board.map((board, idx) => (
                                    <tr id="board_body" key={idx}>
                                        <td width="10%" className="listTableNum">{board.studyBoardId}</td>
                                        <td width="50%" className="listTableTitle">
                                            <Link to="/Study_Board_Detail" className="link">
                                                {board.content}
                                            </Link>
                                        </td>
                                        <td width="15%" className="listTableAuthor">{board.nickname}</td>
                                        <td width="15%" className="listTableDate">{board.regDate.substring(0, 10)}</td>
                                        <td width="10%" className="listTableViews">{board.studyBoardViewCount}</td>
                                    </tr>
                                ))
                                :
                                <tr id="board_body">
                                    <td width="10%" className="listTableNum">1</td>
                                    <td width="50%" className="listTableTitle">
                                        첫 게시글을 등록해보세요.
                                    </td>
                                    <td width="15%" className="listTableAuthor">HelloWorld</td>
                                    <td width="15%" className="listTableDate">9999-99-99</td>
                                    <td width="10%" className="listTableViews">0</td>
                                </tr>
                            }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Study_Inside;