import React from "react";
import {BrowserRouter as Router, Route, Switch, NavLink, Link} from "react-router-dom";
import Navbar from "./Components/Navbar";
import SignIn from "./Components/SignIn";
import SignUp from "./Components/SignUp";

function App() {

  //
  return (
      <Router>
          <div className="header">
            <Navbar/>
          </div>
          <div className="content">
            <Switch>
                <Route exact path="/"/>
                <Route path="/signin" component={SignIn} />
                <Route path="/signup" component={SignUp} />
            </Switch>
          </div>
      </Router>

  );
}

export default App;
