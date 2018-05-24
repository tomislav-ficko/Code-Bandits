import React, { Component } from 'react';
import injectTapEventPlugin from 'react-tap-event-plugin';
import './App.css';
import LoginScreen from './components/Loginscreen';
import Home from './components/Home';
injectTapEventPlugin();


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
    var homePage = [];
    loginPage.push(<LoginScreen appContext={this} />);
    homePage.push(<Home appContext={this} />)
    this.setState({
      //loginPage: loginPage,
      homePage: homePage
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
