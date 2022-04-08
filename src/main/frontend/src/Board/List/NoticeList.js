import {Link} from "react-router-dom";
import  "../../App.css";
import Side_Tab from "../../Tabs/Side_Tab";
import Notice_Board from "../BoardComponent/Notice_Board";
import Free_Board from "../BoardComponent/Free_Board";
import QNA_Board from "../BoardComponent/QNA_Board";
import TabContents from "../../Tabs/Tab_Contents";
import {useState} from "react";
import Tab_Name from "../../Tabs/Tab_Name";
import MyPage_Board from "../BoardComponent/MyPage_Board";

function NoticeList(){

    /*const user = JSON.parse(localStorage.getItem('user-info'))*/

    const [activeTab, setActiveTab] = useState("tab1");



    return(
        <div className="container">
            <div className="cont_container">
                <div className="Side_Tab">
                    {localStorage.getItem('user-info') ?
                        <>
                            <ul className="nav_con">
                                <Side_Tab title="공지사항" id="tab1" activeTab={activeTab} setActiveTab={setActiveTab}/>
                                <Side_Tab title="자유게시판" id="tab2" activeTab={activeTab} setActiveTab={setActiveTab}/>
                                <Side_Tab title="질문게시판" id="tab3" activeTab={activeTab} setActiveTab={setActiveTab}/>
                                <Side_Tab title="내 글" id="tab4" activeTab={activeTab} setActiveTab={setActiveTab}/>
                            </ul>
                        </>
                        :
                        <>
                            <ul className="nav_con">
                                <Side_Tab title="공지사항" id="tab1" activeTab={activeTab} setActiveTab={setActiveTab}/>
                                <Side_Tab title="자유게시판" id="tab2" activeTab={activeTab} setActiveTab={setActiveTab}/>
                                <Side_Tab title="질문게시판" id="tab3" activeTab={activeTab} setActiveTab={setActiveTab}/>
                            </ul>
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
                                <Link to='/Free_Write' className="link">글쓰기</Link>
                            </button>
                        </Tab_Name>
                        <Tab_Name id="tab3" activeTab={activeTab}>
                            <span>질문게시판</span>
                            <button type="submit" id="w_button" value="글씨기">
                                <Link to='/QNA_Write' className="link">글쓰기</Link>
                            </button>
                        </Tab_Name>
                        <Tab_Name id="tab4" activeTab={activeTab}>
                            <span>님의 글</span>
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
export default NoticeList;