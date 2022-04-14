import React, {useEffect, useState} from 'react';
import '../Css/Study_Detail.css';
import AxiosURL from "../../Services/AxiosURL";
import {Link} from "react-router-dom";

function StudyInfo() {

    const [study, setStudy] = useState('');
    const [check, setCheck] = useState('');
    const user_id = JSON.parse(localStorage.getItem('user'));


    let beforeStudyId = String((String(window.location.pathname).toString())).split("/studies/");
    let studyId = beforeStudyId[1]

    useEffect(() => {

        const token = JSON.parse(localStorage.getItem('user-info'))

        AxiosURL.intoStudy(studyId, token.authorization)
            .then(response => {
                setStudy(response.data.data)
                setCheck(response.data.data.studyId)
            }).catch(error => {
            console.log(error)
        })
    }, []);



    return (
        <div className="studyInfo_con">
            <div className="studyInfo_box">
                <div className="studyName">{study.studyName}</div>
                    <div className="studyInfo_section">
                        <table className="studyInfo_table">
                            <thead>
                            <tr>
                                <th>매니저</th>
                                <td>{study.studyMasterNickname}</td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>멤버수</th>
                                <td>{study.studyMemberCount}</td>
                            </tr>
                            </tbody>
                        </table>
                            {parseInt(user_id.id) === parseInt(study.studyMasterId) ?
                                <div className="study_btn">
                                        <button className="study_edit_btn">
                                            <Link to={`/Study_Make_Update/${studyId}`} className="link">
                                                수정
                                            </Link>
                                        </button>
                                </div>
                                :
                                <></>
                            }
                    </div>
            </div>
        </div>
    );
};

export default StudyInfo;