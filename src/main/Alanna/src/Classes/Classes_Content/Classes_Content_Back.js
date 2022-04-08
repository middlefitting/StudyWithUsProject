import React from 'react';
import './Classes_Content.css';

function Classes_Content_Back(){
    const boxes = [
        {
            topic:'Python',
            courseName:'프로그래밍 기초 Python 기초편',
            duration:'1달과정',
            description:'웹/앱개발을 위한 첫걸음'},
        {
            topic:'Python',
            courseName:'프로그래밍 Python 중급편',
            duration:'1달과정',
            description:'파이썬 활용해 서버 개발 및 게임 개발등 무엇이든 해보아요'},
        {
            topic:'Python',
            courseName:'파이썬 데이터 분석 실무',
            duration:'1달과정',
            description:'파이썬 실무 최강자로 업그레이드 하는 마지막 스탭!'},
        {
            topic:'C언어',
            courseName:'프로그래밍 기초 C언어편',
            duration:'1달과정',
            description:'C언어의 환경설정, 함수, 배열 개념 완벽 정복!'},
        {
            topic:'C언어',
            courseName:'프로그래밍 고급 C언어편',
            duration:'1.5달과정',
            description:'C언어의 포인터, 구조체 개념 완벽 정복하기'},
        {
            topic:'Kotlin',
            courseName:'Google 공식 언어 Kotlin',
            duration:'2달과정',
            description:'Google 공식 언어 Kotlin 프로그래밍 완벽 정복'}
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


export default Classes_Content_Back;