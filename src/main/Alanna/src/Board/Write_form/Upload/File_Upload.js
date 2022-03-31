import {useState} from "react";
import '../Write.css';


function File_Upload(){

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
            <div className="write_input_file" onChange={saveImage}>
                <input  type="file" onClick={FileClicked}/>

                <button id="d_button" onClick={()=> deleteImage()}>삭제</button>


            </div>

        </div>
    );
}
export default File_Upload;