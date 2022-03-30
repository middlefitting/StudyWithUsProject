import React from "react";
import {BrowserRouter as Router, Route, Switch, NavLink, Link} from "react-router-dom";
import Navbar from "./Components/Navbar";
import SignIn from "./Components/SignIn";
import SignUp from "./Components/SignUp";
import './App.css';
import NoticeList from "./Board/List/NoticeList";

function App() {

  return (
      <Router>
          <div className="header">
            <Navbar/>
          </div>
          <div className="content">
            <Switch>
                <Route exact path="/" />
                <Route path="/NoticeList" component={NoticeList} />
                <Route path="/signin" component={SignIn} />
                <Route path="/signup" component={SignUp} />
            </Switch>
          </div>
      </Router>

  );
}

export default App;
