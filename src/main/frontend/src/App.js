import React from "react";
import {BrowserRouter as Router, Route, Switch, NavLink, Link} from "react-router-dom";
import Navbar from "./Components/Navbar";
import SignIn from "./Components/SignIn";
import SignUp from "./Components/SignUp";

import Board_Detail from "./Board/Write_Details/Board_Detail";
import Board_Write from "./Board/Write_form/Board_Write";
import Update_Detail from "./Board/Update/Update_Detail";

import BoardList from "./Board/List/BoardList";

import Study_List from "./Study/Study_List";
import Study_Make from "./Study/Study_Make";
import Study_Inside from "./Study/Study_Detail/Study_Inside";
import Study_Board_Detail from "./Study/Study_Detail/Study_Board_Detail";
import Study_Board_Update from "./Study/Study_Detail/Study_Board_Update";
import Study_Write from "./Study/Study_Write";
import Classes_All from "./Classes/Classes_Index/Classes_All";
import MyPageList from "./Board/List/MyPageList";
import Modification from "./Board/BoardComponent/Modification";
import ModificationList from "./Board/List/ModificationList";
import MainPage from "./Board/BoardComponent/MainPage";
import SearchList from "./Board/List/SearchList";

import './App.css';


function App() {

  return (
      <Router>
          <div className="header">
            <Navbar/>
          </div>
          <div className="content">
            <Switch>
                <Route exact path="/" component={MainPage}/>

                <Route path='/BoardList/:category' component={BoardList} exact />
                <Route path="/MyPageList" component={MyPageList} exact />
                <Route path="/ModificationList" component={ModificationList} exact />

                <Route path="/Board_Detail/:post_id" component={Board_Detail} exact />
                <Route path="/Update_Detail/:post_id" component={Update_Detail} exact />

                <Route path="/Board_Write" component={Board_Write} exact/>

                <Route path="/Study_List" component={Study_List} exact />
                <Route path="/Study_Make" component={Study_Make} exact />
                <Route path="/studies/:studyId" component={Study_Inside} exact />
                <Route path="/Study_Inside" component={Study_Inside} exact />
                <Route path="/Study_Board_Detail" component={Study_Board_Detail} exact/>
                <Route path="/Study_Board_Update" component={Study_Board_Update} exact />
                <Route path="/Study_Write/:studyId/" component={Study_Write} exact />

                <Route path="/Classes_All" component={Classes_All} exact />

                <Route path="/Modification" component={Modification} exact />


                <Route path="/signin" component={SignIn} />
                <Route path="/signup" component={SignUp} />

                <Route path="/SearchList/:category/:type/:keyword" component={SearchList}/>
            </Switch>
          </div>
      </Router>

  );
}

export default App;
