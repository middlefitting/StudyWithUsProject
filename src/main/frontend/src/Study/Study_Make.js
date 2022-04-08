import React, {useState} from 'react';
import {Link, useHistory} from "react-router-dom";
import '../Board/Write_form/Write.css';
function Study_Make() {


    //radio button 설정============================================
    const [choice, setChoice] = React.useState('public');

    const handlePublicChange =()=>{
        setChoice('public');
    }
    const handlePrivateChange=()=>{
        setChoice('private');
    }
    //=============================================================

    const history = useHistory();



    return (
        <div className="write_form">
            <div className="mid_con">
                <form>
                    <fieldset className="form_field">
                        <legend>스터디 만들기</legend>
                        <ul>
                            <li>
                                <label htmlFor="title_txt">스터디 명</label>
                                <input type="text" className="inputTitle" placeholder="스터디명을 입력하세요" required />
                            </li>
                            <li>

                                <label htmlFor="study_type">스터디 성격</label>
                                <div className="type_field">
                                    <input type="radio" className="study_radio" value={choice==='public'} name="radio"
                                           onChange={handlePublicChange}/>
                                    <span>공개</span>
                                    <input type="radio" className="study_radio" value={choice==='private'} name="radio"
                                   onChange={handlePrivateChange}/>
                                    <span>비공개</span>
                                </div>

                            </li>
                            <li>
                                <label htmlFor="context_txt">스터디 설명</label>
                                <textarea className="inputContent" placeholder="내용을 입력하세요" required />
                            </li>
                        </ul>


                        <div className="button_section">
                            <button type="submit" id="s_button" >등록하기</button>
                           <button type="button"  id="c_button" onClick={()=> history.goBack()}>취소하기</button>
                        </div>

                    </fieldset>
                </form>
            </div>



        </div>
    );
};

export default Study_Make;