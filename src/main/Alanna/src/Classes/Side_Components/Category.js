import React, {useState} from 'react';
import'./Category.css';
import {Link} from "react-router-dom";
import CategoryTab from "./CategoryTab";
import Category_Contents from "./Category_Contents";

function Category()  {


    const [currentClick, setCurrentClick] = React.useState(null);
    const [prevClick, setPrevClick] = React.useState(null);


    const GetClick=(e)=>{
        setCurrentClick(e.target.id);
    };

    React.useEffect((e)=>{
        if(currentClick !==null){
            let current = document.getElementById(currentClick);

            current.style.color ="white";
            current.style.backgroundColor="rgb(162, 166, 239)";
            current.style.boxShadow="1px 4px 3px rgb(192, 196, 239)";
        }
        if(prevClick !==null){
            let prev = document.getElementById(prevClick);
            prev.style.color ="black";
            prev.style.backgroundColor="rgba(168, 164, 164, 0.46)";
            prev.style.boxShadow="1px 4px 3px rgba(155, 154, 154, 0.55)";
        }
        setPrevClick(currentClick);
    },[currentClick]
        );






    const topics =[
        {type:'전체보기',link:'/Classes_All'},
        {type:'프로그래밍 언어', link:'/Classes_Back'},
        {type:'웹 프론트엔드', link:'/Classes_Front'},
        {type:'데이터베이스 설계', link:'/Classes_Data'},
        {type:'모바일 개발',link:'/Classes_Mobile'}
        ];
        return (
        <div className="category">
            <div className="category_container">

                {topics.map((topic, key)=>(
                    <Link to={topic.link} className="link" key={topic.id}>
                    <CategoryTab id={key} onClick={GetClick}>
                            {topic.type}
                    </CategoryTab>
                    </Link>

                ))}

            </div>


        </div>
    );
};

export default Category;