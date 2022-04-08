import '../Write_form/Write.css'
import '../../App.css';
import {Link, useHistory} from "react-router-dom";
import {useState} from "react";
import File_Upload from "../Write_form/Upload/File_Upload";


function Update_Detail(){

    //뒤로가기 설정
    let history = useHistory();

    return(
        <div className="write_form">
            <div className="mid_con">
                <form>
                    <fieldset className="form_field">
                        <legend>수정하기</legend>
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
                            <button type="button"  id="c_button" onClick={()=>{
                                history.goBack();
                            }}>취소하기</button>
                        </div>

                    </fieldset>
                </form>
            </div>



        </div>

    );
}
export default Update_Detail;