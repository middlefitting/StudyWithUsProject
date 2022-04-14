import React, {useState, useEffect} from 'react';
import {Link, useParams} from "react-router-dom";
import Side_Tab from "../../Tabs/Side_Tab";
import Board from '../BoardComponent/Board';
import User_Side_Tab from "../../Tabs/User_Side_Tab";
import Search_Component from "./Components/Search_Component";

import "../../App.css";

function BoardList() {

    const {category} = useParams();
    const [title, setTitle] = useState('');

    useEffect(() => {
        if (category === 'notice') setTitle('공지사항');
        else if (category === 'free') setTitle('자유게시판');
        else if (category === 'question') setTitle('질문게시판');
    }, [category]);

    return (
        <div className="container">
            <div className="cont_container">
                <div className="Side_Tab">
                    {localStorage.getItem('user-info') ?
                        <>
                            <User_Side_Tab/>
                        </>
                        :
                        <>
                            <Side_Tab/>
                        </>
                    }
                </div>
                <div className="mid_container">
                    <div className="page_name">
                        <span>{title}</span>
                        {localStorage.getItem('user-info') ?
                            <>
                                <button type="submit" id="w_button" value="글씨기">
                                    <Link to='/Board_Write' className="link">글쓰기</Link>
                                </button>
                            </>
                            :
                            ''
                        }
                    </div>
                    <div className="table_mid_container">
                        <Board category={category}/>
                        <Search_Component category={'notice'}/>
                    </div>
                </div>

            </div>


        </div>

    );
}

export default BoardList;