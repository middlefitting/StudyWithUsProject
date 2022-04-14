import React, {useState, useEffect} from 'react';
import {useHistory, useParams} from "react-router-dom";
import File_Upload from "../Write_form/Upload/File_Upload";
import AxiosURL from "../../Services/AxiosURL";

import '../../App.css';
import '../Write_form/Write.css';

function Update_Detail() {

    //뒤로가기 설정
    const history = useHistory();
    const {post_id} = useParams();
    const [postDto, setPostDto] = useState({});

    const token = JSON.parse(localStorage.getItem('user-info'));

    const _handlePost = (e) => {

        e.preventDefault();

        const title = document.getElementsByName('title')[0].value;
        const content = document.getElementsByName('content')[0].value;
        console.log(postDto)
        if (postDto.title !== title || postDto.content !== content) {
            const data = {
                category: postDto.category,
                post_id: postDto.post_id,
                writer_id: postDto.writer_id,
                writer_nickname: postDto.writer_nickname,
                title: title,
                content: content,
                views: postDto.views
            };

            AxiosURL.postEdit(post_id, token.authorization, data).then(res => {
                history.goBack();
            }).catch(err => {
                console.log(err);
            })
        }
    }

    useEffect(() => {
        AxiosURL.getEdit(post_id).then(res => {
                setPostDto(res.data[0]);
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
                                <input
                                    type="text"
                                    name='title'
                                    className="inputTitle"
                                    defaultValue={postDto.title}
                                    required
                                />
                            </li>
                            <li>
                                <label htmlFor="context_txt">내용</label>
                                <textarea
                                    name='content'
                                    className="inputContent"
                                    defaultValue={postDto.content}
                                    required
                                />
                            </li>
                        </ul>
                        <File_Upload/>
                        <div className="button_section">
                            <button type="submit" id="s_button" onClick={e => _handlePost(e)}>등록하기</button>
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

export default Update_Detail;
