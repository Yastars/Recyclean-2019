import React, { Component } from 'react'
import QrReader from 'react-qr-reader'
import axios from 'axios'
import Header from '../Header';


//elte_softtech@elte.ik


class ScanQR extends Component {
    constructor(props) {
        super(props);
        this.state = {
            last_scanned: 'No Result',
            products_scanned: [],
            message: "",
            userCredits: 0,
            products_names: []
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.refreshCredits = this.refreshCredits.bind(this);
        this.handleScan = this.handleScan.bind(this);
    }


    componentWillMount() {
        this.refreshCredits();
    }

    refreshCredits() {
        axios.get(`http://localhost:8080/recyclean/credits/check/${sessionStorage.getItem("userId")}`).then(
            response => {
                this.setState(state => {
                    return {
                        userCredits: response.data,
                        products_scanned: [],
                        result: 'No Result',
                        message: 'No Result'
                    }
                })

            })
    }

    handleScan = data => {
        if (data !== null) {
            console.log('code scanned = ' + data);
            if (Number.isInteger(parseInt(data, 10))) {
                if (this.state.products_scanned.includes(parseInt(data))) {
                    //alert("This code has been already scanned, please try another code");
                    
                }
                else {
                    let tmp_names = []
                    tmp_names = tmp_names.concat(this.state.products_names)
                    axios.get(`http://localhost:8080/recyclean/product/${data}`).then( 
                         response2 => {
                             tmp_names.push(response2.data.prod_Name)
                             this.setState( {
                                 products_names: tmp_names}
                             )
                             console.log(response2.data.prod_Name)
                         }
                    )
                    this.setState(state => {
                        //const products_scanned = state.products_scanned.concat(data);
                        //const products = state.products_scanned.push(parseInt(data));
                        let tmp = [];
                        console.log('1 = ' + tmp);
                        tmp = tmp.concat(this.state.products_scanned)
                        console.log('2 = ' + tmp);
                        tmp.push(parseInt(data))
                        console.log('3 = ' + tmp);
                        return {
                            products_scanned: tmp,
                            result: 'No Result',
                            message: 'No Result',
                        };
                    });
                    //alert("Yay 400 Credits")
                    console.log('code scanned = ' + data);
                }
            }
        }
    }

    handleError = err => {
        console.error(err)
    }

    async handleSubmit(event) {
        var API_URL = 'http://localhost:8080/recyclean/credits/update';
        var userId = parseInt(sessionStorage.getItem("userId"));
        var userEmail = sessionStorage.getItem("userEmail");

        let userCredits = {
            productIds: this.state.products_scanned,
            user_Email: userEmail,
            user_Id: userId
        };
        console.log(userCredits);

        await axios.post(API_URL, userCredits).then( response => {console.log(response); alert(response.data)},
        await axios.get(`http://localhost:8080/recyclean/credits/check/${sessionStorage.getItem("userId")}`).then(
            response => {
                this.setState(state => {
                    return {
                        userCredits: response.data,
                        products_scanned: [],
                        result: 'No Result',
                        message: 'No Result',
                        products_names: []
                    }
                })
                this.forceUpdate()
            }
        ))
        this.refreshCredits();
        this.forceUpdate()
    }

    addToList = () => {
        this.setState(state => {
            const products_scanned = state.products_scanned.concat(state.last_scanned);
            return {
                products_scanned,
                result: 'No Result',
                message: 'No Result',
            };
        });
    }

    render() {
        return (
            <div>
                <Header />
                <div>
                    <div>
                        {/*==================================================================
			Preloader
		==================================================================*/}
                        <div id="preloader">
                            <div className="loader">
                                <img src="img/loader.gif" alt="" />
                            </div>
                        </div>
                        {/*==================================================================
			Main Wrapper
		==================================================================*/}
                        <div id="main-wrapper">
                            {/*==================================================================
				Intro Section
			==================================================================*/}
                            <section id="intro" className="section intro-section">
                                <div className="container">
                                    <div className="row intro-cols">
                                        <div className="col-md-6 col-md-pull-6">
                                            <div className="v-align">
                                                <div className="inner">
                                                    <div className="intro-text">

                                                        <h3>Scan your code now and earn Credits!</h3>
                                                        <p>
                                                            This is the coolest app you've ever seen, the amazing and great app made with love just for you
                        </p>

                                                        <ul>

                                                            <div className="alert alert-primary Credits">{this.state.userCredits}</div>
                                                            {this.state.products_names.map(item => (
                                                                <div class="alert alert-success products-scanned"><li key={item}>{ item}</li></div>
                                                            ))}

                                                        </ul>
                                                        <br></br>
                                                        <br></br>
                                                        <br></br>
                                                        <br></br>
                                                    </div>









                                                </div>
                                            </div>
                                        </div>
                                        <div className="col-md-6 col-md-push-6">
                                            <div className="">
                                                <div className="">

                                                    <div className="container ScanReader">
                                                        <QrReader
                                                            delay={50}
                                                            onError={this.handleError}
                                                            onScan={this.handleScan}
                                                            style={{
                                                                width: '78%'

                                                            }}
                                                        />
                                                    </div>


                                                </div>

                                            </div>
                                            <div className="intro-download-btns">
                                                <button type="submit" className="btn app-btn" onClick={this.addToList}>Scan This Code</button>
                                                <button type="submit" className="btn app-btn" onClick={this.handleSubmit}>Send all </button>
                                            </div>
                                            <br></br>
                                            <br></br>
                                            <br></br>
                                            <br></br>
                                        </div>



                                    </div>
                                </div>
                            </section>
                        </div></div></div>







            </div>
        )
    }
}
export default ScanQR