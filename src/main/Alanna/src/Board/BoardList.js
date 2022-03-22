import {Link} from "react-router-dom";
import  "../App.css";
import Header from "../Components/Header";
import Footer from "../Components/Footer";
import Side_Tab from "../Tabs/Side_Tab";
import Notice_Board from "./Notice_Board";
import Free_Board from "./Free_Board";
import QNA_Board from "./QNA_Board";
import TabContents from "../Tabs/Tab_Contents";
import {useState} from "react";

function BoardList(){


        const [activeTab, setActiveTab] = useState("tab1");



    return(
        <div className="container">
        <Header> </Header>
            <div className="mid_container">
                <div className="page_name">
                    <TabContents id="tab1" activeTab={activeTab}>
                        공지사항
                    </TabContents>
                    <TabContents id="tab2" activeTab={activeTab}>
                        자유게시판
                    </TabContents>
                    <TabContents id="tab3" activeTab={activeTab}>
                        질문게시판
                    </TabContents>
                    <Link to='/Write'>
                        <button type="submit" id="w_button" value="글씨기">글쓰기</button>
                    </Link>
                </div>
                <div className="cont_container">
                    <div className="Side_Tab">
                        <ul className="nav_con">
                        <Side_Tab title="공지사항" id="tab1" activeTab={activeTab} setActiveTab={setActiveTab}/>
                        <Side_Tab title="자유게시판" id="tab2" activeTab={activeTab} setActiveTab={setActiveTab}/>
                        <Side_Tab title="질문게시판" id="tab3" activeTab={activeTab} setActiveTab={setActiveTab}/>
                        </ul>
                    </div>
                    <div className="list_con">
                        <TabContents id="tab1" activeTab={activeTab}>
                            <Notice_Board />
                        </TabContents>
                        <TabContents id="tab2" activeTab={activeTab}>
                            <Free_Board />
                        </TabContents>
                        <TabContents id="tab3" activeTab={activeTab}>
                            <QNA_Board />
                        </TabContents>
                    </div>
                </div>
            </div>

            <Footer> </Footer>
        </div>


    );
}
export default BoardList;