import React, { Component } from 'react';
import '../../ManageUsers.css';
import Header from '../Header';
import Axios from 'axios';


class History extends Component {

    constructor(props) {
        super(props)
        this.state = {
            //Where we store data for every state
            history: [],
            message: null
        }
        this.refreshHistory = this.refreshHistory.bind(this)
    }

    componentDidMount() {
        this.refreshHistory();
    }

    refreshHistory() {
        Axios.get(`http://localhost:8080/recyclean/recycle/history/${sessionStorage.getItem("userId")}`).then(
            response => this.setState({
                history: response.data
            })
        )
    }



    render() {
        return (

            <div>{/*removed container*/}
                <Header />
                <div className="container">
                    <h1>History for {sessionStorage.getItem("userEmail")}</h1>
                    <table className="table ">
                        <thead>
                            <tr>
                                <th>Waste ID</th>
                                <th>Product Name</th>
                                <th>Last Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                // This map allow us to loop around a list of objects
                                this.state.history ?
                                this.state.history.map(
                                    item =>
                                        //Key to identify each row
                                        // {} in order to execute JS code
                                        <tr key={item.waste_Id}>
                                            <td>{item.waste_Id}</td>
                                            <td>{item.prod_name}</td>
                                            <td>{item.last_Updated_By}</td>
                                        </tr>
                                ) : ("THIS LIST IS EMPTY")
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default History