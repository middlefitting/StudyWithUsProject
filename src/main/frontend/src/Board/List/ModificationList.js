import {Link} from "react-router-dom";
import '../../styles/css/SignUp.css'
import Side_Tab from "../../Tabs/Side_Tab";
import Free_Board from "../BoardComponent/Free_Board";
import User_Side_Tab from "../../Tabs/User_Side_Tab";
import Modification from "../BoardComponent/Modification";


function ModificationList(){

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
                    <div className="page_name_modi">
                        
                    </div>
                    <div className="mid_container">
                        <Modification />
                    </div>
                </div>

            </div>


        </div>


    );
}
export default ModificationList;