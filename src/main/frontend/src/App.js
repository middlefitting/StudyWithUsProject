import React, {useEffect, useState} from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./components/Home";
import Home2 from "./components/Home2";


function App() {

  return (
      <Router>
        <Navbar/>
            <Switch>
                <Route exact path="/" component={Home} />
                <Route path="/aa" component={Home2} />
            </Switch>
      </Router>

  );
}

export default App;
