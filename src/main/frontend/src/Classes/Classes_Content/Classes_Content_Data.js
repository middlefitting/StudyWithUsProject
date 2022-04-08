import React from 'react';

function Classes_Content_Data(){

    const boxes = [
        {
            topic:'데이터 베이스',
            courseName:'All about 데이터베이스 기초편',
            duration:'1달과정',
            description:'데이터베이스'},
        {
            topic:'데이터 베이스',
            courseName:'All about 데이터베이스 기초편',
            duration:'1달과정',
            description:'데이터베이스'}
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

export default Classes_Content_Data;