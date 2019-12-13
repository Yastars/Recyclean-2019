import React, { Component } from "react";
import axios from 'axios';
import homeCover from '../../img/home.jpg';
import { FaQrcode,FaUserAlt,FaRegMoneyBillAlt } from 'react-icons/fa';
import { IconContext } from "react-icons";
import Header from "../Header";




class Home extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      user_Id: 777,
      waste_history: []
    }
    this.forceUpdate();
  }

  getHistoryWaste() {
    const URL_WASTE_HIST = `http://localhost:8080/recyclean/recycle/history/${this.state.user_Id}`;
    axios.get(URL_WASTE_HIST).then(
      this.setState({

      }
      )
    );
  }

  componentWillMount(){
    this.forceUpdate();
  }


  render() {
    return (
      <div>
        
        {/* <div className="col-md-4">.</div>
            <div className="col-md-8">
            <img style={{ marginLeft: "35%"}} className="homePage" src="homepage.jpg" alt="" />
            </div> */}
            <Header />
        <main className="Home">
          <div className="Cover" style={{
            backgroundImage: "url('" + homeCover + "')",
            backgroundRepeat: "no-repeat",
            backgroundSize: "cover",
            backgroundPosition: "center"
          }}>

            <div className="Text">
              <h1>RECYCLEAN</h1>
            </div>
          </div>

          <div className="under-cover">
            <p>“There is no such thing as 'away'. When we throw anything away it must go somewhere.”
            “When you put the whole picture together, recycling is the right thing to do.”
            “We cannot solve our problems with the same thinking we used when we created them.”
          <br />Recyclean Team</p>
          </div>


          <div className="service">

            <div className="block">
              <h3>Register</h3>
              <IconContext.Provider value={{ 
                color: "black",
                className: "global-class-name",
                size:"6em" }}>
                <div>
                  <FaUserAlt />
                </div>
              </IconContext.Provider>
              <p>We acctualy have a lot of things to do, you can check with me</p>
              </div>


            <div className="block">
              <h3>Scan</h3>
              <IconContext.Provider value={{ 
                color: "black",
                className: "global-class-name",
                size:"6em" }}>
                <div>
                  <FaQrcode />
                </div>
              </IconContext.Provider>
              We acctualy have a lot of things to do, you can check with me
              </div>


            <div className="block">
              <h3>Earn Credits</h3>
              <IconContext.Provider value={{ 
                color: "black",
                className: "global-class-name",
                size:"6em" }}>
                <div>
                  <FaRegMoneyBillAlt />
                </div>
              </IconContext.Provider>
              We acctualy have a lot of things to do, you can check with me
              </div>

          </div>

        </main>



        <footer className="page-footer font-small">
        
        
        <div className="footer-copyright text-center text-black-50 py-3">© 2019 Copyright:
          <a className="dark-grey-text" href="/"> Recyclean</a>
        </div>
      </footer>

      </div>



    );
  }
}
export default Home;