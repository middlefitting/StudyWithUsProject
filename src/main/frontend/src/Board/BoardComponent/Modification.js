import React, {useEffect, useRef, useState} from "react";
import  "../../App.css";
import {useHistory} from "react-router-dom";
import AxiosURL from "../../Services/AxiosURL";


function Modification(){

    // 토큰 없으면 메인 화면으로
    useEffect(() => {
        if(!localStorage.getItem('user-info'))
        {
            history.push("/")
        }
    }, []);

    const history = useHistory();

    const user = JSON.parse(localStorage.getItem('user-data'));
    const token = JSON.parse(localStorage.getItem('user-info'));

    // 닉네임 수정 함수
    const _handleChange = (e) => {
        e.preventDefault();

        const nickname = document.getElementsByName('nickname')[0].value;

        const updateUserForm = {
            email : user.email,
            nickname : nickname,
            bornDate : user.bornDate
        }

        AxiosURL.ModificationNick( updateUserForm, token.authorization )
            .then(res => {
                console.log(res.headers)

                let user = JSON.stringify(res.data.data.nickname)

                localStorage.setItem('user-data', JSON.stringify(res.data.data))
                localStorage.setItem('user-nickname', user)
            })
    }

    // 회원탈퇴
    const _delHandler = (e) => {
        e.preventDefault()
        const delPassword = document.getElementsByName('delPassword')[0].value;
        console.log(token.authorization)
        console.log(delPassword)
        const deleteForm = {
            email : user.email,
            password : delPassword
        }

        AxiosURL.deleteUser(token.authorization, deleteForm)
            .then(res => {
                    console.log(res)
                    localStorage.clear();
                    history.push("/");
                    window.location.reload();
            })
    }

    return(
            <div align='center'>
                <br/>
                <h1>닉네임 변경</h1>
                <input readOnly={true} defaultValue={user.email} className="ModiInput"></input>
                <input placeholder='새로운 닉네임을 입력해주세요'
                       name="nickname"
                       className="ModiNickInput"></input>
                <input readOnly={true} defaultValue={user.bornDate} className="ModiInput"></input>
                <button onClick={(e) => _handleChange(e)} className="ModiButton">닉네임 변경</button>


                <br/>
                <br/>
                <h1>비밀번호 변경</h1>
                <input readOnly={true} defaultValue={user.email} className="ModiInput"></input>
                <input placeholder='현재 비밀번호를 입력해주세요'
                       name="password"
                       className="ModiNickInput"></input>
                <input placeholder='새 비밀번호를 입력해주세요'
                       name='newPassword'
                       className="ModiNickInput"></input>
                <button className="ModiButton">비밀번호 변경</button>

                <br/>
                <br/>
                <h1>회원 탈퇴</h1>
                <input placeholder='비밀번호를 입력해주세요'
                       type='password'
                       name="delPassword"
                       className='ModiNickInput'></input>
                <button className="ModiDelButton"
                        onClick={(e)=> _delHandler(e)}
                >회원 탈퇴</button>
            </div>

    );
};
export default Modification;
