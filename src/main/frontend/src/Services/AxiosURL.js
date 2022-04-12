import axios from "axios";

// const baseURL = '/api'
const baseURL = ''

// const ls_id = localStorage.getItem('user-nickname')
// const idus = JSON.parse(ls_id)
// const id = idus.id

class CommunityService {

    saveMember(data) {
        return axios.post(baseURL + "/join/members", data)
    }

    loginMember(data) {
        return axios.post(baseURL + "/login", data)
    }

    getMember(data) {
        console.log(id)
        return axios.get(baseURL + `/member/${id}`, {headers: data})
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

    saveComment(data) {
        return axios.post(baseURL + "/comment/register", data)
    }

    //page 숫자는 추후 수정
    getList(category, page) {
         const data = {
             category: category,
             page: page
         }

         return axios.get(baseURL + "/board", {params: data});
    }

    getSearchList(type, keyword) {
        const data = {
            type: type,
            keyword: keyword
        }
        return axios.get(baseURL+`/board/search/${keyword}`);
    }

    // getFreeList(){
    //     return axios.get(baseURL+"/board",{ params: { category :'free',page: 1 } });
    //
    // }
    //
    // getNoticeList(){
    //     return axios.get(baseURL+"/board",{ params: { category :'notice', page:1 } });
    //
    // }
    //
    // getQNAList(){
    //     return axios.get(baseURL+"/board",{ params: { category :'question', page:1 } });
    //
    // }

    getEdit() {
        return axios.get(baseURL + "/board/edit")
    }

    postEdit(data) {
        return axios.post(baseURL + "/board/edit", data)
    }


    getBoardDetail(post_id){
        return axios.get(baseURL+`/board/${post_id}`);
    }



    deleteComment(data) {
        return axios.post(baseURL + `/comment/delete/${data}`)
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