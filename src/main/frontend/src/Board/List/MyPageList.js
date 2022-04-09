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

const user = JSON.parse(localStorage.getItem('user-info'))

function MyPageList(){

    const [activeTab, setActiveTab] = useState("tab4");

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
                        <Tab_Name id="tab1" activeTab={activeTab}>
                            <span>공지사항</span>
                            <button type="submit" id="w_button" value="글씨기" >
                                <Link to='/Notice_Write'className="link">글쓰기</Link>
                            </button>
                        </Tab_Name>
                        <Tab_Name id="tab2" activeTab={activeTab}>
                            <span>자유게시판</span>
                            <button type="submit" id="w_button" value="글씨기">
                                <Link to='/Board_Write' className="link">글쓰기</Link>
                            </button>
                        </Tab_Name>
                        <Tab_Name id="tab3" activeTab={activeTab}>
                            <span>질문게시판</span>
                            <button type="submit" id="w_button" value="글씨기">
                                <Link to='/QNA_Write' className="link">글쓰기</Link>
                            </button>
                        </Tab_Name>
                        <Tab_Name id="tab4" activeTab={activeTab}>
                            <span>{user}님의 글</span>
                        </Tab_Name>
                        <Tab_Name id="tab5" activeTab={activeTab}>
                            <span>회원정보수정</span>
                        </Tab_Name>
                    </div>
                    <div className="mid_container">
                        <TabContents id="tab1" activeTab={activeTab}>
                            <Notice_Board />
                        </TabContents>
                        <TabContents id="tab2" activeTab={activeTab}>
                            <Free_Board />
                        </TabContents>
                        <TabContents id="tab3" activeTab={activeTab}>
                            <QNA_Board />
                        </TabContents>
                        <TabContents id="tab4" activeTab={activeTab}>
                            <MyPage_Board />
                        </TabContents>
                    </div>
                </div>

            </div>


        </div>


    );
}
export default MyPageList;