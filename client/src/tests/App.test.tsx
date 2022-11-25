import React from 'react';
import { render, screen } from '@testing-library/react';
import App from '../App';

test('Renders Justin Law', () => {
  render(<App />);
  const linkElement = screen.getByText(/Justin Law/i);
  expect(linkElement).toBeInTheDocument();
});
