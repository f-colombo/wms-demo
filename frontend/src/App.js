import { Route, Switch } from 'react-router-dom';
import './App.css';
import { GlobalProvider } from './context/GlobalState';
import { Home } from './components/Home';
import { ProveedorAdd } from './components/ProveedorAdd';
import { ProveedorEdit } from './components/ProveedorEdit';

function App() {
  return (
    <GlobalProvider>
      <div className='App'>
        <Switch>
          <Route path='/' component={Home} exact />
          <Route path='/add' component={ProveedorAdd} exact />
          <Route path='/edit/:id' component={ProveedorEdit} exact />
        </Switch>
      </div>
    </GlobalProvider>
  );
}

export default App;

// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;
