import axios from 'axios'

const PRODUCT_API = 'http://localhost:8080/recyclean/product';

class ProductDataService {
    //This function retrieve all User from our API
    getAllProducts() {
        return axios.get(`${PRODUCT_API}`)
    }

    getQrCode(Prod_Id) {
        //        return axios.get('http://localhost:8080/recyclean/product/qrcode/101')
        return `${PRODUCT_API}/qrcode/${Prod_Id}`;
    }

    //Return product if only status available
    getProductByQR(Prod_Id){
        return axios.get(`${PRODUCT_API}/${Prod_Id}`);
    }
}

export default new ProductDataService()
