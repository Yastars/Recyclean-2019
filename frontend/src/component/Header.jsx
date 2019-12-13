import React, { Component } from 'react';
import Logo from '../img/Logo.png';
import { Redirect } from 'react-router-dom';

class Header extends Component {
    constructor(props) {
        super(props);

        this.state = {
            userEmail: "",
            userCredits: ""
        }
        
        this.forceUpdate();

        this.connectedNavbar = this.connectedNavbar.bind(this);
        this.logout = this.logout.bind(this);
        this.adminNavbar = this.adminNavbar.bind(this);
        this.guestNavbar = this.guestNavbar.bind(this);
        this.connectedNavbar = this.connectedNavbar.bind(this);
    }

    componentWillMount() {
        if (sessionStorage.getItem("userEmail")) {
            this.setState(
                {
                    userEmail: sessionStorage.getItem("userEmail"),
                    userCredits: sessionStorage.getItem("userCredits")
                }
            )
            this.forceUpdate();
        }
    }

    logout() {
        sessionStorage.setItem("userCredits", '');
        sessionStorage.setItem("userEmail", '');
        sessionStorage.setItem("userId", '');
        sessionStorage.clear();
        return <Redirect to={'/login'}></Redirect>
    }

    connectedNavbar() {
        if (sessionStorage.getItem("userEmail"))
            return <>
                <li><a href="/logout">{this.state.userEmail}</a></li>
                <li><a href="/" onClick={this.logout}>Logout</a></li>
            </>
        return ""
    }

    userNavbar() {
        if (sessionStorage.getItem("userEmail"))
            return <>
            <li><a href="/scanqr">Scan QR</a></li>
            <li><a href="/history">History</a></li>
            </>
        return ""
    }

    adminNavbar() {
        if (sessionStorage.getItem("userEmail")) {
            if (sessionStorage.getItem("userEmail") === "admin")
                return <>  <li><a href="/manageUsers">Manage Users</a></li>
                    <li><a href="/products">Manage Products</a></li>
                </>
        }
        return ""
    }

    guestNavbar() {
        if (!sessionStorage.getItem("userEmail"))
            return <><li><a href="/login">Login</a></li>
                <li><a href="/registration">Sign Up</a></li></>
        return ""
    }


    render() {
        return (
            <header>
                <img src={Logo} alt=""></img>
                <nav>
                    <ul>
                        <li><a href="/">Home</a></li>
                        <li><a href="/offer">Offer</a></li>
                        <li><a href="/about">About Us</a></li>
                        <li><a href="/contact">Contact</a></li>

                        {/* <li><a href="/logout">Connected as {this.state.userEmail}</a></li>
                        <li><a href="/" onClick={this.logout}>Logout</a></li> */}
                        <this.userNavbar />
                        <this.guestNavbar />
                        <this.adminNavbar />
                        <this.connectedNavbar />
                    </ul>
                </nav>

                {/*<a href="/" className="right">Credits: 0 CR</a>*/}
            </header>
        )
    }
}

export default Header
