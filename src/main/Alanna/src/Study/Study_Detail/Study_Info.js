import React from 'react';
import '../Css/Study_Detail.css';
function StudyInfo (){
    return (
        <div className="studyInfo_con">
            <div className="studyInfo_box">
                <div className="studyName">스터디 이름</div>
                <div className="studyInfo_section">
                    <table className="studyInfo_table">
                        <tr>
                            <th>매니저</th>
                            <td>김아무개</td>
                        </tr>
                        <tr>
                            <th>멤버수</th>
                            <td>10</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    );
};

export default StudyInfo;
