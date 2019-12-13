import axios from 'axios'
const RECYCLEAN_API_URL = 'http://localhost:8080/recyclean'
const USER_API_URL = `${RECYCLEAN_API_URL}/user`
const ALL_SERVICE_URL = USER_API_URL

class UserDataService{
    //This function retrieve all User from our API
    retrieveAllUsers(){
        return axios.get(`${ALL_SERVICE_URL}`)
    }

    //Delete a User
    deleteUser(userId, userEmail) {
        return axios.delete(`${ALL_SERVICE_URL}/delete/${userId}/${userEmail}`);
    }
}

export default new UserDataService()
