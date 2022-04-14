import {Link} from "react-router-dom";
import  "../../App.css";
import Side_Tab from "../../Tabs/Side_Tab";
import MyPage_Board from "../BoardComponent/MyPage_Board";
import User_Side_Tab from "../../Tabs/User_Side_Tab";


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