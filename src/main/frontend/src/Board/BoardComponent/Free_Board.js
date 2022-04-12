import {Link, useHistory, useParams} from "react-router-dom";
import React, {useEffect, useRef, useState} from "react";
import  "../../App.css";
import {useForm} from "react-hook-form";
import AxiosURL from "../../Services/AxiosURL";


function  Free_Board(){

/*    useEffect(() => {
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
    }, []);*/



    const [dtoList, setDtoList] = useState({});
    const [freeLists, setFreeLists] = useState({});
    const [loading, setLoading] = useState(false);


    useEffect( () => {
        async function fetchData() {
            setLoading(true);
            // page 수정
            const response = await AxiosURL.getList('free', 1);
            if (Object.keys(response).length > 0) {
                setFreeLists(response.data);
                setDtoList(response.data.dtoList)
            }
            setLoading(false);
        }
        fetchData();
    },[]);
    console.log(freeLists);
    // console.log(dtoList)



        return (
            <>
                {loading &&
                <></>
                }
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
                    {Object.keys(dtoList).length ?
                        dtoList.map((free,idx) => (
                                <tr id="board_body" key={idx}>
                                    <td width="10%" className="listTableNum">{free.post_id}</td>
                                    <td width="50%" className="listTableTitle">
                                        <Link to={`/Board_Detail/${free.post_id}`} className="link">
                                            {free.title}
                                        </Link>
                                    </td>
                                    <td width="15%" className="listTableAuthor">{free.writer_nickname}</td>
                                    <td width="15%" className="listTableDate">{free.regDate.substr(0, 10)}</td>
                                    <td width="10%" className="listTableViews">{free.views}</td>
                                </tr>
                            ))
                        :
                        <tr id="board_body">
                            <td className="listTableNum"></td>
                            <td  className="listNoData">작성된 글이 없습니다</td>
                        </tr>
                    }
                    </tbody>
                </table>
            </>
        );





/*
    const { watch, register, formState: {errors}, setError, handleSubmit } = useForm({mode:"onChange"});
    const history = useHistory();
    // const post = JSON.parse(localStorage.getItem('post-info'));
    const posts = JSON.parse(localStorage.getItem('posts'));
*/



}
export default Free_Board;