import {Link, useHistory} from "react-router-dom";
import React, {useEffect, useRef, useState} from "react";
import  "../../App.css";
import {useForm} from "react-hook-form";
import AxiosURL from "../../Services/AxiosURL";


function  Free_Board(){

    useEffect(() => {
        AxiosURL.getNoticeList()
            .then((response) => {
                console.log(response.data) // array
                let result = response.data
                localStorage.setItem("result",JSON.stringify(result))
            //     alert(JSON.stringify(" 글 등록이 완료되었습니다. ")) // 나중에 모달창으로 교체예정
            //     history.push("/BoardList")
            //     window.location.reload()
            // }).catch(error => {
            // console.log(error)
            // alert(JSON.stringify(" 정보를 다시 입력해주세요. ")) // 나중에 모달창으로 교체예정
        })
    }, []);

    const { watch, register, formState: {errors}, setError, handleSubmit } = useForm({mode:"onChange"});
    const history = useHistory();
    // const post = JSON.parse(localStorage.getItem('post-info'));
    const posts = JSON.parse(localStorage.getItem('posts'));


    return(

            <table id="main_board">
                <thead>
                <tr id="board_head">
                    <th width="10%" className="listHeadNum">No.</th>
                    <th width="50%" className="listHeadTitle">제목</th>
                    <th width="15%" className="listHeadAuthor">작성자</th>
                    <th width="15%" className="listHeadDate">작성날짜</th>
                    <th width="10%" className="listHeadViews">조회</th>
                </tr>
                </thead>
                <tbody>

                    <tr id="board_body" >

                        <td width="10%" className="listTableNum">1</td>
                        <td width="50%" className= "listTableTitle">
                            <Link to ="/Free_Detail" className="link">
                                자유게시글
                            </Link>
                        </td>
                        <td width="15%" className="listTableAuthor">자유</td>
                        <td width="15%" className="listTableDate">2022-03-18</td>
                        <td width="10%" className="listTableViews">3</td>
                    </tr>



{/*                    <tr id="board_body">
                        <td width="10%" className="listTableNum"></td>
                        <td width="90%" className="listNoData">작성된 글이 없습니다</td>
                    </tr>*/}


                </tbody>
            </table>


    );
}
export default Free_Board;