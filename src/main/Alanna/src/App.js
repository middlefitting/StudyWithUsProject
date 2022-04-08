import React from "react";
import {BrowserRouter as Router, Route, Switch, NavLink, Link} from "react-router-dom";
import Navbar from "./Components/Navbar";
import SignIn from "./Components/SignIn";
import SignUp from "./Components/SignUp";
import './App.css';
import NoticeList from "./Board/List/NoticeList";
import Notice_Write from "./Board/Write_form/Notice_Write";
import Notice_Detail from "./Board/Write_Details/Notice_Detail";
import Free_Write from "./Board/Write_form/Free_Write";
import Update_Detail from "./Board/Update/Update_Detail";
import Free_Detail from "./Board/Write_Details/Free_Detail";
import QNA_Detail from "./Board/Write_Details/QNA_Detail";
import QNA_Write from "./Board/Write_form/QNA_Write";
import BoardList from "./Board/List/BoardList";
import QNAList from "./Board/List/QNAList";
import Study_List from "./Study/Study_List";
import Study_Make from "./Study/Study_Make";
import Study_Inside from "./Study/Study_Detail/Study_Inside";
import Study_Board_Detail from "./Study/Study_Detail/Study_Board_Detail";
import Study_Board_Update from "./Study/Study_Detail/Study_Board_Update";
import Study_Write from "./Study/Study_Write";
import Classes_All from "./Classes/Classes_Index/Classes_All";
import MyPageList from "./Board/List/MyPageList";
import UserConfirm from "./Board/BoardComponent/UserConfirm";
import UserUpdate from "./Board/BoardComponent/UserUpdate";

function App() {

  return (
      <Router>
          <div className="header">
            <Navbar/>
          </div>
          <div className="content">
            <Switch>
                <Route exact path="/" />
                <Route path="/NoticeList" component={NoticeList} exact/>
                <Route path="/BoardList" component={BoardList} exact />
                <Route path="/QNAList" component={QNAList} exact />
                <Route path="/MyPageList" component={MyPageList} exact />

                <Route path="/Free_Detail" component={Free_Detail} exact />
                <Route path="/Notice_Detail" component={Notice_Detail} exact />
                <Route path="/Update_Detail" component={Update_Detail} exact />
                <Route path="/QNA_Detail" component={QNA_Detail} exact />

                <Route path="/Free_Write" component={Free_Write} exact/>
                <Route path="/QNA_Write" component={QNA_Write}  exact/>
                <Route path="/Notice_Write" component={Notice_Write}  exact/>


                <Route path="/Study_List" component={Study_List} exact />
                <Route path="/Study_Make" component={Study_Make} exact />
                <Route path="/Study_Inside" component={Study_Inside} exact />
                <Route path="/Study_Board_Detail" component={Study_Board_Detail} exact/>
                <Route path="/Study_Board_Update" component={Study_Board_Update} exact />
                <Route path="/Study_Write" component={Study_Write} exact />

                <Route path="/Classes_All" component={Classes_All} exact />
                <Route path="/UserConfirm" component={UserConfirm} exact />
                <Route path="/UserUpdate" component={UserUpdate} exact />

                <Route path="/signin" component={SignIn} />
                <Route path="/signup" component={SignUp} />

            </Switch>
          </div>
      </Router>

  );
}

export default App;
