import './Write.css'
import {Link, useHistory} from "react-router-dom";
import {useEffect, useState} from "react";
import File_Upload from "./Upload/File_Upload";
import AxiosURL from "../../Services/AxiosURL";
import {useForm} from "react-hook-form";

function Board_Write(){

    const { control,reset, watch, register, formState: {errors}, setError, handleSubmit } = useForm({mode:"onChange"});
    const history = useHistory();
    const user = JSON.parse(localStorage.getItem('user-data'));
    const token = JSON.parse(localStorage.getItem('user-info'));
    const user_info_id = JSON.parse(localStorage.getItem('user')).id;

    const onSubmit = (e) => {
        e.preventDefault();

        const data = {
            writer_id: user_info_id,
            writer_nickname: user.nickname,
            title: document.getElementsByName('title')[0].value,
            content: document.getElementsByName('content')[0].value,
            category: document.querySelector(`input[name='category']:checked`).value,
        };

        AxiosURL.savePost(data)
            .then((response) => {
                console.log('hi')
                let result = response.data
                localStorage.setItem("post-info",JSON.stringify(result))
                alert(JSON.stringify(" 글 등록이 완료되었습니다. ")) // 나중에 모달창으로 교체예정
                history.goBack();
            }).catch(error => {
                console.log(error)
                alert(" 정보를 다시 입력해주세요. "); // 나중에 모달창으로 교체예정
        })
    }

    // private Long post_id;
    // private String title;
    // private String content;
    // private Long writer_id;
    // private String writer_nickname;
    // private Category category;
    // private Integer views;
    // private LocalDateTime regDate;
    // private LocalDateTime modDate;

//    axios call board type


    const boardsKind = [
        {name:'공지게시판', value:'notice'},
        {name:'자유게시판', value: 'free'},
        {name:'질문게시판', value:'question'}
    ];




    // const [click, setClick] = useState('');
    //
    // const handleClickedRadioButton = (e) =>{
    //     console.log(e.target.value)
    //     setClick(e.target.value)
    // }

const _handleEnter = () => {
    history.goBack() ////==>선택 카테고리로 이동
}





    return(
        <div className="write_form">
            <div className="mid_con">
                <form id="sendForm">
                    <fieldset className="form_field">
                        <legend>글쓰기</legend>
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
                                <div className="write_type_field">
                                    {/*{boardsKind.map((kind,idx)=>(*/}
                                    {/*    <div className="board_type_radio" key={idx}>*/}
                                    {/*        <input type="radio" className="write_radio" name="category" value={kind.value}*/}
                                    {/*               onChange={handleClickedRadioButton }/>*/}
                                    {/*        <span>{kind.name}</span>*/}
                                    {/*    </div>*/}
                                    {/*))}*/}
                                    <div className="board_type_radio">
                                        <input type="radio" className="write_radio" name="category" value={'notice'} defaultChecked={true}/>
                                        <span>공지사항</span>
                                    </div>
                                    <div className="board_type_radio">
                                        <input type="radio" className="write_radio" name="category" value={'free'}/>
                                        <span>자유게시판</span>
                                    </div>
                                    <div className="board_type_radio">
                                        <input type="radio" className="write_radio" name="category" value={'question'}/>
                                        <span>질문게시판</span>
                                    </div>
                                </div>

                            </li>
                        </ul>
                        <input type="text" className="writer_id" name="writer_id" readOnly={true} defaultValue={user_info_id}
                            {...register("writer_id", {required: true})}/>
                        <File_Upload />

                        <div className="button_section">
                            <button type="submit" id="s_button" onClick={e => onSubmit(e)} >등록하기</button>
                            <button type="button"  id="c_button" onClick={()=> _handleEnter()}>취소하기</button>
                        </div>

                    </fieldset>
                </form>
            </div>



        </div>

    );
}
export default Board_Write;