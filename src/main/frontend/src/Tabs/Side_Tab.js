import './Side_Tab.css'
import '../App.css'
import {Link} from "react-router-dom";

function Side_Tab(){

    const sideTab = [
        {name:'공지사항',link:'/BoardList/notice'},
        {name:'자유게시판',link:'/BoardList/free'},
        {name:'질문게시판',link:'/BoardList/question'},
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
}export  default Side_Tab;




