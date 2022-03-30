import React from 'react';
import '../App.css';
import './Classes.css';
import Category from "./Side_Components/Category";

function Classes () {

    const items = [1, 2, 3, 4, 5, 6];
    return (
        <div className="class_container">
        <Category />
            <div className="class_content_wrap">
                <div className="detail_wrap">
                    <h3>전체보기</h3>
                    <div className="class_desc">
                        <span>여기는 설명설명</span>
                    </div>
                    <p>- 여기는 카테고리에 대한 설명 설명 설명 설명 </p>
                    <p>- 관련 커리어: 나열, 나열, 나열</p>
                </div>
                <div className="class_wrap">
                    {items.map((item, key)=>(
                        <div className="boxes" key={key}>
                            <div className="boxes_content">
                                <span>Testing</span>
                                <h3>여기는 수강 과목 교육명 입니다</h3>
                                <div className="classes_date">
                                    개강일 (몇주/몇달 코스)
                                </div>
                                <p>여기는 수강 과목에 대한 디테일한 설명들 입니다.
                                <br /><br /><br /><br /><br />
                                여기는 수강 과목에 대한 디테일한 설명들 입니다.
                                <br /><br /><br /><br /><br />
                                    내용이 꽉찼을때 예시
                                </p>
{/*                                <ul className="dot_wrapper">
                                    <li className="dot"> </li>
                                    <li className="dot"> </li>
                                    <li className="dot"> </li>
                                </ul>*/}

                                <hr />
                                <button type="button" className="add_classes">
                                    수강하기
                                </button>
                            </div>
                        </div>
                    ))}

                </div>


            </div>
        </div>

    );
};

export default Classes;