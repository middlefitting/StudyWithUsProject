import './Details.css';
import {Link, useHistory, useParams} from 'react-router-dom';
import 'moment/locale/ko';
import React, {useEffect, useState} from "react";
import axios, {Axios} from "axios";
import AxiosURL from "../../Services/AxiosURL";
import Comments from "./Comments";



// const user = JSON.parse(localStorage.getItem('user-info'))



function Board_Detail(){

    const {post_id} = useParams();
/*
    console.log(post_id);
*/

;

const [boardDetail, setBoardDetail] = useState({});
const [postDto, setPostDto] = useState({});




useEffect( () => {
        async function fetchData() {
            await AxiosURL.getBoardDetail(post_id)
                .then((res) => {
                    /*console.log('res : ', res.data)*/

                    setBoardDetail(res.data);

                    console.log('첫번째');

                    setPostDto(res.data.postDto);

                    console.log('두번째');

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


//현재 게시물을 작성했던 사람의 닉네임 값
/*   const post_writer_nickname =  postDto.map &&postDto.map(row=>row.writer_nickname);
 console.log('안녕 : ' + post_writer_nickname);
 console.log('드디어: ' + user_nickname);


 let result;
 if(post_writer_nickname == user_nickname){
    result = "true";
 }else{
     result="false"
 }
    console.log(result);*/



    //현재 게시물을 작성했던 사람의 아이디 값 추출
    const postDto_writer_id =  postDto.map &&postDto.map(row=>row.writer_id);



    const user_id = JSON.parse(localStorage.getItem('user'));





    return(
        <div className="Free_Detail">

            <div className="mid_con">
                <fieldset className="detail_field">
                    <div className="buttons_field">
                    <div className="go_back" onClick={()=> history.goBack()}>뒤로가기 > </div>


                        {user_id && parseInt(postDto_writer_id) === parseInt(user_id.id) ?
                            <>
                                <div className="user_only_buttons">
                                    <div id="detail_delete">삭제</div>
                                    <Link to ="/Update_Detail" className="link">
                                        <div id="detail_update">수정</div>
                                    </Link>
                                </div>
                            </>
                           :
                           ''
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


                    <hr ref={ref1} />
                <Comments />

                </fieldset>

            </div>

        </div>
    );



}

export default Board_Detail;