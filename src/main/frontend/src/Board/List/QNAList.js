import {Link} from "react-router-dom";
import  "../../App.css";
import Side_Tab from "../../Tabs/Side_Tab";
import QNA_Board from "../BoardComponent/QNA_Board";
import User_Side_Tab from "../../Tabs/User_Side_Tab";
import React from "react";


// const user = JSON.parse(localStorage.getItem('user-info'))

function QNAList(){

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
                            <span>질문게시판</span>
                            <button type="submit" id="w_button" value="글씨기">
                                <Link to='/Board_Write' className="link">글쓰기</Link>
                            </button>
                    </div>
                    <div className="table_mid_container">
                            <QNA_Board />


                    </div>
                </div>
            </div>
        </div>


    );
}
export default QNAList;