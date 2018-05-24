import React, { Component } from 'react';
import injectTapEventPlugin from 'react-tap-event-plugin';
import './App.css';
import LoginScreen from './components/Loginscreen';
import Home from './components/Home';
injectTapEventPlugin();


let donations = [{
  date: '12.04.2018',
  location : 'Zagreb'
}];

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loginPage: [],
      homePage: []
    }
  }

  componentWillMount() {
    var loginPage = [];
    //loginPage.push(<LoginScreen appContext={this} />);
    loginPage.push(<Home appContext={this} />)
    this.setState({
      loginPage: loginPage
    })
  }

  render() {
    return (
      <div className="App">
        {this.state.loginPage}
        {this.state.homePage}
      </div>
    );
  }
}

export default App;
