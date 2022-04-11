import {Link} from "react-router-dom";
import  "../../App.css";
import Side_Tab from "../../Tabs/Side_Tab";
import Notice_Board from "../BoardComponent/Notice_Board";
import Free_Board from "../BoardComponent/Free_Board";
import QNA_Board from "../BoardComponent/QNA_Board";
import MyPage_Board from "../BoardComponent/MyPage_Board";
import TabContents from "../../Tabs/Tab_Contents";
import {useState} from "react";
import Tab_Name from "../../Tabs/Tab_Name";
import User_Side_Tab from "../../Tabs/User_Side_Tab";
import Modification_confirm from "../BoardComponent/Modification";

// const user = JSON.parse(localStorage.getItem('user-info'))

function MyPageList(){

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
                        <span>누구누구의 글</span>

                    </div>
                    <div className="mid_container">
                        <MyPage_Board />
                    </div>
                </div>

            </div>


        </div>


    );
}
export default MyPageList;