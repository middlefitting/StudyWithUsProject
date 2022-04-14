import React from 'react';
import {useHistory} from "react-router-dom";
import '../Board/Write_form/Write.css';
import AxiosURL from "../Services/AxiosURL";

function Study_Make() {

    //radio button 설정============================================
    // const [choice, setChoice] = React.useState('public');
    //
    // const handlePublicChange =()=>{
    //     setChoice('public');
    // }
    // const handlePrivateChange=()=>{
    //     setChoice('private');
    // }
    //=============================================================

    const history = useHistory();

    const token = JSON.parse(localStorage.getItem('user-info')).authorization

    const _handleSubmit = e => {
        e.preventDefault();

        const data = {
            studyName: document.getElementsByName('studyName')[0].value,
            studyExplanation: document.getElementsByName('studyExplanation')[0].value
        }

        AxiosURL.studyCreate(data, token)
            .then((response) => {
                console.log(response)
                history.push('/Study_List')
            }).catch(error => {
            console.log(error.response)
        })
    };

    return (
        <div className="write_form">
            <div className="mid_con">
                <form>
                    <fieldset className="form_field">
                        <legend>스터디 만들기</legend>
                        <ul>
                            <li>
                                <label htmlFor="title_txt">스터디 명</label>
                                <input type="text" className="inputTitle" placeholder="스터디명을 입력하세요" required
                                       name='studyName'
                                />
                            </li>
                            <li>
                                <label htmlFor="context_txt">스터디 설명</label>
                                <textarea className="inputContent" placeholder="내용을 입력하세요" required
                                          name='studyExplanation'
                                />
                            </li>
                        </ul>
                        <div className="button_section">
                            <button type="submit" id="s_button" onClick={(e) => _handleSubmit(e)}>등록하기</button>
                            <button type="button" id="c_button" onClick={() => history.goBack()}>취소하기</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    );
};

export default Study_Make;