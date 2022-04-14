import React, {useEffect, useState} from 'react';
import AxiosURL from "../../Services/AxiosURL";
import {Link} from "react-router-dom";
import $ from "jquery";

const MainPage = () => {

    //// 임시로 해놓음... 수정필요
    //paging 할것인지 말것인지...

    const [loading, setLoading] = useState(false);
    const [study, setStudy] = useState({});
    const [user, setUser] = useState('');

    $('.boxes').css('opacity','0');

    useEffect(() => {
        if (localStorage.getItem('user-info')) {

            setLoading(true);
            setUser(localStorage.getItem('user-info'))
            const token = JSON.parse(localStorage.getItem('user-info'))

            AxiosURL.studyList(token.authorization)
                .then(response => {
                    setStudy(response.data.data.content)
                }).catch(error => {
                console.log(error)
            })
            setLoading(false);
        }
        setTimeout(() => {
            $('.boxes').css('opacity','1');
        }, 300);
    }, [])



    const boxes = [
        {
            topic:'박상욱',
            courseName:'프로그래밍 기초 Python 기초편',
            duration:'2022-04-13T17:24:10.81523',
            description:'웹/앱개발을 위한 첫걸음'},
        {
            topic:'정승철',
            courseName:'프로그래밍 기초 C언어편',
            duration:'2022-04-13T17:24:10.81523',
            description:'C언어의 환경설정, 함수, 배열 개념 완벽 정복!'},
        {
            topic:'강채윤',
            courseName:'Google 공식 언어 Kotlin',
            duration:'2022-04-13T17:24:10.81523',
            description:'Google 공식 언어 Kotlin 프로그래밍 완벽 정복'},
        {
            topic:'손채영',
            courseName:'All about 데이터베이스 기초편',
            duration:'2022-04-13T17:24:10.81523',
            description:'데이터베이스'},
        {
            topic:'김태윤',
            courseName:'React 완벽 가이드',
            duration:' 2022-04-13T17:24:10.81523',
            description:'JavaScript부터 웹 어플리케이션 배포까지!! React와 프론트엔드 최신 기술을 가장 쉽고 확실하게 배우는 법'},
        {
            topic:'박상욱/정승철',
            courseName:'프로그래밍 기초 JavaScript',
            duration:' 2022-04-13T17:24:10.81523',
            description:'웹 개발을 하고 싶다면 무조건 필수로 들어야 하는 수업! ' +
                'JavaScript 언어에 대한 개요, 기초 문법, 제공라이브러리까지 JavaScript에 대한 전반적인 내용 학습 가능!'},

        {
            topic:'강채윤/손채영',
            courseName:'너무 쉬운 HTML/CSS 입문',
            duration:'2022-04-13T17:24:10.81523',
            description:'웹 개발의 필수 지식인 HTML/CSS 아주 빠르고 쉽게 익혀보자!'},
        {
            topic:'박상욱/김태윤',
            courseName:'안드로이드앱 만들기 기초',
            duration:'2022-04-13T17:24:10.81523',
            description:'안드로이드 앱을 만들어 보자!'}
    ]


    return (
        <>
            {loading &&
                <></>
            }
            <br/>
            <br/>
            <div className="box_cont_main">
                {study.length ?
                    study.map((study, key) => (
                        <div className="boxes" key={key}>
                            <div className="boxes_content">
                                <span>{study.nickName}</span>
                                <div className="boxes_courseName">{study.studyName}</div>
                                <div className="classes_date">
                                    {study.regDate}
                                </div>
                                <p>{study.studyExplanation}
                                </p>

                                <hr/>
                                <button type="button" className="add_classes">
                                    함께하기
                                </button>
                            </div>
                        </div>
                    ))
                    :
                    <div className="box_cont_main" >
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
                                    <Link to = '/signup'>
                                        <button type="button" className="add_classes">
                                            회원가입 후 함께하세요
                                        </button>
                                    </Link>
                                </div>
                            </div>
                        ))}

                    </div>
                }
            </div>
        </>
    );
};

export default MainPage;