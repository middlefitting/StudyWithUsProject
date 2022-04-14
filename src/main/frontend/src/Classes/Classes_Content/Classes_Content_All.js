import React from 'react';
import './Classes_Content.css';

function Classes_Content_All(){

    //// 임시로 해놓음... 수정필요
    //paging 할것인지 말것인지...
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
            description:'Google 공식 언어 Kotlin 프로그래밍 완벽 정복'},
        {
            topic:'데이터 베이스',
            courseName:'All about 데이터베이스 기초편',
            duration:'1달과정',
            description:'데이터베이스'},
        {
            topic:'데이터 베이스',
            courseName:'All about 데이터베이스 기초편',
            duration:'1달과정',
            description:'데이터베이스'},
        {
            topic:'React',
            courseName:'React 완벽 가이드',
            duration:' 2달과정',
            description:'JavaScript부터 웹 어플리케이션 배포까지!! React와 프론트엔드 최신 기술을 가장 쉽고 확실하게 배우는 법'},
        {
            topic:'JavaScript',
            courseName:'프로그래밍 기초 JavaScript',
            duration:' 1.5달과정',
            description:'웹 개발을 하고 싶다면 무조건 필수로 들어야 하는 수업! ' +
                'JavaScript 언어에 대한 개요, 기초 문법, 제공라이브러리까지 JavaScript에 대한 전반적인 내용 학습 가능!'},
        {
            topic:'JavaScript',
            courseName:'JavaScript 완전정복',
            duration:' 2달과정',
            description:'20개의 프로젝트로 JavaScript 100개 기능 완벽 구현'},
        {
            topic:'JavaScript',
            courseName:'JQuery',
            duration:'1달과정',
            description:'jQuery에 대한 기초부터 Ajax 통신까지 jQuery가 제공하는 다양한 개념과 기법을 학습!'
                +'jQuery 기반으로 만들어진 수십가지의 프레임워크를 사용'},
        {
            topic:'HTML/CSS',
            courseName:'너무 쉬운 HTML/CSS 입문',
            duration:'3일 과정',
            description:'웹 개발의 필수 지식인 HTML/CSS 아주 빠르고 쉽게 익혀보자!'},
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
                <div className="boxes_k" key={key}>
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

export default Classes_Content_All;