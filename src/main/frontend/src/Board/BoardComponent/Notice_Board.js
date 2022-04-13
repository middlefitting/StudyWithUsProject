import {Link} from "react-router-dom";
import React, {useEffect, useState} from "react";
import $ from 'jquery';
import AxiosURL from "../../Services/AxiosURL";

import "../../App.css";

function  Notice_Board(){

    const [dtoList, setDtoList] = useState({});
    const [pageList, setPageList] = useState([1]);

    const _handlePage = (e, page) => {
        e.preventDefault();

        $('.table_mid_container').css('opacity', '0');

        setTimeout(() => {
            AxiosURL.getList('notice', page).then(res => {
                if (Object.keys(res.data).length > 0) {
                    setDtoList(res.data.dtoList);
                    setPageList(res.data.pageList);
                }
            }).catch(err => {
                console.log(err);
            });

            setTimeout(() => {
                $('.table_mid_container').css('opacity', '1');
            }, 340);
        }, 340);
    };

    useEffect( () => {
        AxiosURL.getList('notice', pageList[0])
            .then(res => {
                if (Object.keys(res).length > 0) {
                    setDtoList(res.data.dtoList);
                    setPageList(res.data.pageList);
                }
            }).catch(err => {
            console.log(err)
        });

        setTimeout(() => {
            $('.table_mid_container').css('opacity', '1');
        }, 300);
    },[]);

    return (
        <>
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
                {dtoList.length ?
                    dtoList.map((notice,idx) => (
                        <tr id="board_body" key={idx}>
                            <td width="10%" className="listTableNum">{dtoList.length - idx}</td>
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
            <div className='pagination_container'>
                {
                    pageList.map((page, idx) =>
                        <div className='page_btn' key={idx} onClick={e => _handlePage(e, page)}>{page}</div>
                    )
                }
            </div>
        </>
    );

}
export default Notice_Board;