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
}

export default new CommunityService();