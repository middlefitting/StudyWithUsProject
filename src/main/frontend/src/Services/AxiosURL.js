import axios from "axios";

// const baseURL = '/api'
const baseURL = ''

// const user = localStorage.getItem('user')
// const before_user = JSON.parse(user)
// const id = before_user.id

class CommunityService {

    saveMember(data) {
        return axios.post(baseURL + "/join/members", data)
    }

    loginMember(data) {
        return axios.post(baseURL + "/login", data)
    }

    getMember(data) {

        if (localStorage.getItem('user')) {
            const user = localStorage.getItem('user')
            const before_user = JSON.parse(user)
            const id = before_user.id

            return axios.get(baseURL + `/members/${id}`, {headers: data})
        }

    }
    // 닉네임 변경
    ModificationNick(data, token) {

        if (localStorage.getItem('user')) {
            const user = localStorage.getItem('user')
            const before_user = JSON.parse(user)
            const id = before_user.id

            return axios.put(baseURL + `/members/${id}`, data, {headers: {authorization: token}})
        }


    }

    // 비밀번호 변경
    updatePwd(data, token) {

        if (localStorage.getItem('user')) {
            const user = localStorage.getItem('user')
            const before_user = JSON.parse(user)
            const id = before_user.id

            return axios.patch(baseURL + `/members/${id}`, data, {headers: {authorization: token}})
        }

    }

    // 회원삭제
    deleteUser(data, token){

        if (localStorage.getItem('user')) {
            const user = localStorage.getItem('user')
            const before_user = JSON.parse(user)
            const id = before_user.id

            console.log(token)
            console.log(data)
            return axios.delete(baseURL + `/members/${id}`, {headers: {authorization: token}, data:data})

        }
    }

    savePost(data) {
        return axios.post(baseURL + "/board/register", data)
    }

    getNoticeList() {
        return axios.get(baseURL + "/board")
    }
    // getFreeList(data) {
    //     return axios.post(baseURL + "/board/free", data)
    // }
    // getQuestionList(data) {
    //     return axios.post(baseURL + "/board/question", data)
    // }

    /*loginMember(data) {
        return axios.post(baseURL + "/login", data)
    }

    userSession(config) {
        return axios.get(baseURL + "/user", config)
    }*/

}

export default new CommunityService();