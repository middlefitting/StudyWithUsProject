import React, {useEffect, useState} from 'react';
import './Details.css';
import AxiosURL from "../../Services/AxiosURL";
import {useParams} from "react-router-dom";


const user = JSON.parse(localStorage.getItem('user-info'))
const user_info_id = JSON.parse(localStorage.getItem('user'));


function Comments(props) {

    const {post_id} = useParams();
    const [commentsList, setCommentList] = useState({});


    const onSubmit = (e) => {
        e.preventDefault();

        let comment_data = {
            writer_nickname: user_info_id.nickname,
            writer_id: parseInt(user_info_id.id),
            post_id: parseInt(post_id),
            content: document.getElementsByName('comment_content')[0].value
        }

        AxiosURL.saveComment(comment_data)
            .then((response) => {
                comment_data.comment_id = response.data;
                comment_data.modDate = new Date().toISOString();
                comment_data.regDate = new Date().toISOString();

                let appendedCommentsList = commentsList;
                appendedCommentsList.push(comment_data);

                setCommentList(appendedCommentsList);

                document.getElementsByName('comment_content')[0].value = '';
                window.location.reload();
            }).catch(error => {
            console.log(error)
        })
    }

    useEffect(() => {
            AxiosURL.getBoardDetail(post_id)
                .then((res) => {
                    setCommentList(res.data.commentsList);
                });
    }, []);


    //시간 되면 모달창 디자인
    const handleDelete = (comment_id, nickname) => {
        if (user.nickname === '0000') {
            //0000은 채영's db 안에 닉네임중 하나(바꿔야함)
            //아직 로그인 직접해서 삭제는 안해봄
            //   let appendedCommentList = commentsList;
            AxiosURL.deleteComment(comment_id);
            if (window.confirm("정말 삭제하시겠습니까?")) {
                setCommentList(commentsList.filter((comment) => comment.comment_id !== comment_id));
            }
        }
    };

    return (
        <>
            <div className="reply_input">
                <div className="reply_id">
                    여기는 아이디
                </div>
                <textarea
                    className="reply_textarea"
                    name="comment_content"
                    placeholder="댓글을 남겨 보세요"/>
                <button type="button" className="reply_enter" onClick={e => onSubmit(e)}> 등록</button>
            </div>
            <ul className="comment_list">
                <li className="comment_view">
                    {commentsList.map && commentsList.map((comment, idx) => (
                        <div className="comment_area" key={idx}>
                            <div className="comment_img">
                                    <span className="circle">
                                        <img className="default_img" alt="default" src={'/img/default.png'}/>
                                     </span>
                            </div>
                            <div className="comment_box">
                                <div className="comment_division">
                                    <div className="comment_id">{comment.writer_nickname}</div>
                                    <div className="comment_txt">{comment.content}</div>
                                    <div className="comment_time">{comment.regDate.substr(0, 10)}</div>
                                    <hr/>
                                </div>
                            </div>
                            <div className="x_sign" onClick={() => handleDelete(comment.comment_id, comment.nickname)}>
                                x
                            </div>
                        </div>
                    ))}
                </li>
            </ul>
        </>
    );
}

export default Comments;