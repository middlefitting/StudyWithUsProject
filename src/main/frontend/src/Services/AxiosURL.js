import axios from "axios";

// const baseURL = '/api'
const baseURL = ''


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

    getEdit() {
        return axios.get(baseURL + "/board/edit")
    }
    postEdit(data) {
        return axios.post(baseURL + "/board/edit", data)
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