import './App.css';
import NoticeList from "./Board/List/NoticeList";
import Free_Write from "./Board/Write_form/Free_Write";
import {BrowserRouter, Link, Route, Router, Switch} from "react-router-dom";
import QNA_Write from "./Board/Write_form/QNA_Write";
import Notice_Write from "./Board/Write_form/Notice_Write";
import Free_Detail from "./Board/Write_Details/Free_Detail";
import Header from "./Components/Header";
import Footer from "./Components/Footer";
import Update_Detail from "./Board/Update/Update_Detail";
import Nav from "./Components/Nav";
import Study_List from "./Study/Study_List";
import Study_Make from "./Study/Study_Make";
import Study_Inside from "./Study/Study_Detail/Study_Inside";
import Study_Board_Detail from "./Study/Study_Detail/Study_Board_Detail";
import Study_Board_Update from "./Study/Study_Detail/Study_Board_Update";
import Study_Write from "./Study/Study_Write";
import BoardList from "./Board/List/BoardList";
import QNAList from "./Board/List/QNAList";

function App() {

  return (
    <div className="container">
        <Header />

        <BrowserRouter>
            <Nav />
            <Switch>
            <Route path="/" component={NoticeList} exact/>
            <Route path="/NoticeList" component={NoticeList} exact/>
            <Route path="/BoardList" component={BoardList} exact />
            <Route path="/QNAList" component={QNAList} exact />
            <Route path="/Free_Write" component={Free_Write} exact/>
            <Route path="/QNA_Write" component={QNA_Write}  exact/>
            <Route path="/Notice_Write" component={Notice_Write}  exact/>
            <Route path="/Free_Detail" component={Free_Detail} exact />
            <Route path="/Update_Detail" component={Update_Detail} exact />
            <Route path="/Study_List" component={Study_List} exact />
            <Route path="/Study_Make" component={Study_Make} exact />
            <Route path="/Study_Inside" component={Study_Inside} exact />
            <Route path="/Study_Board_Detail" component={Study_Board_Detail} exact/>
            <Route path="/Study_Board_Update" component={Study_Board_Update} exact />
            <Route path="/Study_Write" component={Study_Write} exact />

            </Switch>
        </BrowserRouter>
<Footer />

    </div>


  );
}

export default App;
