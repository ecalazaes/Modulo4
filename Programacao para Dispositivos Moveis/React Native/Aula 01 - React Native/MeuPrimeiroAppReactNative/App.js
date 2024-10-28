import React, { Component } from 'react';
import { Button, Text, View } from 'react-native';

class App extends Component {

  constructor(props){
    super(props);
    this.state = {
      nome: "Erick Calazães"
    };
    this.entrar = this.entrar.bind(this)
  }

  entrar() { 
    this.setState({
      nome: "Daniele Pinheiro"
    })
  }

    render() {
    return(
      <View style={{ marginTop: 20 }}>
        <Button title='Entrar' onPress={this.entrar}></Button>
        <Text style = {{color: 'blue', fontSize: 25, textAlign: 'center'}}>{this.state.nome}</Text>
      </View>
      );
    }
  }
  export default App;
  
