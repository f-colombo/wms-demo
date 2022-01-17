import { render, screen } from '@testing-library/react';
import { shallow } from 'enzyme';
import App from './App';
import Navbar from './components/NavBar';

it("renders without crashing", () => {
  shallow(<App />);
});

it("renders NavBar", () => {
  const wrapper = shallow(<Navbar />);
  const welcome = <span className="underline decoration-blue-500">Wharehouse Management System</span>;
  expect(wrapper.contains(welcome)).toEqual(true);
});