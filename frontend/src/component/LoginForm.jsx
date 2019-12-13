import React, { Component } from 'react';


class LoginForm extends Component {
    render() {
        return (
            <main>
                <div className="container">
                    <div id="formContent">
                        <form>
                            <input type="text" id="login" className="input" name="login" placeholder="login"></input>
                            <input type="password" className="input" name="login" placeholder="password"></input>
                            <input type="submit" className="" value="Log In"></input>
                        </form>
                    </div>
                </div>

            </main>
        )
    }

}

export default LoginForm