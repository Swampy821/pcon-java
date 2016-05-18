import React from 'react';
import ReactDOM from 'react-dom';

let World = require( "./world.jsx" );
 

class Hello extends React.Component {
  render() {
    return ( <span><h1>Hello</h1><World /></span>);
  }
}
 
ReactDOM.render(<Hello/>, document.getElementById('hello'));