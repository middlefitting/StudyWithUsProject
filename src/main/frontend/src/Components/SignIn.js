import React, {useEffect} from 'react';
import {useForm} from "react-hook-form";
import {useHistory} from "react-router-dom";
import AxiosURL from "../Services/AxiosURL";

const SignIn = () => {

    useEffect(() => {
        if(localStorage.getItem('user-info'))
        {
            history.push("/")
        }
    }, []);

    const { watch, register, formState: {errors}, handleSubmit } = useForm({mode:"onChange"});


    // 페이지 이동 submit
    const history = useHistory();

    // axios DB 연동
    const onSubmit = (data) => {
        console.log('data',data);

    }


    return (
        <div>
            <br/><br/>
            <form onSubmit={handleSubmit(onSubmit)} >

                <h3>로 그 인</h3>
                &nbsp;
                <label>Email</label>
                <input
                       className="signInput"
                       name="email"
                       type="email"
                       {...register("email",
                           {required:true, pattern: /^\S+@\S+$/i})}
                />
                {/*{errors.email && <p>ex) studywithus@gmail.com</p>}*/}


                <label>Password</label>
                <input
                       className="signInput"
                       name="password"
                       type="password"
                       {...register("password",
                           {required: true, minLength: 8})}/>
                {/*{errors.password && errors.password.type === "required" && <p>비밀번호를 입력해주세요.</p>}
                {errors.password && errors.password.type === "minLength" && <p>비밀번호는 8글자 이상으로 가능합니다.</p>}*/}


                <input type="submit" onClick={()=> {history.push("/")}} className="signInput"></input>
            </form>

        </div>
    );
};

export default SignIn;
