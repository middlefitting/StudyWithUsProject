import React, {useEffect, useState} from 'react';
import {useHistory, useParams} from "react-router-dom";
import '../Board/Write_form/Write.css';
import AxiosURL from "../Services/AxiosURL";

function Study_Make_Update() {

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

    const {studyId} = useParams();
    const history = useHistory();
    const[studyInfo, setStudyInfo] =useState({});
    // const [data, setData] = useState({});

    const token = JSON.parse(localStorage.getItem('user-info')).authorization
    console.log(token)

    useEffect(() => {
        AxiosURL.studyEdit(studyId,token).then(res => {
            setStudyInfo(res.data.data);
        });
    }, []);

/*    useEffect(() => {
        AxiosURL.getEdit(post_id).then(res => {
            setPostDto(res.data[0]);
        });
    }, []);*/


    console.log("왜???? : " + studyInfo);

    const _handleSubmit = e => {
        e.preventDefault();

        const data = {
            studyName: document.getElementsByName('studyName')[0].value,
            studyExplanation: document.getElementsByName('studyExplanation')[0].value
        }


        AxiosURL.putStudyEdit(studyId,data, token)
            .then((res)=>{
                history.goBack();
            }).catch(err=>{
                console.log(err);
        })

    };

    const handleDelete = e =>{
        e.preventDefault();

        AxiosURL.StudyDelete(studyId,token)
            .then((res)=>{
                history.push('/Study_List');
            }).catch(err=>{
                console.log(err);
        })


    }



    return (
        <div className="write_form">
            <div className="mid_con">
                <form>
                    <fieldset className="form_field">
                        <legend>스터디 정보 수정하기</legend>
                        <ul>
                            <li>
                                <label htmlFor="title_txt">스터디 명</label>
                                <input type="text"
                                       className="inputTitle"
                                       placeholder="스터디명을 입력하세요"
                                       required
                                       name='studyName'
                                       defaultValue={studyInfo.studyName}
                                />
                            </li>
                            <li>
                                <label htmlFor="context_txt">스터디 설명</label>
                                <textarea className="inputContent" placeholder="내용을 입력하세요" required
                                          name='studyExplanation'
                                          defaultValue={studyInfo.studyExplanation}
                                />
                            </li>
                        </ul>
                        <div className="button_section">
                            <button type="submit" id="s_button" onClick={(e) => _handleSubmit(e)}>등록하기</button>
                            <button type="button" id="c_button" onClick={() => history.goBack()}>취소하기</button>
                            <button type="button" id="dd_button" onClick={(e) => handleDelete(e)}>삭제하기</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    );
};

export default Study_Make_Update;