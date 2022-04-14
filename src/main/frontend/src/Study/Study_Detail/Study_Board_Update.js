import '../../Board/Write_form/Write.css'
import '../../App.css';
import {Link, useHistory, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import File_Upload from "../../Board/Write_form/Upload/File_Upload";
import AxiosURL from "../../Services/AxiosURL";
import $ from "jquery";


function Study_Board_Update() {

    //뒤로가기 설정
    const history = useHistory();
    const {studyId, boardId} = useParams();
    const token = JSON.parse(localStorage.getItem('user-info'));
    const user = JSON.parse(localStorage.getItem('user'));
    const [boardDto, setBoardDto] = useState({});

    const _handleSubmit = (e) => {
        e.preventDefault();

        const title = document.getElementsByName('title')[0].value;
        const content = document.getElementsByName('content')[0].value;

        let data = boardDto;

        if ((boardDto.title !== title || boardDto.content !== content) &&
            title.length > 4 && title.length < 21 && content.length > 9
        ) {
            data.title = title;
            data.content = content;
            data.studyBoardCategory = data.category;

            AxiosURL.putStudyBoardDetail(studyId, data, token.authorization).then(() => {
                history.goBack();
            }).catch(err => {
                console.log(err);
            });
        } else if (!(title.length > 4 && title.length < 21 && content.length > 9)) {
           alert('제목은 5 - 20, 내용은 10자 이상으로 부탁드립니다.');
        } else {
            alert('수정사항이 없습니다.');
        }
    };

    useEffect(() => {

        AxiosURL.getStudyBoardDetail(studyId, boardId, token.authorization).then(res => {
            setBoardDto(res.data.data);

            setTimeout(() => {
                $('.detail_field').css('opacity', '1');
            }, 300);
        }).catch(err => {
            console.log(err);
            history.goBack();
        });

    }, []);

    return (
        <div className="write_form">
            <div className="mid_con">
                <form>
                    <fieldset className="form_field">
                        <legend>수정하기</legend>
                        <ul>
                            <li>
                                <label htmlFor="title_txt">제목</label>
                                <input type="text" name='title' className="inputTitle" defaultValue={boardDto.title}
                                       required/>
                            </li>
                            <li>
                                <label htmlFor="context_txt">내용</label>
                                <textarea name='content' className="inputContent" defaultValue={boardDto.content}
                                          required/>
                            </li>
                        </ul>
                        <File_Upload/>

                        <div className="button_section">
                            <button id="s_button" onClick={e => _handleSubmit(e)}>등록하기</button>
                            <button type="button" id="c_button" onClick={() => {
                                history.goBack();
                            }}>취소하기
                            </button>
                        </div>

                    </fieldset>
                </form>
            </div>


        </div>

    );
}

export default Study_Board_Update;