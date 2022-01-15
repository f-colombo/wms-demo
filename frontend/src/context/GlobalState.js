import React, { createContext, useReducer } from 'react';
import appReducer from './AppReducer';

const initialState = {
    proveedores: [
        {
            id: 1,
            codigo: 'LCHI',
            nombre: 'Laboratorio Chile',
            direccion: 'Avenida Marathon #1315, Ñuñoa - Santiago.',
            email: 'contacto@laboratoriochile.cl',
            telefono: '56 22 365 5000'
        }
    ]
};

export const GlobalContext = createContext(initialState);

export const GlobalProvider = ({ children }) => {
    const [state, dispatch] = useReducer(appReducer, initialState);

    function addProveedor(proveedor) {
        dispatch({
            type: 'ADD_PROVEEDOR',
            payload: proveedor
        });
    }

    function editProveedor(proveedor) {
        dispatch({
            type: 'EDIT_PROVEEDOR',
            payload: proveedor
        });
    }

    function removeProveedor(id) {
        dispatch({
            type: 'REMOVE_PROVEEDOR',
            payload: id
        });
    }

    return (
        <GlobalContext.Provider
            value={{
                proveedores: state.proveedores,
                addProveedor,
                editProveedor,
                removeProveedor
            }}
        >
            {children}
        </GlobalContext.Provider>
    );
};