import React, {useEffect, useState} from 'react';
import './Details.css';
import AxiosURL from "../../Services/AxiosURL";
import {useParams} from "react-router-dom";


const user = JSON.parse(localStorage.getItem('user-info'))
const user_info_id = JSON.parse(localStorage.getItem('user'));
const user_id = JSON.parse(localStorage.getItem('user'));

function Comments(props) {

    const {post_id} = useParams();
    const [commentsList, setCommentList] = useState({});

    const onEnterPress=(e)=>{
        if(e.key ==='Enter'){
           onSubmit(e);
        }
    }


    const onSubmit = (e) => {
        e.preventDefault();

        const  _black = /^\s+|\s+$/g;

        let comment_data = {
            writer_nickname: user_info_id.nickname,
            writer_id: parseInt(user_info_id.id),
            post_id: parseInt(post_id),
            content: document.getElementsByName('comment_content')[0].value
        }

        if (comment_data.content.replace(_black, '') !== '') {
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
            });
        }else{
            alert('댓글을 입력해주세요');
        }



    }


    useEffect(() => {
            AxiosURL.getBoardDetail(post_id)
                .then((res) => {
                    setCommentList(res.data.commentsList);
                });
    }, []);



    const handleDelete = (comment_id, writer_id) => {
        if (parseInt(user_id.id) === parseInt(writer_id)) {
            AxiosURL.deleteComment(comment_id);
            if (window.confirm("정말 삭제하시겠습니까?")) {
                setCommentList(commentsList.filter((comment) => comment.comment_id !== comment_id));
            }

        }else{
            alert('본인이 작성한 댓글만 삭제 가능합니다');
        }
    };


    return (
        <>
            <div className="reply_input">
                <div className="reply_id">
                    {user_id.nickname}
                </div>
                <textarea
                    className="reply_textarea"
                    name="comment_content"
                    placeholder="댓글을 남겨 보세요"
                    onKeyPress={onEnterPress}
                />
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
                                <div className="x_sign"
                                     onClick={() => handleDelete(comment.comment_id, comment.writer_id)}>
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