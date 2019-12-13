import React from 'react'
import { Component } from 'react';
import OfferDataService from '../service/OfferDataService.js'

const INSTRUCTOR = 'nothing'

class ListOffersComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            offers: [],
            message: null
        }
        this.refreshOffers = this.refreshOffers.bind(this)
    }

    componentDidMount() {
        this.refreshOffers();
    }

    refreshOffers() {
        OfferDataService.retrieveAllOffers(INSTRUCTOR)//HARDCODED
            .then(
                response => {
                    console.log(response);
                    this.setState({offers: response.data})
                }
            )
    }
    
    
    
    render() {
        return (
            <div className="container">
                <h3>All Offers</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Title</th>
                                <th>Description</th>
                                <th>Credits</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.offers.map(
                                    offer => <tr key={offer.id}>
                                                <td>{offer.id}</td>
                                                <td>{offer.username}</td>
                                                <td>{offer.description}</td>
                                                <td>450.0</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListOffersComponent