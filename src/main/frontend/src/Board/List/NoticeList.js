import {Link} from "react-router-dom";
import  "../../App.css";
import Side_Tab from "../../Tabs/Side_Tab";
import Notice_Board from "../BoardComponent/Notice_Board";
import React, {useState} from "react";
import User_Side_Tab from "../../Tabs/User_Side_Tab";
import Search_Component from "./Components/Search_Component";


//const user = JSON.parse(localStorage.getItem('user-info'))

function NoticeList(){


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
                <div className="mid_container">
                    <div className="page_name">
                            <span>공지사항</span>
                        {localStorage.getItem('user-info') ?
                            <>
                            <button type="submit" id="w_button" value="글씨기" >
                                <Link to='/Board_Write'className="link">글쓰기</Link>
                            </button>
                            </>
                            :
                            <>
                            </>
                            }
                    </div>
                    <div className="table_mid_container">
                            <Notice_Board />
                        <Search_Component category={'notice'}/>
                    </div>
                </div>

            </div>


        </div>

    );
}
export default NoticeList;