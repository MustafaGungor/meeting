import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route, browserHistory, IndexRoute} from 'react-router';
import App from './App.jsx';
import Home from './Home.jsx';
import Employee from './Employee.jsx';
import Department from './Department.jsx';
import Meeting from './Meeting.jsx'


ReactDOM.render(
<Router history = {browserHistory}>
      <Route path = "/" component = {App}>
         <IndexRoute component = {Home} />
         <Route path = "home" component = {Home} />
         <Route path = "employee" component = {Employee} />
         <Route path = "department" component = {Department} />
         <Route path = "meeting" component = {Meeting} />
      </Route>
   </Router>
, document.getElementById('app'));