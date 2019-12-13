import React from 'react'
import {Route} from 'react-router-dom'
import Login from '../auth/Login'

export const AdminRoute = ({component: Component, ...rest}) => {
    
    //Return a Route with the "component" passed in
    return (
        <Route {...rest} render = {
            (props) => {
                if(sessionStorage.getItem("userEmail")==="admin")
                    return <Component {...props}/>
                else
                    return <Login {...props}/>
            }
        }/>
    )
}
