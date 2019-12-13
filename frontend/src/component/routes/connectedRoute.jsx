import React from 'react'
import {Route} from 'react-router-dom'
import Home from '../pages/Home'


export const ConnectedRoute = ({component: Component, ...rest}) => {
    
    //Return a Route with the "component" passed in
    return (
        <Route {...rest} render = {
            (props) => {
                if(sessionStorage.getItem("userEmail")!==null){
                 console.log("ALO 1")
                    return <Home {...props}/>
                }
                else{
                    console.log("ALO 2")
                    return <Component {...props}/>
                }
            }
        }/>
    )
}
