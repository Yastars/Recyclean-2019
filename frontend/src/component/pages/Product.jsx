import React,{Component} from 'react';
import ProductDataService from '../../service/ProductDataService';
import '../../ManageUsers.css';
import Header from '../Header';


class Product extends Component {

    constructor(props) {
        super(props)
        this.state = {
            //Where we store data for every state
            products: [],
            message: null
        }
        this.refreshProducts = this.refreshProducts.bind(this)
    }

    componentDidMount() {
        this.refreshProducts();
    }

    refreshProducts() {
        ProductDataService.getAllProducts()//HARDCODED
            .then(
                response => {
                    console.log(response);
                    this.setState({ products: response.data })
                }
            )
    }


    
    render(){
    return (

        <div>{/*removed container*/}
            <Header/>
            <div className="container">
            <h1>All Products</h1>
            <a href="/ScanQR"> <button type="submit" class="btn btn-primary mb-2">Scan New Waste</button></a>
            <table className="table ">
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Code QR</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                // This map allow us to loop around a list of objects
                                this.state.products.map(
                                    product =>
                                        //Key to identify each row
                                        // {} in order to execute JS code
                                        <tr key={product.prod_Id}>
                                            <td>{product.prod_Id}</td>
                                            <td>{product.prod_Name}</td>
                                            <td>{product.prod_BarCode}</td>
                                            <img alt="" src={ProductDataService.getQrCode(product.prod_Id)} width="100" height="100"></img>
                                        </tr>  
                                )
                            }
                        </tbody>
                    </table>
                    </div>
        </div>
    )
}
}

export default Product