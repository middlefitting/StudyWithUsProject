import React, {useEffect, useState} from "react";
import {Link, useHistory, useParams} from 'react-router-dom';

import Comments from "./Comments";
import AxiosURL from "../../Services/AxiosURL";

import './Details.css';
import $ from "jquery";

// const user = JSON.parse(localStorage.getItem('user-info'))

function Board_Detail() {

    const {post_id} = useParams();
    const history = useHistory();

    const [boardDetail, setBoardDetail] = useState({});
    const [postDto, setPostDto] = useState({});

    // //좋아요 누르기(추후에 수정해야함)
    // const [num, plusNum] = useState(0);
    // const ClickLike = () => plusNum(num + 1);

    //현재 게시물을 작성했던 사람의 아이디 값 추출
    const postDto_writer_id = postDto.map && postDto.map(row => row.writer_id);
    const user_id = JSON.parse(localStorage.getItem('user'));

    //답변 위치로 스크롤
    let ref1 = React.useRef()

    function scrollTo(ref1) {
        if (!ref1.current) return;
        ref1.current.scrollIntoView({behavior: "smooth"});
    }

    const _handleDelete = (e) => {
        e.preventDefault();
        if (window.confirm("정말 삭제하시겠습니까?")) {
            AxiosURL.deletePost(post_id);
            history.goBack();
        }
    };


    useEffect(() => {
        if (user_id === null) {
            alert('로그인을 해 주세요.');
            history.push('/signin');
        } else {
            AxiosURL.getBoardDetail(post_id)
                .then((res) => {
                    setBoardDetail(res.data);
                    setPostDto(res.data.postDto);
                });

            setTimeout(() => {
                $('.detail_field').css('opacity', '1');
            }, 600);
        }
    }, []);


    return (
        <>
            {user_id !== null ?
                <div className="Free_Detail">
                    <div className="mid_con">
                        <fieldset className="detail_field">
                            <div className="buttons_field">
                                <div className="go_back" onClick={() => history.goBack()}>뒤로가기 ></div>
                                {user_id && parseInt(postDto_writer_id) === parseInt(user_id.id) ?
                                    <>
                                        <div className="user_only_buttons">
                                            <div id="detail_delete" onClick={e => _handleDelete(e)}>삭제</div>
                                            <Link to={`/Update_Detail/${post_id}`} className="link">
                                                <div id="detail_update">수정</div>
                                            </Link>
                                        </div>
                                    </>
                                    :
                                    ''
                                }
                            </div>
                            {postDto.map && postDto.map((detail, idx) => (
                                <div key={idx}>
                                    <p className="detail_title">{detail.title}</p>
                                    <div className="user_con">
                        <span className="circle">
                             <img className="default_img" alt="default" src={'/img/default.png'}/>
                        </span>
                                        <div className="user_info">
                                            <div className="detail_id">{detail.writer_nickname}</div>
                                            <div className="detail_time">{detail.regDate.substr(0, 10)}</div>
                                        </div>
                                        <div className="user_right">
                                            <div className="views">
                                                <div className="view_num">조회수 : {detail.views}</div>
                                            </div>
                                            <div className="comment_button" onClick={() => scrollTo(ref1)}>
                                                <img className="comm_img" alt="com_img" src={'/img/comment.png'}/>
                                                <div className="comment">댓글</div>
                                            </div>

                                        </div>
                                    </div>

                                    <hr/>

                                    <div className="content_field">
                                        {detail.content}
                                    </div>
                                </div>
                            ))}
                            <div className="user_bottom">
                                <div className="comment_button_bottom">
                                    <img className="comm_img_bottom" alt="com_img" src={'/img/comment.png'}/>
                                    <div className="comment_bottom">댓글</div>
                                </div>
                                {/*<div className="heart_img_bottom">*/}
                                {/*    <img id="empty_heart" className="heart_bottom" alt="heart"*/}
                                {/*         src={'/img/empty_heart.png'} onClick={() => {*/}
                                {/*        ClickLike();*/}
                                {/*    }}/>*/}
                                {/*    <div className="like_bottom">좋아요 {num}</div>*/}
                                {/*</div>*/}
                            </div>
                            <hr ref={ref1}/>
                            <Comments/>
                        </fieldset>
                    </div>
                </div>
                :
                ''
            }
        </>
    );
}

export default Board_Detail;