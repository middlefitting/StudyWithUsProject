import React, {useEffect, useState} from 'react';
import '../App.css';
import './Css/Study_List.css';
import {Link} from "react-router-dom";
import AxiosURL from "../Services/AxiosURL";

function StudyList(){

    const [study, setStudy] = useState({});
    const [page, setPage] = useState({});
    const [loading, setLoading] = useState(false);
    const user = localStorage.getItem('user-info')

    useEffect(() => {

            if (localStorage.getItem('user-info')) {

                setLoading(true);

                const token = JSON.parse(localStorage.getItem('user-info'))

                AxiosURL.studyList(token.authorization)
                    .then(response => {
                        setPage(response.data.data.pageable)
                        setStudy(response.data.data.content)
                    }).catch(error => {
                    console.log(error)
                })
                setLoading(false);
            }

    }, [])


    return (
        <>
            {loading &&
            <></>
            }
            <div className="container">
                <div className="study_mid_container">
                    <div className="studyPage_con">
                        <div className="studyPage_name">
                        스터디
                        </div>
                        {user ?
                        <button type="submit" id="make" value="만들기">
                            <Link to='/Study_Make' className="link">Study 만들기</Link>
                        </button>
                            :
                            <></>
                        }

                    </div>
                    <div className="study_cont_container">
                            <div className="study_mid_container">
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
                                    {study.length ?
                                        study.map((study, idx) => (
                                        <tr id="board_body" key={idx}>
                                            <td width="10%">{study.studyId}</td>
                                            <td width="50%">
                                                <Link to="/Study_Inside"  className="link">
                                                    {study.studyName}
                                                </Link>
                                            </td>
                                            <td width="15%">{study.nickName}</td>
                                            <td width="15%">{study.regDate && study.regDate.substring(0,10)}</td>
                                            <td width="10%">{study.studyMemberCount}</td>
                                        </tr>
                                       ))
                                        :
                                        <tr id="board_body">
                                        <td width="10%"></td>
                                        <td width="50%">
                                        <Link to="/signin"  className="link">
                                            로그인 후 이용 가능합니다.
                                        </Link>
                                        </td>
                                        <td width="15%"></td>
                                        <td width="15%"></td>
                                        <td width="10%"></td>
                                        </tr>
                                    }
                                    </tbody>
                                </table>
                            </div>
                    </div>
                </div>
            </div>
        </>
    );
};

export default StudyList;