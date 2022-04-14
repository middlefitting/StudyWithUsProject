import React, {useEffect, useState} from 'react';
import '../Css/Study_Detail.css';
import AxiosURL from "../../Services/AxiosURL";

function StudyInfo (){

    const [study, setStudy] = useState('');

    useEffect(() => {

        const token = JSON.parse(localStorage.getItem('user-info'))

        let beforeStudyId = String((String(window.location.pathname).toString())).split("/studies/");
        let studyId = beforeStudyId[1]

        AxiosURL.intoStudy(studyId, token.authorization)
            .then(response => {
                setStudy(response.data.data)
            }).catch(error => {
            console.log(error)
        })
    }, [])


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
                </div>
            </div>
        </div>
    );
};

export default StudyInfo;
