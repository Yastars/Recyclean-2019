import React, { Component } from 'react';
import axios from 'axios';
import Header from '../Header';

export default class Registration extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            userPass: "",
            userEmail: "",
            userAddress: "",
            userPhone: "",
            passwordConfirmation:"",
            message:"",
            registrationErrors: ""
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        console.log('handle change', event)
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    handleSubmit(event) {
        var API_URL = 'http://localhost:8080/recyclean/user/register';
        let user = this.state
        axios.post(API_URL, user).then(
            response=>{this.setState({ message: `Welcome ${user.username}, Your account is created successfully ` })}
        );
              // so that the form doesnt behave like an HTML form
        event.preventDefault();
    }



    render() {
        return (
            <div>
                <Header/>
                <div className="container">
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                    <div id="formContent">
                        <form onSubmit={this.handleSubmit}>
                            <input
                                type="email"
                                id="email"
                                className="input"
                                name="userEmail"
                                placeholder="Email"
                                value={this.state.userEmail}
                                onChange={this.handleChange}
                                required
                            />

                            <input
                                type="text"
                                id="username"
                                className="input"
                                name="username"
                                placeholder="username"
                                value={this.state.username}
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


                            {/* <input
                                type="password"
                                id="passwordConfirmation"
                                className="input"
                                name="passwordConfirmation"
                                placeholder="Password Confirmation"
                                value={this.state.passwordConfirmation}
                                onChange={this.handleChange}
                                required
                            /> */}
                            <input
                                type="text"
                                id="userAddress"
                                className="input"
                                name="userAddress"
                                placeholder="User Address"
                                value={this.state.userAddress}
                                onChange={this.handleChange}

                            />

                            <input
                                type="text"
                                id="userPhone"
                                className="input"
                                name="userPhone"
                                placeholder="User Phone"
                                value={this.state.userPhone}
                                onChange={this.handleChange}

                            />

                            <input type="submit" value="Sign Up"/>
                        </form>
                    </div>
                </div>
            </div>
        )
    }


}