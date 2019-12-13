import React, { Component } from 'react';
import Header from '../Header';
//elte_softtech@elte.ik

class Offer extends Component {
  render() {
    
    return (
        <div>
          <Header/>
          <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" />
          {/* About us */}
          <div className="aboutus-section">
            <div className="container">
              <div className="row">
                <div className="col-md-3 col-sm-6 col-xs-12">
                  <div className="aboutus">
                    <h2 className="aboutus-title">About Us</h2>
                    <p>Nature is the epitome of life.  To preserve it, nurture it is every humans responsibility. Our philosophy is dedicated in bringing this idea closer by RECYCLEAN.
                    </p>
                    <p>Recyclean is a platform for managing the waste and promopting recycling, creating an impact on this upcoming generation</p>
                  </div>
                </div>
                <div className="col-md-3 col-sm-6 col-xs-12">
                  <div className="aboutus-banner">
                    <img src="assets/img/giphy.gif" alt="" className="imgRec" />
                  </div>
                </div>
                <div className="col-md-4 col-sm-6 col-xs-12">
                  <div className="feature">
                    <div> {/*class="feature-box"  class="clearfix" class="iconset" class="glyphicon glyphicon-cog icon" */}
                      <div>
                        <div>
                          <span />
                        </div>
                        <div className="feature-content">
                          <h4>Huge environmental impact</h4>
                          <p>People usually don't put wate materials in the right place.Web application focused solution to <b>encourage</b> people to throw the garbage to the right place</p>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div>
                        <div>
                          <span />
                        </div>
                        <div className="feature-content">
                          <h4>Segregation of waste materials</h4>
                          <p>QR Based mechanism to identify different waste materials. Materials will be <b>segregated by</b> their specific <b>type</b>: paper, glass, plastic and etc.</p>
                        </div>
                      </div>
                    </div>
                    <div>
                      <div>
                        <div>
                          <span />
                        </div>
                        <div className="feature-content">
                          <h4>Payback reward points system</h4>
                          <p>Clients of supermarkets who throw the trash can in the right place will be getting discounts.</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          {/*==========*/}
          {/*===============================*/}
          {/*== Team =============*/}
          {/*===============================*/}
          {/* Contact us */}
          <div className="padBot">
         
          </div>
          {/*==========*/}
          {/*==========*/}
        </div>
      );




  }
}

export default Offer