import React, { Component } from 'react';
import UserDataService from '../../service/UserDataService';
import '../../ManageUsers.css';
import Header from '../Header';


class ManageUsers extends Component {

    constructor(props) {
        super(props)
        this.state = {
            //Where we store data for every state
            users: [],
            message: null
        }
        this.deleteUserClicked = this.deleteUserClicked.bind(this)
        this.refreshUsers = this.refreshUsers.bind(this)
    }


    //Called everytime as soon as the component is mounted
    componentDidMount() {
        this.refreshUsers();
    }

    refreshUsers() {
        UserDataService.retrieveAllUsers()//HARDCODED
            .then(
                response => {
                    console.log(response);
                    // Store retrieved data in every state after each refresh
                    this.setState({ users: response.data })
                }
            )
    }



    deleteUserClicked(userId, userEmail) {
        UserDataService.deleteUser(userId, userEmail)
            .then(
                response => {
                    this.setState({ message: `Delete of user ${userId} Successful` })
                    this.refreshUsers()
                }
            )

    }

    

    render() {
        return (
            <div>
                <Header/>
            <main>
                <div className="container">
                    {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                    <table className="table ">
                        <thead>
                            <tr>
                                <th>User Id</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Contact</th>
                                <th>Credits</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                // This map allow us to loop around a list of objects
                                this.state.users.map(
                                    user =>
                                        //Key to identify each row
                                        // {} in order to execute JS code
                                        <tr key={user.userId}>
                                            <td>{user.userId}</td>
                                            <td>{user.username}</td>
                                            <td>{user.userEmail}</td>
                                            <td>{user.userAddress}</td>
                                            <td>{user.userPhone}</td>
                                            <td>{user.userCredits}</td>                                            
                                            <td><span className="status text-success">&bull;</span> Active</td>

                                            <td><button className="btn btn-warning" onClick={() => this.deleteUserClicked(user.userId, user.userEmail)}>Delete</button></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>

                </div>
                
            </main >
            </div>
        )
    }
}

export default ManageUsers