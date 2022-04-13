import {Link} from "react-router-dom";
import  "../../App.css";
import Side_Tab from "../../Tabs/Side_Tab";
import Free_Board from "../BoardComponent/Free_Board";
import User_Side_Tab from "../../Tabs/User_Side_Tab";
import Pagination_Component from "../Page/Pagination_Component";
import React from "react";


// const user = JSON.parse(localStorage.getItem('user-info'))

function FreeList(){

    return(
        <div className="container">
            <div className="cont_container">
                <div className="Side_Tab">
                    {localStorage.getItem('user-info') ?
                    <>
                       <User_Side_Tab />
                    </>
                    :
                    <>
                        <Side_Tab />
                    </>
                    }
                </div>
                <form action="/board/search?type=${type}&keyword=${keyword}" method="get" name="searchForm">
                    <select name="type">
                        <option value="t">제목</option>  {/*보낼 값  = type: t */}
                        <option value="c">내용</option>
                        <option value="w">작성자</option>
                        <option value="tc">제목 + 내용</option>
                        <option value="tcw">제목 + 내용 + 작성자</option>
                    </select>
                    <input type="text" name="keyword"/> {/*보낼 값 key :입력값 */}
                    <input type="submit" value="검색"/>
                </form>
                    <div className="mid_container">
                        <div className="page_name">
                                <span>자유게시판</span>
                                <button type="submit" id="w_button" value="글씨기">
                                    <Link to='/Board_Write' className="link">글쓰기</Link>
                                </button>
                        </div>
                      <div className="table_mid_container">
                            <Free_Board />
                    </div>



                </div>

            </div>


        </div>


    );
}
export default FreeList;