import './Write.css'
import {Link, useHistory} from "react-router-dom";
import {useEffect, useState} from "react";
import File_Upload from "./Upload/File_Upload";
import AxiosURL from "../../Services/AxiosURL";


function Notice_Write(){

    const history = useHistory();

    useEffect(() => {
        AxiosURL.getBoardList()
            .then((response) => {
                console.log(response.data)
            })
    })

    return(
        <div className="write_form">
            <div className="mid_con">
                <form>
                    <fieldset className="form_field">
                        <legend>공지사항</legend>
                        <ul>
                            <li>
                                <label htmlFor="title_txt">제목</label>
                                <input type="text" className="inputTitle" placeholder="제목을 입력하세요" required />
                            </li>
                            <li>
                                <label htmlFor="context_txt">내용</label>
                                <textarea className="inputContent" placeholder="내용을 입력하세요" required />
                            </li>
                        </ul>
                        <File_Upload />

                        <div className="button_section">
                            <button type="submit" id="s_button" >등록하기</button>
                            <button type="button"  id="c_button" onClick={()=> history.push('/NoticeList')}>취소하기</button>
                        </div>

                    </fieldset>
                </form>
            </div>



        </div>

    );
}
export default Notice_Write;