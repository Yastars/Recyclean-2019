import React, { Component } from 'react';
import axios from 'axios';
import {Redirect} from 'react-router-dom';
import Header from '../Header';

export default class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userEmail: "",
            userPass: "",
            userData: {},
            loginErrors: ""
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    //Update state props whenever we change the value of Inputs[Email, Pass] so we can submit anytime
    handleChange(event) {
        //console.log('handle change', event)
        this.setState({
            //{input name = input value}
            [event.target.name]: event.target.value
        })
    }

    


    handleSubmit(event) {

        // so that the form doesnt behave like an HTML form
        event.preventDefault();

        var API_URL = 'http://localhost:8080/recyclean/user/login';


        let user = this.state

        axios.post(API_URL, user)
            .then(
                
                response => {
                    console.log(response);
                    if(response.data){
                    this.setState(
                        {
                            userData: response.data,
                            loginErrors:'',
                            message: `You are now connected as ${user.userEmail} `
                        }
                    )
                    sessionStorage.setItem('userEmail',response.data.userEmail);
                    sessionStorage.setItem('userCredits',response.data.userCredits);
                    sessionStorage.setItem('userId',response.data.userId);
                    this.forceUpdate();
                }
                    else
                    this.setState(
                        {
                            message: '',
                            loginErrors: 'Wrong Email/Password ! Try again'
                        }
                    )
                }
            );

        
    }

    

    render() {
        if(sessionStorage.getItem('userEmail'))
            return <Redirect to='/ScanQr' />
        return (
            <div>
                <Header/>
                <div className="container">
                    {this.state.message && <div className="alert alert-success">{this.state.message}</div>}
                    {this.state.loginErrors && <div className="alert alert-danger">{this.state.loginErrors}</div>}
                    <div id="formContent">
                        <form onSubmit={(event) => this.handleSubmit(event)}>
                            <input
                                type="text"
                                id="email"
                                className="input"
                                name="userEmail"
                                placeholder="Email"
                                value={this.state.userEmail}
                                onChange={this.handleChange}
                                required
                            />


                            <input
                                type="password"
                                id="password"
                                className="input"
                                name="userPass"
                                placeholder="Password"
                                value={this.state.userPass}
                                onChange={this.handleChange}
                                required
                            />
                            <input type="submit" value="Login" />
                        </form>
                    </div>
                </div>
            </div>
        )
    }


}