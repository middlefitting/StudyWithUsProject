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

    saveComment(data) {
        return axios.post(baseURL + "/comment/register", data)
    }

    //page 숫자는 추후 수정
    getFreeList(){
        return axios.get(baseURL+"/board",{ params: { 'category' :'free', 'page':1 } });

    }

    getNoticeList(){
        return axios.get(baseURL+"/board",{ params: { 'category' :'notice', 'page':1 } });

    }

    getQNAList(){
        return axios.get(baseURL+"/board",{ params: { 'category' :'question', 'page':1 } });

    }

    getEdit() {
        return axios.get(baseURL + "/board/edit")
    }

    postEdit(data) {
        return axios.post(baseURL + "/board/edit", data)
    }


    /*    getNoticeList() {
            return axios.get(baseURL + "/board")
        }*/


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