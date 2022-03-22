import React from "react";
import './App.css';
import Navbar from "./components/Navbar";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import AccountMember from "./components/AccountMember";

function App() {
  return (
    <>
      <Router>
        <Navbar />
            <Switch>
                <Route exact path="/accountMember" component={AccountMember} /> {/*회원가입컴포넌트로 이동*/}
            </Switch>
      </Router>
    </>
  );
}

export default App;
