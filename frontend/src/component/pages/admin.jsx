import React from "react";
import { useAuth } from "../auth/context/auth";
import Header from "../Header";

function Admin(props) {
  const { setAuthTokens } = useAuth();
  

  function logOut() {
    setAuthTokens();
  }

  return (
    <div>
      <Header/>
      <div>Admin Page</div>
      wtfsfhsd dsfjkdshfsd
      dsfjkh
      <input onClick={logOut()}>Log out</input>
    </div>
  );
}

export default Admin;