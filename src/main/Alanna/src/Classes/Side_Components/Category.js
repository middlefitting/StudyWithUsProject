import React, {useState} from 'react';
import'./Category.css';

function Category()  {

    /*const [style, setStyle] = useState("tab_button_before");
    const changeStyle=()=>{
        setStyle("tab_button_after")

    }*/

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

    const topics =['전체보기','프로그래밍 언어','웹 프론트엔드','데이터베이스 설계','모바일 개발'];
        return (
        <div className="category">
            <div className="category_container">

                {topics.map((topic, key)=>(
                    <button type="button" className="tab_button" id={key} onClick={GetClick}>

                            {topic}

                    </button>

                ))}

            </div>


        </div>
    );
};

export default Category;