import React, { Component } from 'react';
import injectTapEventPlugin from 'react-tap-event-plugin';
import './App.css';
import LoginScreen from './components/Loginscreen';
injectTapEventPlugin();


let donations = [{
  date: '12.04.2018',
  location : 'Zagreb'
}];

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loginPage: []
    }
  }

  componentWillMount() {
    var loginPage = [];
    loginPage.push(<LoginScreen appContext={this} />);
    this.setState({
      loginPage: loginPage
    })
  }

  render() {
    return (
      <div className="App">
        {this.state.loginPage}
      </div>
    );
  }
}

export default App;
