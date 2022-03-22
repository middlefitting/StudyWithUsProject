import logo from './logo.svg';
import './App.css';
import BoardList from "./Board/BoardList";
import Write from "./Board/Write";
import {BrowserRouter, Link, Route, Router, Switch} from "react-router-dom";

function App() {
  return (
    <div className="container">
        <BrowserRouter>
            <Route path="/" component={BoardList} exact/>
            <Route path="/BoardList" component={BoardList} />
            <Route path="/Write" component={Write}/>
        </BrowserRouter>
{/*        <Switch>
            <Route path="/BoardList" component={BoardList}/>
            <Route path="/Write" component={Write}/>
        </Switch>*/}


    </div>


  );
}

export default App;
