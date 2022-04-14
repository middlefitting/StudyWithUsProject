import './Side_Tab.css'
import '../App.css'
import {Link} from "react-router-dom";

function User_Side_Tab(){

    const sideTab = [
        {name:'공지사항',link:'/BoardList/notice'},
        {name:'자유게시판',link:'/BoardList/free'},
        {name:'질문게시판',link:'/BoardList/question'},
        {name:'내글',link:'/MyPageList'},
        {name:'회원정보 수정',link:'/ModificationList'}
    ]


    return(
        <ul className="nav_con">
        {sideTab.map((tab,idx)=>(
            <li key={idx}>
            <Link to ={tab.link} className="nav_con_link">{tab.name}</Link>
            </li>
            ))}

        </ul>
    );
}export  default User_Side_Tab;




