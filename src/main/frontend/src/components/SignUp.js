import * as React from 'react';
import {useForm} from "react-hook-form";
import '../styles/css/SignUp.css'
import {useRef} from "react";
import AxiosURL from "../services/AxiosURL";
import {Link, useHistory} from "react-router-dom";


// react Hook From 사용
// 로딩속도 개선 + 유효성 검사하기 쉬움
// yarn add react-hook-form
// reacthookform 예제에서 확인가능
const SignUp = () => {

    /*const {register, handleSubmit, watch, formState: {errors} } = useForm({mode: "onChange"});
    const onSubmit = (data) => {
        console.log(data);
    } // 성공적으로 Submit 됬는지 Check
    console.log(watch("emailexample")); //*/

    const { watch, register, formState: {errors}, setError, handleSubmit } = useForm({mode:"onChange"});

    const checkPassword = useRef(); // 비밀번호 확인을 위해 useRef hook을 사용해 password 함수를 만들었음
    checkPassword.current = watch("password"); // 우리가 입력한 password_confirm이 들어온다.


    // 회원가입 axios DB 연동
    const onSubmit = (data) => {
        console.log('data',data);

        AxiosURL.saveMember(data).then((response) => {
            console.log(response.data)
        }).catch(error => {
            console.log(error)
        })
    }

    // 회원가입 submit
    const history = useHistory();

    //console.log(watch("email"));
    //console.log(watch("password"));
    //console.log(watch("password_confirm")); // 정확값이 적히고 있는지 눈으로 볼려고 넣어둔 것



    return (
        <div>
            <br/><br/>
            <form onSubmit={handleSubmit(onSubmit)}>

               <h3>회 원 가 입</h3>
                &nbsp;
              <label>Email</label>
                <input name="email"
                       type="email"
                       {...register("email",
                           {required:true, pattern: /^\S+@\S+$/i})}
                />
                {errors.email && <p>ex) studywithus@gmail.com</p>}

                <label>Nickname</label>
                <input name="nickname" {...register("nickname",
                    {required: true, maxLength: 10})}/>
                {errors.nickname && errors.nickname.type === "required" && <p>닉네임을 입력해주세요.</p>}
                {errors.nickname && errors.nickname.type === "maxLength" && <p>닉네임은 10자 이내로만 가능합니다.</p>}

                <label>BornDate</label>
                <input name="bornDate" {...register("bornDate",
                    {required: true})}/>
                {errors.birth && <p>ex) 2022.04.15</p>}

                <label>Password</label>
                <input name="password"
                       type="password"
                       {...register("password",
                           {required: true, minLength: 8})}/>
                {errors.password && errors.password.type === "required" && <p>비밀번호를 입력해주세요.</p>}
                {errors.password && errors.password.type === "minLength" && <p>비밀번호는 8글자 이상으로 가능합니다.</p>}

                <label>Password Confirm</label>
                <input name="password_confirm"
                       type="password"
                       {...register("password_confirm",
                           {required: true, validate: value => (value === checkPassword.current)  })}/>
                {errors.password_confirm && errors.password_confirm.type === "required" && <p>비밀번호 한번 더 입력해주세요.</p>}
                {errors.password_confirm && errors.password_confirm.type === "validate" &&<p>비밀번호가 맞지 않습니다.</p>}

                <input type="submit" onClick={()=> {history.push("/signin")}}></input>
            </form>

        </div>
    );
};

export default SignUp;