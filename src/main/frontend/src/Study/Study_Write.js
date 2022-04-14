import '../Board/Write_form/Write.css'
import {useHistory} from "react-router-dom";
import React from "react";
import AxiosURL from "../Services/AxiosURL";


function Study_Write() {

    const history = useHistory();

    const token = JSON.parse(localStorage.getItem('user-info'))

    let beforeStudyId = String((String(window.location.pathname).toString())).split("/Study_Write/");
    let studyId = beforeStudyId[1]

    const _handleSubmit = e => {
        e.preventDefault();

        const _black = /^\s+|\s+$/g;
        const data = {
            title: document.getElementsByName('title')[0].value,
            content: document.getElementsByName('content')[0].value,
            studyBoardCategory: document.querySelector(`input[name='radio']:checked`).value,
        }

        if (!(data.title.length < 5 || data.title.length > 20) &&
            !(data.content.length < 10 || data.content.length > 1000) &&
            data.title.replace(_black, '') !== '' && data.content.replace(_black, '') !== ''
        ) {
            AxiosURL.boardCreate(studyId, data, token.authorization)
                .then((response) => {
                    console.log(response)
                    history.push(`/studies/${studyId}`)
                }).catch(error => {
                console.log(error.response)
                alert(error.response.data.message + "\n" + "가입 후 글 등록이 가능합니다.")
            })
        } else if (data.title.replace(_black, '') === '' || data.content.replace(_black, '') === '') {
            alert('공백으로만 이루어진 값은 입력할 수 없습니다.');
        } else {
            alert('제목은 5 - 20 자, 내용은 10 - 1000자 까지 입력 가능합니다.');
        }
    }

    return (
        <div className="write_form">
            <div className="mid_con">
                <form>
                    <fieldset className="form_field">
                        <legend>스터디 게시글 글쓰기</legend>
                        <ul>
                            <li>
                                <label htmlFor="title_txt">제목</label>
                                <input type="text" className="inputTitle" placeholder="제목을 입력하세요" required
                                       name='title'
                                />
                            </li>
                            <li>
                                <label htmlFor="context_txt">내용</label>
                                <textarea className="inputContent" placeholder="내용을 입력하세요" required
                                          name='content'
                                />
                            </li>
                            <li>
                                <label htmlFor="study_type">스터디 종류</label>
                                <div className="type_field">
                                    <input type="radio" className="study_radio" value="notice" name="radio"
                                           defaultChecked={true}/>
                                    <span>notice</span>
                                    <input type="radio" className="study_radio" value="study" name="radio"/>
                                    <span>study</span>
                                    <input type="radio" className="study_radio" value="free" name="radio"/>
                                    <span>free</span>
                                </div>
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
}

export default Study_Write;