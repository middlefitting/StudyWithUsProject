import React from 'react';

const UserUpdate = () => {
    return (
        <div>
            <br/><br/>
            <form>

                <h3>회원 정보 수정</h3>
                &nbsp;
                <label>Email</label>
                <input
                    className="signInput"
                    name="email"
                    type="email"
                    placeholder="이메일 주소를 입력해주세요."
                    readOnly={true}
                />

                <label>Nickname</label>
                <input
                    className="signInput"
                    name="nickname"
                    placeholder="10자리 이내로만 가능합니다."
                    readOnly={true}
                />
                <label>BornDate</label>
                <input
                    className="signInput"
                    name="bornDate"
                    type="text"
                    placeholder="ex) 2022-04-15"
                    readOnly={true}
                />

                <label>Password</label>
                <input
                    className="signInput"
                    name="password"
                    type="password"
                    readOnly={true}
                />

                <label>Password Confirm</label>
                <input
                    className="signInput"
                    name="password_confirm"
                    type="password"
                    readOnly={true}
                />

                <input
                    className="signInput"
                    type="submit"
                ></input>
            </form>
        </div>
    );
};

export default UserUpdate;
