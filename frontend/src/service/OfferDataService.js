import axios from 'axios'


const OFFER_API_URL = 'http://localhost:8080'
const RECYCLEAN_API_URL = `${OFFER_API_URL}`

class OfferDataService {

    retrieveAllOffers(name) {
        return axios.get(`${RECYCLEAN_API_URL}/instructors/gdfgfdg/courses`);
    }

}

export default new OfferDataService()
