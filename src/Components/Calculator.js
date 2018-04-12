import React, { Component } from 'react';
import {getBandColorValue, getBandMultiplier, getBandTolerance, formatNumber} from '../Utils/util'

class Calculator extends Component {
  constructor(){
    super();
    this.state ={
      ohms : null
    }
  }
  static defaultProps = {
    band1:[
      {color:"brown", value:1},
      {color:"red", value:2},
      {color:"orange", value:3},
      {color:"yellow", value:4},
      {color:"green", value:5},
      {color:"blue", value:6},
      {color:"violet", value:7},
      {color:"grey", value:8},
      {color:"white", value:9},
    ],
    band2:[
      {color:"black", value:0},
      {color:"brown", value:1},
      {color:"red", value:2},
      {color:"orange", value:3},
      {color:"yellow", value:4},
      {color:"green", value:5},
      {color:"blue", value:6},
      {color:"violet", value:7},
      {color:"gray", value:8},
      {color:"white", value:9}
    ],
    multiplier:[
      {color:"black", value:"x 1Ω"},
      {color:"brown", value:"x 10Ω"},
      {color:"red", value:"x 100Ω"},
      {color:"orange", value:"x 1kΩ"},
      {color:"yellow", value:"x 10kΩ"},
      {color:"green", value:"x 100kΩ"},
      {color:"blue", value:"x 1MΩ"},
      {color:"violet", value:"x 10MΩ"},
      {color:"gray", value:"x 100MΩ"},
      {color:"white", value:"x 1GΩ"}
    ],
    tolerance:[
      {color:"brown", value:"± 1%"},
      {color:"red", value:"± 2%"},
      {color:"green", value:"± 0.5%"},
      {color:"blue", value:"± 0.25%"},
      {color:"violet", value:"± 0.1%"},
      {color:"gray", value:"± 0.05%"},
      {color:"gold", value:"± 5%"},
      {color:"silver", value:"± 10%"}
    ]
  }

  handleSubmit(e){
    e.preventDefault();
    let band1Color = this.refs.band1.value;
    let band2Color = this.refs.band2.value;
    let multiplierColor = this.refs.multiplier.value;
    let toleranceColor = this.refs.tolerance.value;
    let ohms = this.calculate(band1Color, band2Color, multiplierColor, toleranceColor);
    this.setState({ohms:ohms});

    //Alternatively we can calculate result in backend, but for demo purpose i just calculate value right here
    /*fetch('backend_url')
        .then(res =>res.json())
        .then(res =>{
          this.setState({ohms:res.value});
        })
        .catch(error => {
          console.error(error);
        })
     */   
  }

  calculate(band1Color,band2Color,multiplierColor,toleranceColor){
    let band1 = getBandColorValue(band1Color);
    let band2 = getBandColorValue(band2Color);
    let multiplier = getBandMultiplier(multiplierColor);
    let tolerance = getBandTolerance(toleranceColor);
    let ohmValue = (band1 * 10 + band2) * multiplier;
    return formatNumber(ohmValue) + " Ohms " + tolerance
  }

  render() {
    let band1Options = this.props.band1.map(band =>{
       return <option key={band.color} value={band.color}>{band.color} {band.value}</option>;
    })
    let band2Options = this.props.band2.map(band =>{
      return <option key={band.color} value={band.color}>{band.color} {band.value}</option>;
    })
    let multiplier = this.props.multiplier.map(band =>{
      return <option key={band.color} value={band.color}>{band.color} {band.value}</option>;
    })
    let tolerance = this.props.tolerance.map(band =>{
      return <option key={band.color} value={band.color}>{band.color} {band.value}</option>;
    })
    return (
      <div className="calculator">
         <h1>Ohms Calculator</h1>
        <form onSubmit={this.handleSubmit.bind(this)}>
          <div className="bandOption">
              <label>Band1: </label>
              <select className="width-150" ref="band1">
                    {band1Options}
              </select>
          </div>
          <div className="bandOption">
              <label>Band2: </label>
              <select className="width-150" ref="band2">
                    {band2Options}
              </select>
          </div>
          <div  className="bandOption">
              <label>Multiplier: </label>
              <select className="width-150" ref="multiplier">
                    {multiplier}
              </select>
          </div>
          <div  className="bandOption">
              <label>Tolerance: </label>
              <select className="width-150" ref="tolerance">
                    {tolerance}
              </select>
          </div>
          <div className="bandOption">
            <input type="submit" value="Calculate Ohm"/>
          </div>
          <span>{this.state.ohms}</span>
      </form>
      </div>
    );
  }
}

export default Calculator;
