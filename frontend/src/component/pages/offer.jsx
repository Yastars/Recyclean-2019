import React, { Component } from 'react';
import offer1 from '../../img/offers/1.jpg'
import offer2 from '../../img/offers/2.jpg'
import offer3 from '../../img/offers/3.png'
import Header from '../Header';

class offer extends Component {
  render() {
    return(
    <div>
      <Header/>
       <main className="myOffers">
        <div className="container">
          <h1>All Offers</h1>
          <div className="blocks">
            <a href="test.html">
              <div className="block">
                <div className="image"><img src={offer1} height={300} width={280} alt="" /></div>
                <div className="title">Product 1
                  <p className="price">450 Credits</p>
                </div>
                <div className="getOffer"> <input type="submit" className defaultValue="Get Offer" /> </div>
              </div>
            </a>
            <a href="test.html">
              <div className="block">
                <div className="image"><img src={offer2} height={300} width={280} alt="" /></div>
                <div className="title">Product 2
                  <p className="price">450 Credits</p>
                </div>
                <div className="getOffer"> <input type="submit" className defaultValue="Get Offer" /> </div>
              </div>
            </a>
            <a href="test.html">
              <div className="block">
                <div className="image"><img src={offer3} height={300} width={280} alt="" /></div>
                <div className="title">Product 3
                  <p className="price">4150 Credits</p>
                </div>
                <div className="getOffer"> <input type="submit" className defaultValue="Get Offer" /> </div>
              </div>
            </a>
            <a href="test.html">
              <div className="block">
                <div className="image"><img src={offer2} height={300} width={280} alt="" /></div>
                <div className="title">Product 4
                  <p className="price">450 Credits</p>
                </div>
                <div className="getOffer"> <input type="submit" className defaultValue="Get Offer" /> </div>
              </div>
            </a>
            <a href="test.html">
              <div className="block">
                <div className="image"><img src={offer1} height={300} width={280} alt="" /></div>
                <div className="title">Product 5
                  <p className="price">650 Credits</p>
                </div>
                <div className="getOffer"> <input type="submit" className defaultValue="Get Offer" /> </div>
              </div>
            </a>
            <a href="test.html">
              <div className="block">
                <div className="image"><img src={offer3} height={300} width={280} alt="" /></div>
                <div className="title">Product 6
                  <p className="price">350 Credits</p>
                </div>
                <div className="getOffer"> <input type="submit" className defaultValue="Get Offer" /> </div>
              </div>
            </a>
          </div>
        </div>
      </main>
    </div>
    )
  }
}



export default offer






