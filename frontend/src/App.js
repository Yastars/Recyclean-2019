
import React from "react"

//import logo from './logo.svg';
import './App.css';


import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Home from './component/pages/Home';

import ManageUsers from './component/pages/ManageUsers';
import admin from './component/pages/admin';
import Registration from './component/auth/Registration';
import Login from './component/auth/Login';
import Product from "./component/pages/Product";
import ScanQR from "./component/scan/ScanQR";
import offer from "./component/pages/offer";

import { AdminRoute } from "./component/routes/adminRoute";
import { UserRoute } from "./component/routes/userRoute";
import { ConnectedRoute } from "./component/routes/connectedRoute";

import About from "./component/pages/about";
import Contact from "./component/pages/contact";
import History from "./component/pages/history";


function App(props) {
    return (
        <BrowserRouter>
          <div>
            
            <Switch>
              <Route exact path="/" component={Home}  />
              <ConnectedRoute path="/registration" component={Registration} />
              <ConnectedRoute path="/login" component={Login} />
              <AdminRoute path="/manageUsers" component={ManageUsers} />
              <AdminRoute path="/products" component={Product} />
              <Route path="/about" component={About} />
              <Route path="/contact" component={Contact} /> 
              <Route path="/admin" component={admin} />
              <UserRoute path="/ScanQR" component={ScanQR} />
              <UserRoute path="/history" component={History} />
              <Route path="/offer" component={offer} />
            </Switch>
          </div>
        </BrowserRouter>

    );
  }


export default App;
