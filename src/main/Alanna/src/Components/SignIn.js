import React, {useEffect} from 'react';
import {useForm} from "react-hook-form";
import {useHistory} from "react-router-dom";
import AxiosURL from "../Services/AxiosURL";
import GoogleLogin from "react-google-login";
import FacebookLogin from 'react-facebook-login'
import {Image} from "react-bootstrap";

const SignIn = () => {

    useEffect((props:any) => {
        if(localStorage.getItem('user-info'))
        {
            history.push("/")
        }
    }, []);

    /*구글 로그인*/
    const responseGoogle = (response) => {
        console.log(response);
        const register = {id : response.Ju.sf}
        /*console.log("user-info", register);*/
        window.localStorage.setItem("user-info", JSON.stringify(register));
        /*history.push("/")
        window.location.reload()*/
    }

    const { watch, register, formState: {errors}, handleSubmit } = useForm({mode:"onChange"});


    // 페이지 이동 submit
    const history = useHistory();

    // axios DB 연동
    const onSubmit = (data) => {
        console.log('data',data);

        AxiosURL.loginMember(data)
            .then((response) => {
                console.log(response.data) // id, email, nickname
                let result = response.data
                localStorage.setItem("user-info", JSON.stringify(result))
                alert(JSON.stringify(result.id + "님 환영합니다."))
                history.push("/")
                window.location.reload()
            }).catch(error => {
                console.log(error)
                alert(JSON.stringify("정보를 다시 확인해주세요"))
        })

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
            <div className="google">
                <GoogleLogin clientId="407237709978-2gn46n6jfi3h391qt2d30bvuo562h802.apps.googleusercontent.com"
                             onSuccess={responseGoogle}
                             onFailure={responseGoogle}
                             cookiePolicy={'single_host_origin'}
                >
                </GoogleLogin>
            </div>
        </div>
    );
};

export default SignIn;
