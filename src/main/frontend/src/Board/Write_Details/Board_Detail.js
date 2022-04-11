import './Details.css';
import {Link, useHistory, useParams} from 'react-router-dom';
import 'moment/locale/ko';
import React, {useEffect, useState} from "react";
import axios, {Axios} from "axios";
import AxiosURL from "../../Services/AxiosURL";


const user = JSON.parse(localStorage.getItem('user-info'))




function Board_Detail(){

    const {post_id} = useParams();
/*
    console.log(post_id);
*/



const [boardDetail, setBoardDetail] = useState({});
const [postDto, setPostDto] = useState({});
const [commentsList, setCommentList] = useState({});



useEffect( () => {
        async function fetchData() {
            await AxiosURL.getBoardDetail(post_id)
                .then((res) => {
                    /*console.log('res : ', res.data)*/
                    setBoardDetail(res.data);
                    setPostDto(res.data.postDto);
                    setCommentList(res.data.commentsList);
                });
                }
                fetchData();
            },[]);
            console.log(boardDetail);







//==============================================================
    const history= useHistory();




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
        {id:1, content:"나는 첫번째 댓글~"}
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
    const handleDelete =(comment_id)=>{
        setPosts(posts.filter((post)=>post.comment_id !==comment_id));
    };



    //좋아요 누르기(추후에 수정해야함)
    const[num, plusNum] = useState(0);
    const ClickLike=()=>plusNum(num+1);

/*
    const ClickLike = () => {
        if (document.getElementById('id') !== undefined && pwd) {
            Axios
                .get('url', param)
                .then(res =>
                if (res === null || res === undefined) {
                alert(error)
            } else {
                plusNum(num+1);
            }
        }
    }
*/


    return(
        <div className="Free_Detail">

            <div className="mid_con">
                <fieldset className="detail_field">
                    <div className="buttons_field">
                    <div className="go_back" onClick={()=> history.goBack()}>뒤로가기 > </div>
                        {localStorage.getItem('user-info') ?
                            <>
                            <div className="user_only_buttons">
                        <div className="detail_delete">삭제</div>
                        <Link to ="/Update_Detail" className="link">
                            <div className="detail_update">수정</div>
                        </Link>
                            </div>
                            </>
                            :
                            <></>
                        }
                    </div>

                        { postDto.map && postDto.map((detail,idx) => (
                            <div key={idx}>
                    <p className="detail_title" >{detail.title}</p>
                    <div className="user_con">
                        <span className="circle">
                             <img className="default_img" alt="default" src={'/img/default.png'} />
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
                                <img className="comm_img" alt="com_img" src={'/img/comment.png'} />
                                <div className="comment">댓글</div>
                            </div>

                        </div>
                        </div>

                    <hr />

                    <div className="content_field">
                        {detail.content}
                    </div>
                            </div>
                        ))}

                    <div className="user_bottom">
                        <div className="comment_button_bottom" >
                            <img className="comm_img_bottom" alt="com_img" src={'/img/comment.png'}/>
                            <div className="comment_bottom">댓글 수</div>
                        </div>
                        <div className="heart_img_bottom">
                            <img id="empty_heart" className="heart_bottom" alt="heart"
                                 src={'/img/empty_heart.png'}onClick={() => { ClickLike(); }} />
                            <div className="like_bottom" >좋아요 {num}</div>
                        </div>
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
                            {commentsList.map && commentsList.map((comment,idx)=>(
                            <div className="comment_area" key={idx}>
                                <div className="comment_img">
                                    <span className="circle">
                                        <img className="default_img" alt="default" src={'/img/default.png'} />
                                     </span>
                                </div>

                                    <div className="comment_box">
                                        <div className="comment_division">
                                            <div className="comment_id">{comment.writer_nickname}</div>
                                            <div className="comment_txt">{comment.content}</div>
                                            <div className="comment_time">{comment.regDate.substr(0, 10)}</div>
                                            <hr />
                                        </div>
                                    </div>
                                <div className="x_sign" onClick={()=>handleDelete(comment.comment_id)}>
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

export default Board_Detail;