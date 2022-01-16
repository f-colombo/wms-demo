import { Route, Switch } from 'react-router-dom';
import './App.css';
import { GlobalProvider } from './context/GlobalState';
import { Home } from './components/Home';
import { ProveedorAdd } from './components/ProveedorAdd';
import { ProveedorEdit } from './components/ProveedorEdit';
import { ProveedorList } from './components/ProveedorList';
import { ProductoList } from './components/productos/ProductoList';

function App() {
  return (
    <GlobalProvider>
      <div className='App'>
        <Switch>
          <Route path='/' component={Home} exact />
          <Route path={'/proveedores'} component={ProveedorList} exact />
          <Route path='/add' component={ProveedorAdd} exact />
          <Route path='/edit/:id' component={ProveedorEdit} exact />
          <Route path={'/productos'} component={ProductoList} exact />
        </Switch>
      </div>
    </GlobalProvider>
  );
}

export default App;
