import {Link} from "react-router-dom";
import React, {useEffect, useState} from "react";
import  "../../App.css";
import AxiosURL from "../../Services/AxiosURL";

function  Notice_Board(){

    const [dtoList, setDtoList] = useState({});
    const [noticeLists, setNoticeLists] = useState({});
    const [loading, setLoading] = useState(false);
    const [currentPage, setCurrentPage] = useState(1);
    const [postsPerPage, setPostsPerPage] = useState(10);

    useEffect( () => {
        async function fetchData() {
            setLoading(true);
            const response = await AxiosURL.getNoticeList();
            if (Object.keys(response).length > 0) {
                setNoticeLists(response.data);
                setDtoList(response.data.dtoList)
            }
            setLoading(false);
        }
        fetchData();
    },[]);
    console.log(noticeLists);
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
                    dtoList.map((notice,idx) => (
                        <tr id="board_body" key={idx}>
                            <td width="10%" className="listTableNum">{notice.post_id}</td>
                            <td width="50%" className="listTableTitle">
                                <Link to={`/Board_Detail/${notice.post_id}`} className="link">
                                    {notice.title}
                                </Link>
                            </td>
                            <td width="15%" className="listTableAuthor">{notice.writer_nickname}</td>
                            <td width="15%" className="listTableDate">{notice.regDate.substr(0, 10)}</td>
                            <td width="10%" className="listTableViews">{notice.views}</td>
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

}
export default Notice_Board;