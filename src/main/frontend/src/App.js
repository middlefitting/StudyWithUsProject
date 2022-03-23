import React from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Navbar from "./components/Navbar";
import SignIn from "./components/SignIn";
import SignUp from "./components/SignUp";

function App() {

  return (
      <Router>
        <Navbar/>
            <Switch>
                <Route exact path="/signin" component={SignIn} />
                <Route path="/signup" component={SignUp} />
            </Switch>
      </Router>

  );
}

export default App;
