import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import RadioGroup from '@material-ui/core/RadioGroup';
import Radio from '@material-ui/core/Radio';
import FormControl from '@material-ui/core/FormControl';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormLabel from '@material-ui/core/FormLabel';
import Checkbox from '@material-ui/core/Checkbox';
import InputLabel from '@material-ui/core/InputLabel';
import Select from '@material-ui/core/Select';
import axios from 'axios';
import Login from './Login';

const apiBaseUrl = "http://126fa68b.ngrok.io";

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      first_name: '',
      last_name: '',
      userName: '',
      phone: '',
      email: '',
      gender: '',
      age: '',
      location: '',
      blood_type: '',
      gdpr: '',
      password: ''
    }
  }

  handleClick(event) {
    var self = this;
    //To be done:check for empty values before hitting submit
    if (this.state.first_name.length > 0 && this.state.last_name.length > 0 && this.state.userName.length > 0 && this.state.phone.length > 0
      && this.state.email.length > 0 && this.state.gender.length > 0 && this.state.age.length > 0
      && this.state.location.length > 0 && this.state.gdpr.length > 0 && this.state.password.length > 0) {
      var payload = {
        "name": this.state.first_name,
        "surname": this.state.last_name,
        "phoneNumber": this.state.phone,
        "email": this.state.email,
        "userName": this.state.userName,
        "sex": this.state.gender,
        "birthDate": this.state.age,
        "location": this.state.location,
        "bloodType": this.state.blood_type,
        "gdpr": this.state.gdpr,
        "password": this.state.password
      }
      axios.post(apiBaseUrl + '/users', { payload })
        .then(function (response) {
          console.log(response);
          if (response.status === 201) {
            //  console.log("registration successfull");
            var loginscreen = [];
            loginscreen.push(<Login parentContext={this} appContext={self.props.appContext} />);
            var loginmessage = "Not Registered yet.Go to registration";
            self.props.parentContext.setState({
              loginscreen: loginscreen,
              loginmessage: loginmessage,
              buttonLabel: "Register",
              isLogin: true
            });
          }
          else {
            console.log("Some error ocurred", response.data.code);
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    }
    else {
      alert("Input field value is missing");
    }
  }

  handleChangeGender = event => {
    this.setState({ gender: event.target.value });
  }

  handleChangeBloodType = event => {
    this.setState({ blood_type: event.target.value });
  }

  handleChangeGDPR = event => {
    this.setState({ gdpr: event.target.value });
  }

  render() {
    return (
      <div>
        <MuiThemeProvider>
          <div>
            <AppBar
              title="Register"
            />
            <TextField
              required
              hintText="Enter your First Name"
              floatingLabelText="First Name*"
              onChange={(event, newValue) => this.setState({ first_name: newValue })}
            />
            <br />
            <TextField
              required
              hintText="Enter your Last Name"
              floatingLabelText="Last Name*"
              onChange={(event, newValue) => this.setState({ last_name: newValue })}
            />
            <br />
            <TextField
              required
              hintText="Enter your user name"
              floatingLabelText="Username*"
              onChange={(event, newValue) => this.setState({ userName: newValue })}
            />
            <br />
            <TextField
              required
              hintText="Enter your phone number"
              floatingLabelText="Phone number*"
              onChange={(event, newValue) => this.setState({ phone: newValue })}
            />
            <br />
            <TextField
              required
              hintText="Enter your email address"
              floatingLabelText="Email*"
              onChange={(event, newValue) => this.setState({ email: newValue })}
            />
            <br />
            <br />
            <FormControl component="fieldset" required>
              <FormLabel component="legend">Gender</FormLabel>
              <RadioGroup
                value={this.state.gender}
                onChange={this.handleChangeGender}
              >
                <FormControlLabel value="F" control={<Radio />} label="Female" />
                <FormControlLabel value="M" control={<Radio />} label="Male" />
              </RadioGroup>
            </FormControl>
            <br />
            <TextField
              required
              hintText="Enter your age"
              floatingLabelText="Age*"
              onChange={(event, newValue) => this.setState({ age: newValue })}
            />
            <br />
            <TextField
              required
              type="password"
              hintText="Enter your Password"
              floatingLabelText="Password*"
              onChange={(event, newValue) => this.setState({ password: newValue })}
            />
            <br />
            <TextField
              required
              hintText="Pick your location"
              floatingLabelText="Location*"
              onChange={(event, newValue) => this.setState({ location: newValue })}
            />
            <br />
            <br />
            <FormControl className="formControl" >
              <InputLabel >Blood type</InputLabel> <br />
              <Select
                value={this.state.blood_type}
                onChange={this.handleChangeBloodType}
              >
                <option value="O-">O-</option>
                <option value="O+">O+</option>
                <option value="A-">A-</option>
                <option value="A+">A+</option>
                <option value="B-">B-</option>
                <option value="B+">B+</option>
                <option value="AB-">AB-</option>
                <option value="AB+">AB+</option>
              </Select>
            </FormControl>
            <br />
            <h4>
              GDPR text goes here
            </h4>
            <br />
            <FormControl required>
              <FormControlLabel
                control={
                  <Checkbox
                    checked={this.state.gdpr}
                    onChange={this.handleChangeGDPR}
                    value="gdpr"
                  />
                }
                label="I agree to the terms and conditions"
              />
            </FormControl>
            <br />
            <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)} />
          </div>
        </MuiThemeProvider>
      </div>
    );
  }
}

const style = {
  margin: 15,
};

export default Register;
