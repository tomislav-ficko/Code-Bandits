import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import axios from 'axios';
import Home from './Home'

const apiBaseUrl = "http://126fa68b.ngrok.io";


class Login extends Component {
  constructor(props) {
    super(props);
    var localloginComponent = [];
    localloginComponent.push(
      <MuiThemeProvider>
        <div>
          <TextField
            hintText="Enter your username"
            floatingLabelText="Username"
            onChange={(event, newValue) => this.setState({ username: newValue })}
          />
          <br />
          <TextField
            type="password"
            hintText="Enter your Password"
            floatingLabelText="Password"
            onChange={(event, newValue) => this.setState({ password: newValue })}
          />
          <br />
          <RaisedButton label="Login" primary={true} style={style} onClick={(event) => this.handleClick(event)} />
        </div>
      </MuiThemeProvider>
    )
    this.state = {
      username: '',
      password: '',
      loginComponent: localloginComponent
    }
  }

  componentWillMount() {
    var localloginComponent = [];
    localloginComponent.push(
      <MuiThemeProvider>
        <div>
          <TextField
            hintText="Enter your username"
            floatingLabelText="Username"
            onChange={(event, newValue) => this.setState({ username: newValue })}
          />
          <br />
          <TextField
            type="password"
            hintText="Enter your Password"
            floatingLabelText="Password"
            onChange={(event, newValue) => this.setState({ password: newValue })}
          />
          <br />
          <RaisedButton label="Login" primary={true} style={style} onClick={(event) => this.handleClick(event)} />
        </div>
      </MuiThemeProvider>
    )
    this.setState({ loginComponent: localloginComponent })
  }

  handleClick(event) {
    var self = this;
    var payload = {
      "userName": this.state.username,
      "password": this.state.password
    }
    axios.post(apiBaseUrl + '/login', payload)
      .then(function (response) {
        console.log(response);
        if (response.status === 200) {
          console.log("Login successfull");
          var homeScreen = [];
          homeScreen.push(<Home appContext={self.props.appContext} />)
          self.props.appContext.setState({ loginPage: [], homeScreen: homeScreen })
        }
        else if (response.status === 204) {
          console.log("Username and password do not match");
          alert(response.data.success)
        }
        else {
          console.log("Username does not exists");
          alert("Username does not exist");
        }
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  handleMenuChange(value) {
    var localloginComponent = [];
    localloginComponent.push(
      <MuiThemeProvider>
        <div>
          <TextField
            hintText="Enter your username"
            floatingLabelText="Username"
            onChange={(event, newValue) => this.setState({ username: newValue })}
          />
          <br />
          <TextField
            type="password"
            hintText="Enter your Password"
            floatingLabelText="Password"
            onChange={(event, newValue) => this.setState({ password: newValue })}
          />
          <br />
          <RaisedButton label="Login" primary={true} style={style} onClick={(event) => this.handleClick(event)} />
        </div>
      </MuiThemeProvider>
    )

    this.setState({
      loginComponent: localloginComponent
    })
  }

  render() {
    return (
      <div>
        <MuiThemeProvider>
          <div>
            <AppBar title="Login" />
          </div>
        </MuiThemeProvider>
        {this.state.loginComponent}
      </div>
    );
  }
}

const style = {
  margin: 15,
};

export default Login;
