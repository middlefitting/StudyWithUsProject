import './Details.css';
import {Link, useHistory} from 'react-router-dom';
import 'moment/locale/ko';
import moment from "moment";
import React, {useState} from "react";




function QNA_Detail(props){

/*    let history = useHistory();

    const goBack=()=>{
        history.push('/NoticeList');
    };*/

    const history= useHistory();

    //현재 날짜와 시간
    const nowTime = moment().format('YYYY/MM/DD');


    //답변 위치로 스크롤
    let ref1 = React.useRef();
    function scrollTo(ref1) {
        if (!ref1.current) return;
        ref1.current.scrollIntoView({ behavior: "smooth" });
    }





//===============================================================
    const [no, setNo] =useState(2);

    const [post, setPost] =useState({
        id:no,
        content:'',
    })

    const[posts, setPosts]= useState([
        {id:1, content:"질문있어요~"}
    ]);

    const handleWrite = () => {
        setPosts([...posts, { ...post, id: no }]);
        setNo(no + 1);
        post.content=''

    };

    const handleForm=(e)=>{
/*
        console.log(e.target.name);
        console.log(e.target.value);
*/

        //computed property names 문법 (키값 동적할당)
        setPost({
            ...post,
            [e.target.name]:e.target.value,
        });
    }
    const handleDelete =(id)=>{
        setPosts(posts.filter((post)=>post.id !==id));
    };



    return(
        <div className="Free_Detail">

            <div className="mid_con">
                <fieldset className="detail_field">
                    <div className="buttons_field">
                    <div className="go_back" onClick={()=> history.push('/QNAList')}>질문게시판 > </div>
                        <div className="detail_delete">삭제</div>
                        <Link to ="/Update_Detail" className="link">
                            <div className="detail_update">수정</div>
                        </Link>
                    </div>
                    <p className="detail_title">여기는 질문하기 제목</p>
                    <div className="user_con">
                        <span className="circle">
                             <img className="default_img" alt="default" src="img/default.png" />
                        </span>
                        <div className="user_info">
                            <div className="detail_id">여기는 아이디</div>
                            <div className="detail_time">{nowTime}</div>
                        </div>
                            <div className="user_right">
                                <div className="views">
                                    <div className="view_num">조회수</div>
                                </div>
                                <div className="comment_button" onClick={() => scrollTo(ref1)}>
                                    <img className="comm_img" alt="com_img" src="img/comment.png"/>
                                    <div className="comment">댓글</div>
                                </div>
                                <img id="empty_heart" className="heart" alt="heart" src="img/empty_heart.png"/>

                            </div>
                        </div>

                    <hr />

                    <div className="content_field">
                        여기는 질문하기 본문
                    </div>
                    <hr />
                    <div className="reply_input" ref={ref1}>
                        <div className="reply_id">
                            여기는 아이디
                        </div>
                        <textarea className="reply_textarea" placeholder="댓글을 남겨 보세요" value={post.content}
                        onChange={handleForm} name="content"
                          onKeyPress={event => {
                              if (event.code === "Enter") {
                                  event.preventDefault();
                                  handleWrite();}
                          }}
                        />
                        <button type="button" className="reply_enter" onClick={handleWrite}> 등록 </button>

                    </div>
                    <ul className="comment_list">
                        <li className="comment_view">
                            {posts.map((post)=>(
                            <div className="comment_area">
                                <div className="comment_img">
                                    <span className="circle">
                                        <img className="default_img" alt="default" src="img/default.png" />
                                     </span>
                                </div>

                                    <div className="comment_box">
                                        <div className="comment_division">
                                            <div className="comment_id">{post.id}</div>
                                            <div className="comment_txt">{post.content}</div>
                                            <div className="comment_time">{nowTime}</div>
                                            <hr />
                                        </div>
                                    </div>
                                <div className="x_sign" onClick={()=>handleDelete(post.id)}>
                                    x
                                </div>


                            </div>
                            ))}
                        </li>
                    </ul>

                </fieldset>

            </div>

        </div>
    );
}

export default QNA_Detail;