import axios from "axios";

// const baseURL = '/api'
const baseURL = ''


class CommunityService {


     // function(page) {
     //     const URLSearch = new URLSearchParams(location.search);
     //     URLSearch.set('page', String(page));
     //     const newParam = URLSearch.toString();
     // }

    saveMember(data) {
        return axios.post(baseURL + "/join/members", data)
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