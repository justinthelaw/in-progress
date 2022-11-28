import React from "react";
import "./styles/App.css";
import Input from "./components/Input";

class App extends React.Component<
  unknown,
  { value: string; result: string; code: string }
> {
  constructor(props: React.Component) {
    super(props);
    this.state = {
      value: "",
      result: "",
      code: "",
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(e: React.ChangeEvent<HTMLInputElement>) {
    e.preventDefault();
    this.setState({
      value: e.target.value,
    });
  }

  async handleSubmit(e: React.FormEvent<HTMLButtonElement>) {
    e.preventDefault();
    await fetch("http://localhost:8080/check?url=" + this.state.value, {
      method: "GET",
    })
      .then((res) => res.json())
      .then((data) => {
        this.setState({
          result: `Result: ${data.result}`,
          code: `HTTP Response: ${data.code}`,
        });
      })
      .catch((error) => console.log(error));
  }

  render() {
    return (
      <div className="App App-header">
        <header>Justin Law's Portfolio</header>
        <form>
          <Input
            type="text"
            onChange={this.handleChange}
            value={this.state.value}
            />
          <button onClick={this.handleSubmit}>Submit</button>
        </form>
        <p>
          {this.state.result} <br />
          {this.state.code}
        </p>
      </div>
    );
  }
}

export default App;
