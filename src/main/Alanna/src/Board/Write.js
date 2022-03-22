import './Write.css'
import {Link} from "react-router-dom";
import {useState} from "react";

function Write(){
    // 미리볼 사진 url 저장할 state
    const[fileImage, setImage] = useState("");

    //파일 저장
    const saveImage = (e)=>{
        setImage(URL.createObjectURL(e.target.files[0]));
    };
    {/*           <input id="upload" ref="upload" type="file" accept="image/*"
                               onInput={(event)=> {
                                   this.readFile(event)
                               }}
                               onClick={(event)=> {
                                   event.target.value = null
                               }}
                        />*/}


    // 같은 파일 재업로드 설정
    const FileClicked=(e)=>{
        e.target.value = null;
    }

    //파일 삭제
    const deleteImage=(e)=>{
        URL.revokeObjectURL(fileImage);
        setImage("");
    };



    return(
        <div className="write_form">
            <fieldset>
                <legend>글쓰기</legend>
                <ul>
                    <li>
                        <h4>회원 정보(수정해야함)</h4>
                    </li>
                    <li>
                        <label htmlFor="title_txt">제목</label>
                        <input type="text" id="title_txt" required />
                    </li>
                    <li>
                        <label htmlFor="context_txt">내용</label>
                        <textarea id="context_txt" required />
                    </li>
                </ul>
                <div className="file">
                    <table id="image_table">
                        <thead>
                            <tr>
                                <td>이미지 미리보기</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    {fileImage && (<img id="image_box" alt="sample" src={fileImage}/>)}
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <label htmlFor="input-file" className="Write_input_file" onChange={saveImage}>
                    <input  type="file" onClick={FileClicked}/>




                    </label>
                    <button id="d_button" onClick={()=> deleteImage()}>삭제</button>
                </div>

                <div className="button_section">
                    <button type="submit" id="s_button" onClick="#">등록하기</button>
                    <Link to="/BoardList" ><button type="button"  id="c_button">취소하기</button></Link>
                </div>

            </fieldset>




        </div>

    );
}
export default Write;