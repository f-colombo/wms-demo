import { Route, Switch } from 'react-router-dom';
import './App.css';
import { GlobalProvider } from './context/GlobalState';
import { Home } from './components/Home';
import { ProveedorAdd } from './components/proveedores/ProveedorAdd';
import { ProveedorEdit } from './components/proveedores/ProveedorEdit';
import { ProveedorList } from './components/proveedores/ProveedorList';
import { ProductoList } from './components/productos/ProductoList';
import { UbicacionList } from './components/ubicaciones/UbicacionList';

function App() {
  return (
    <GlobalProvider>
      <div className='App'>
        <Switch>
          <Route path='/' component={Home} exact />
          <Route path='/proveedores' component={ProveedorList} exact />
          <Route path='/proveedores/add' component={ProveedorAdd} exact />
          <Route path='/proveedor/edit/:id' component={ProveedorEdit} exact />
          <Route path='/productos' component={ProductoList} exact />
          <Route path='/ubicaciones' component={UbicacionList} exact />
        </Switch>
      </div>
    </GlobalProvider>
  );
}

export default App;
