import {Link} from "react-router-dom";
import  "../../App.css";
import Side_Tab from "../../Tabs/Side_Tab";
import Free_Board from "../BoardComponent/Free_Board";
import User_Side_Tab from "../../Tabs/User_Side_Tab";
import Pagination_Component from "../Page/Pagination_Component";


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
                    <div className="mid_container">
                        <div className="page_name">
                                <span>자유게시판</span>
                            {localStorage.getItem('user-info') ?
                            <>
                                <button type="submit" id="w_button" value="글씨기">
                                    <Link to='/Board_Write' className="link">글쓰기</Link>
                                </button>
                            </>
                                :
                            <>
                            </>
                            }

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