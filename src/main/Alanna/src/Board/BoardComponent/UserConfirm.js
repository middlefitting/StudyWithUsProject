import {Link, Route, useHistory} from "react-router-dom";
import React, {useEffect, useRef, useState} from "react";
import '../../styles/css/SignUp.css'
import {useForm} from "react-hook-form";
import AxiosURL from "../../Services/AxiosURL";

function  UserConfirm(){

    // 페이지 이동 submit
    const history = useHistory();

    useEffect(() => {
        if(!localStorage.getItem('user-info'))
        {
            history.push("/")
        }
    }, []);

    const {register, formState: {errors}, handleSubmit} = useForm();

    // axios DB 연동
    const onSubmit = (data) => {
        console.log('data',data);

        history.push("/UserUpdate")
    }

    return(
        <>
            <form onSubmit={handleSubmit(onSubmit)}>
                <label className="UserConfirm">비밀번호 확인</label>
                <input className="UserConfirmPassword"
                       name="password"
                       type="password"
                       {...register("password", {required: true})}
                />
                {errors.password && errors.password.type === "required" && <p className="passwordConfirmP">비밀번호를 정확히 입력해주세요.</p>}

                <input type="submit" className="UserConfirmInput"/>
            </form>
        </>
    );
}
export default UserConfirm;