import React, { Component } from 'react';
import Header from '../Header';


class Contact extends Component {
  render() {
    
    return (
        
      <div>
        <Header/>
      <main className="contact-section">
      <h1>Meet The Team</h1>
      <div className="contact">
        <div className="block">
          <img className="margT" src="assets/img/Yassine.jpg"  alt ="" />
          <p className="name">YASSINE QASSAR</p>
          <p className="job">Freelancer</p> 
          <p className="description">Data Scientist</p> 
          <p className="email">yassine.qassar@gmail.com</p> 
        </div>

        <div className="block">
          <img className="margT" src="assets/img/Yassine.jpg"  alt ="" />
          <p className="name">Jhon Deo</p>
          <p className="job">Team Leader</p> 
          <p className="description">Team Leader</p> 
          <p className="email">leader@gmail.com</p> 
        </div>

        <div className="block">
          <img className="margT" src="assets/img/Yassine.png"  alt ="" />
          <p className="name">YASSINE QASSAR</p>
          <p className="job">Full Stack Developer</p> 
          <p className="description">Software Architect</p> 
          <p className="email">yassine.qassar@gmail.com</p> 
        </div>
      </div>
      </main>
    </div>
  );
}
}

export default Contact