import axios from "axios";

const baseURL = 'http://localhost:8081'

class CommunityService {

    saveMember(data) {
        return axios.post(baseURL + "/member", data)
    }

    /*loginMember(data) {
        return axios.post(baseURL + "/login", data)
    }

    userSession(config) {
        return axios.get(baseURL + "/user", config)
    }*/

}

export default new CommunityService();