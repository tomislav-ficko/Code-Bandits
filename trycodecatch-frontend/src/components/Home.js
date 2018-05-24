import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import { Typography, Button } from '@material-ui/core';
import './Home.css';

class Home extends Component {
    constructor(props) {
        super(props);
        var localHomeComponent = [];
        localHomeComponent.push(
            <div className='root'>
                <MuiThemeProvider>
                    <div className='header-text'>
                        <Typography variant="display3" gutterBottom>
                            Drops4Life
                        </Typography>
                    </div>
                    <br />
                    <Button variant="raised" color="primary" onClick={(event) => this.handleClickLogin(event)}>
                        Login
                    </Button>
                    <Button variant="raised" color="secondary" onClick={(event) => this.handleClickRegister(event)}>
                        Register
                    </Button>
                    <br />
                    <div>
                        <Typography variant="display1" gutterBottom>
                            Five minutes of your time can be a liftime for someone else. <br />
                            Donate blood, save lives.
                        </Typography>
                    </div>
                </MuiThemeProvider>
            </div>
        )
        this.state = {
            homePage: localHomeComponent
        }
    }

    render() {
        return (
            <div>
                {this.state.homePage}
            </div>
        );
    }
}

export default Home