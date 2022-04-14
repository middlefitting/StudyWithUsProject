import React, {useState, useEffect} from "react";
import {Link, useHistory, useParams} from 'react-router-dom';
import 'moment/locale/ko';
import moment from "moment";
import $ from 'jquery';
import AxiosURL from "../../Services/AxiosURL";

import ImgDefault from '../../Board/Write_Details/img/default.png';
import ImgComment from '../../Board/Write_Details/img/comment.png';
import ImgHeart from '../../Board/Write_Details/img/empty_heart.png';

import '../../Board/Write_Details/Details.css';

function Study_Board_Detail() {

    const history = useHistory();
    const {studyId, boardId} = useParams();
    const token = JSON.parse(localStorage.getItem('user-info'));
    const user = JSON.parse(localStorage.getItem('user'));

    const [boardDto, setBoardDto] = useState({});
    const [comments, setComments] = useState({});
    const [num, plusNum] = useState(0);
    const [no, setNo] = useState(2);
    const [post, setPost] = useState({
        id: no,
        content: '',
    })
    const [posts, setPosts] = useState([
        {id: 1, content: "나는 첫번째 댓글~"}
    ]);

    let ref1 = React.useRef();

    // const ClickLike = () => {
    //     plusNum(num + 1);
    // };

    const scrollTo = (ref1) => {
        if (!ref1.current) return;
        ref1.current.scrollIntoView({behavior: "smooth"});
    }

    const _handleWrite = (e) => {
        e.preventDefault();

        const _blank = /^\s+|\s+$/g;
        const content = document.getElementsByName('content')[0].value;

        if (content.length > 9 && content.replace(_blank, '') !== '') {
            const data = {
                content: content
            };

            AxiosURL.postStudyBoardDetailComment(studyId, boardId, data, token.authorization).then(() => {
                window.location.reload();
            }).catch(err => {
                console.log(err);
            });
        } else {
            alert('댓글은 10자 이상 등록이 가능합니다.');
        }
    };

    const handleForm = (e) => {
        setPost({
            ...post,
            [e.target.name]: e.target.value,
        });
    }

    const _handleDelComment = (e, commentId) => {
        e.preventDefault();

        AxiosURL.deleteStudyBoardDetailComment(studyId, boardId, commentId, token.authorization).then(() => {
            window.location.reload();
        }).catch(err => {
            console.log(err);
        });
    };

    const _handleDelBoard = (e) => {
        e.preventDefault();

        AxiosURL.deleteStudyBoardDetail(studyId, boardId, token.authorization).then(() => {
            history.goBack();
        });
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

        AxiosURL.getStudyBoardDetailComment(studyId, boardId, token.authorization).then(res => {
            setComments(res.data.data.content);
        }).catch(err => {
            console.log(err);
        });

    }, []);


    return (
        <>
            {boardDto ?
                <div className="Study_Detail">
                    <div className="mid_con">
                        <fieldset className="detail_field">
                            <div className="buttons_field">
                                <div className="go_back" onClick={() => history.goBack()}> 스터디로 돌아가기 ></div>
                                {user && user.nickname === boardDto.nickname ?
                                    <div className="user_only_buttons">
                                        <div id="detail_delete" onClick={e => _handleDelBoard(e)}>삭제</div>
                                        <Link to={`/Study_Board_Update/${studyId}/${boardId}`} className="link">
                                            <div id="detail_update">수정</div>
                                        </Link>
                                    </div>
                                    :
                                    ''
                                }
                            </div>
                            <p className="detail_title">{boardDto.title}</p>
                            <div className="user_con">
                        <span className="circle">
                             <img className="default_img" alt="default" src={ImgDefault}/>
                        </span>
                                <div className="user_info">
                                    <div className="detail_id">{boardDto.nickname}</div>
                                    <div className="detail_time">{String(boardDto.regDate).split('T')[0]}</div>
                                </div>
                                <div className="user_right">
                                    <div className="views">
                                        <div className="view_num">조회수 {boardDto.studyBoardViewCount}</div>
                                    </div>
                                    <div className="comment_button" onClick={() => scrollTo(ref1)}>
                                        <img className="comm_img" alt="com_img" src={ImgComment}/>
                                        <div className="comment">댓글</div>
                                    </div>

                                </div>
                            </div>

                            <hr/>

                            <div className="content_field">
                                {boardDto.content}
                            </div>
                            <div className="user_bottom">
                                <div className="comment_button_bottom">
                                    <img className="comm_img_bottom" alt="com_img" src={ImgComment}/>
                                    <div className="comment_bottom">댓글 수 {boardDto.studyBoardCommentCount}</div>
                                </div>
                                {/*<div className="heart_img_bottom">*/}
                                {/*    <img id="empty_heart" className="heart_bottom" alt="heart"*/}
                                {/*         src={ImgHeart} onClick={ClickLike}/>*/}
                                {/*    <div className="like_bottom">좋아요 {boardDto.studyBoardRecommendCount}</div>*/}
                                {/*</div>*/}
                            </div>
                            <hr/>
                            <div className="reply_input" ref={ref1}>
                                <div className="reply_id">
                                    여기는 아이디
                                </div>
                                <textarea className="reply_textarea" placeholder="댓글을 남겨 보세요" name="content"/>
                                <button type="button" className="reply_enter" onClick={e => _handleWrite(e)}> 등록</button>
                            </div>
                            <ul className="comment_list">
                                <li className="comment_view">
                                    {comments.length > 0 ?
                                        comments.map((comment, idx) => (
                                            <div className="comment_area" key={idx}>
                                                <div className="comment_img">
                                                <span className="circle">
                                                    <img className="default_img" alt="default" src={ImgDefault}/>
                                                </span>
                                                </div>
                                                <div className="comment_box">
                                                    <div className="comment_division">
                                                        <div className="comment_id">{comment.nickname}</div>
                                                        <div className="comment_txt">{comment.content}</div>
                                                        <div className="comment_time">{String(comment.regDate).split('T')[0]}</div>
                                                        <hr/>
                                                    </div>
                                                </div>
                                                {comment.nickname === user.nickname ?
                                                    <div className="x_sign" onClick={(e) => _handleDelComment(e, comment.studyBoardCommentId)}>
                                                        x
                                                    </div>
                                                    :
                                                    ''
                                                }
                                            </div>
                                        ))
                                        :
                                        ''
                                    }
                                </li>
                            </ul>
                        </fieldset>
                    </div>
                </div>
                :
                ''
            }
        </>
    );
}

export default Study_Board_Detail;