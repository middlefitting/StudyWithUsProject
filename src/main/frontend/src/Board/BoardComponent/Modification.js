import React, {useEffect, useRef, useState} from "react";
import "../../App.css";
import {useHistory} from "react-router-dom";
import AxiosURL from "../../Services/AxiosURL";


function Modification() {

    // 토큰 없으면 메인 화면으로
    useEffect(() => {
        if (!localStorage.getItem('user-info')) {
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
            email: user.email,
            nickname: nickname,
            bornDate: user.bornDate
        };

        AxiosURL.ModificationNick(updateUserForm, token.authorization)
            .then(res => {

                localStorage.setItem('user-data', JSON.stringify(res.data.data))

                window.location.reload()
            }).catch(error => {
            alert(error.response.data.message);
        })
    }

    // 비밀번호 수정
    const _pwdHandler = (e) => {
        e.preventDefault()
        const password = document.getElementsByName('password')[0].value;
        const newPassword = document.getElementsByName('newPassword')[0].value;

        const pwdForm = {
            email: user.email,
            password: password,
            newPassword: newPassword
        }

        AxiosURL.updatePwd(pwdForm, token.authorization)
            .then(res => {
                window.location.reload()
            }).catch(error => {
            alert(error.response.data.message)
        });
    }

    // 회원탈퇴
    const _delHandler = (e) => {
        e.preventDefault()
        const delPassword = document.getElementsByName('delPassword')[0].value;
        const deleteForm = {
            email: user.email,
            password: delPassword
        }

        AxiosURL.deleteUser(deleteForm, token.authorization)
            .then((res) => {
                localStorage.clear();
                history.push("/");
                window.location.reload();
            }).catch(error => {
            alert(error.response.data.message)
        })
    }

    return (
        <div align='center'>
            <br/>
            <h1>닉네임 변경</h1>
            <input readOnly={true} defaultValue={user.email} className="ModiInput"/>
            <input placeholder='새로운 닉네임을 입력해주세요'
                   name="nickname"
                   className="ModiNickInput"/>
            <input readOnly={true} defaultValue={user.bornDate} className="ModiInput"/>
            <button onClick={(e) => _handleChange(e)} className="ModiButton">닉네임 변경</button>
            <br/>
            <br/>
            <h1>비밀번호 변경</h1>
            <input readOnly={true} defaultValue={user.email} className="ModiInput"/>
            <input placeholder='현재 비밀번호를 입력해주세요'
                   name="password"
                   type="password"
                   className="ModiNickInput"/>
            <input placeholder='새 비밀번호를 입력해주세요'
                   name='newPassword'
                   type="password"
                   className="ModiNickInput"/>
            <button className="ModiButton"
                    onClick={(e) => _pwdHandler(e)}
            >비밀번호 변경
            </button>

            <br/>
            <br/>
            <h1>회원 탈퇴</h1>
            <input placeholder='비밀번호를 입력해주세요'
                   type='password'
                   name="delPassword"
                   className='ModiNickInput'/>
            <button className="ModiDelButton"
                    onClick={(e) => _delHandler(e)}
            >회원 탈퇴
            </button>
        </div>
    );
};

export default Modification;
