import React, { LegacyRef } from "react";

interface InputProps {
  type: string;
  onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
  value?: string | number | undefined;
  ref?: LegacyRef<HTMLInputElement> | undefined;
}

class Input extends React.Component<InputProps> {
  constructor(props: InputProps) {
    super(props);
  }

  render() {
    return <input type={this.props.type} onChange={this.props.onChange} value={this.props.value} ref={this.props.ref}/>
  }
}

export default Input;