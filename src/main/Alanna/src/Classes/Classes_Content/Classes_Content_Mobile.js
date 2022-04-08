import React from 'react';

function Classes_Content_Mobile(){

    const boxes = [
        {
            topic:'안드로이드 ',
            courseName:'안드로이드앱 만들기 기초',
            duration:'1달과정',
            description:'안드로이드 앱을 만들어 보자!'},
        {
            topic:'안드로이드 ',
            courseName:'안드로이드앱 만들기 기초',
            duration:'1달과정',
            description:'안드로이드 앱을 만들어 보자!'}
    ]
    return (
        <div className="box_cont">
            {boxes.map((box, key)=>(
                <div className="boxes" key={key}>
                    <div className="boxes_content">
                        <span>{box.topic}</span>
                        <div className="boxes_courseName">{box.courseName}</div>
                        <div className="classes_date">
                            {box.duration}
                        </div>
                        <p>{box.description}
                        </p>

                        <hr />
                        <button type="button" className="add_classes">
                            수강하기
                        </button>
                    </div>
                </div>
            ))}

        </div>
    );
};


export default Classes_Content_Mobile;