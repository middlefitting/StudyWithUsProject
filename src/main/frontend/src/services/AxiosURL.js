import axios from "axios";

const baseURL = 'http://localhost:8081'

class CommunityService {

    saveMember(data) {
        return axios.post(baseURL + "/member", data)
    }
}

export default new CommunityService();