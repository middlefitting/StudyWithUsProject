import React, {useRef} from 'react';
import {useForm} from "react-hook-form";
import AxiosURL from "../services/AxiosURL";
import {useHistory} from "react-router-dom";

const SignIn = () => {

    const { watch, register, formState: {errors}, handleSubmit } = useForm({mode:"onChange"});


    // axios DB 연동
    const onSubmit = (data) => {
        console.log('data',data);
    }

    // 페이지 이동 submit
    const history = useHistory();

    //console.log(watch("email"));
    //console.log(watch("password"));
    //console.log(watch("password_confirm")); // 정확값이 적히고 있는지 눈으로 볼려고 넣어둔 것


    return (
        <div>
            <br/><br/>
            <form onSubmit={handleSubmit(onSubmit)}>

                <h3>로 그 인</h3>
                &nbsp;
                <label>Email</label>
                <input name="email"
                       type="email"
                       {...register("email",
                           {required:true, pattern: /^\S+@\S+$/i})}
                />
                {/*{errors.email && <p>ex) studywithus@gmail.com</p>}*/}


                <label>Password</label>
                <input name="password"
                       type="password"
                       {...register("password",
                           {required: true, minLength: 8})}/>
                {/*{errors.password && errors.password.type === "required" && <p>비밀번호를 입력해주세요.</p>}
                {errors.password && errors.password.type === "minLength" && <p>비밀번호는 8글자 이상으로 가능합니다.</p>}*/}


                <input type="submit" onClick={()=> {history.push("/")}}></input>
            </form>

        </div>
    );
};

export default SignIn;
