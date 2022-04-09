import axios from "axios";

const baseURL = 'http://localhost:8081'

class CommunityService {

    saveMember(data) {
        return axios.post(baseURL + "/join", data)
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