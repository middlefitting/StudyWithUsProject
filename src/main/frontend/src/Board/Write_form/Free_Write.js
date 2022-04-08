import './Write.css'
import {Link, useHistory} from "react-router-dom";
import {useEffect, useState} from "react";
import File_Upload from "./Upload/File_Upload";
import AxiosURL from "../../Services/AxiosURL";
import {useForm} from "react-hook-form";

function Free_Write(){

    const { watch, register, formState: {errors}, setError, handleSubmit } = useForm({mode:"onChange"});
    const history = useHistory();
    const user = JSON.parse(localStorage.getItem('user-info'));

    const onSubmit = (data) => {
        // console.log('data',data);

        AxiosURL.savePost(data)
            .then((response) => {
                console.log(response.data) // id
                let result = response.data
                localStorage.setItem("post-info",JSON.stringify(result))
                alert(JSON.stringify(" 글 등록이 완료되었습니다. ")) // 나중에 모달창으로 교체예정
                history.push("/BoardList")
                window.location.reload()
            }).catch(error => {
            console.log(error)
            alert(JSON.stringify(" 정보를 다시 입력해주세요. ")) // 나중에 모달창으로 교체예정
        })

    }

    return(
        <div className="write_form">
            <div className="mid_con">
                <form id="sendForm" onSubmit={handleSubmit(onSubmit)}>
                    <fieldset className="form_field">
                        <legend>자유롭게 글쓰기</legend>
                        <ul>
                            <li>
                                <label htmlFor="title_txt">제목</label>
                                <input
                                    type="text"
                                    name="title"
                                    className="inputTitle"
                                    placeholder="제목을 입력하세요"
                                    {...register("title", {required: true})}
                                    required />
                                {errors.title && errors.title.type === "required" && <p className="writePont">제목을 입력해주세요</p> }
                            </li>
                            <li>
                                <label htmlFor="context_txt">내용</label>
                                <textarea
                                    className="inputContent"
                                    name="content"
                                    placeholder="내용을 입력하세요"
                                    {...register("content", {required: true})}
                                    required />
                                {errors.content && errors.content.type === "required" && <p className="writePont">내용을 입력해주세요</p> }
                            </li>
                            <li>
                                <label htmlFor="context_txt">카테고리</label>
                                <input
                                    type="text"
                                    name="category"
                                    className="inputTitle"
                                    placeholder="notice, free, question"
                                    {...register("category", {required: true})}
                                    required />
                            </li>
                        </ul>
                        <input type="text" name="writer_id" value={user}
                            {...register("writer_id", {required: true})}/>
                        <File_Upload />

                        <div className="button_section">
                            <button type="submit" id="s_button" >등록하기</button>
                           <button type="button"  id="c_button" onClick={()=> history.push('/BoardList')}>취소하기</button>
                        </div>

                    </fieldset>
                </form>
            </div>



        </div>

    );
}
export default Free_Write;