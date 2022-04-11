import axios from "axios";

// const baseURL = '/api'
const baseURL = ''


class CommunityService {

    saveMember(data) {
        return axios.post(baseURL + "/join", data)
    }

    loginMember(data) {
        return axios.post(baseURL + "/login", data)
    }

    getMember(data) {
        return axios.get(baseURL + "/member", {headers: data})
    }

    ModificationNick(data, token) {
        return axios.put(baseURL + "/member", data, {headers: {authorization: token}})
    }

    deleteUser(token, data){
        console.log(token)
        console.log(data)
        return axios.delete(baseURL + "/member", {headers: {authorization: token}})
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