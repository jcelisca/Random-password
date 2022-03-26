import React, { Component } from 'react'
import From from '../components/From'
import Result from '../components/Result'

class App extends Component {// component stateful
  render() {
    return (
      <div>
        <h3>Random passwords</h3>
        <p>Sistema para generar contraseñas random</p>
        <From />
        <Result />
      </div>
    )
  }
}

export default App


