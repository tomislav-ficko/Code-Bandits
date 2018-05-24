import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import { Typography, Button } from '@material-ui/core';

class Home extends Component {
    constructor(props) {
        super(props);
        var localHomeComponent = [];
        localHomeComponent.push(
            <MuiThemeProvider>
                <div>
                    <Typography variant="display4" gutterBottom>
                        Here goes some text.
                    </Typography>
                </div>
                <br />
                <Button variant="raised" color="primary">
                    Primary
                </Button>
                <Button variant="raised" color="secondary">
                    Secondary
                </Button>
                <br />
                <div>
                    <Typography variant="display1" gutterBottom>
                        Some paragraph text goes here!
                    </Typography>
                </div>
            </MuiThemeProvider>
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