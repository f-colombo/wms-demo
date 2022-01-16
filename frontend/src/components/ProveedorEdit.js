import React, { useState, useContext, useEffect } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { GlobalContext } from '../context/GlobalState';

export const ProveedorEdit = (route) => {
    let history = useHistory();
    const { proveedores, editProveedor } = useContext(GlobalContext);
    const [selectedProveedor, setSelectedProveedor] = useState({
        id: null,
        codigo: '',
        nombre: '',
        direccion: '',
        email: '',
        telefono: ''
    });
    const currentProveedorId = route.match.params.id;

    useEffect(() => {
        const proveedorId = currentProveedorId;
        const selectedProveedor = proveedores.find(
            (currentProveedorTraversal) => currentProveedorTraversal.id === parseInt(proveedorId)
        );
        setSelectedProveedor(selectedProveedor);
    }, [currentProveedorId, proveedores]);

    const onSubmit = (e) => {
        e.preventDefault();
        editProveedor(selectedProveedor);
        history.push('/proveedores');
    };

    const handleOnChange = (userKey, newValue) =>
        setSelectedProveedor({ ...selectedProveedor, [userKey]: newValue });

    if (!selectedProveedor || !selectedProveedor.id) {
        return <div>Invalid Proveedor ID.</div>;
    }

    return (
        <React.Fragment>
            <div className='w-full max-w-sm container mt-20 mx-auto'>
                <div className='flex-grow text-left px-4 py-2 m-2'>
                    <h5 className='text-gray-900 font-bold text-xl'>Proveedor</h5>
                </div>
                <div className='flex-grow text-right px-4 py-2 m-2'>
                    {''}
                </div>
                <form onSubmit={onSubmit}>
                    <div className='w-full mb-5'>
                        <label
                            className='block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'
                            htmlFor='codigo'>
                            Código
                        </label>
                        <input
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:text-gray-600 focus:shadow-outline'
                            value={selectedProveedor.codigo}
                            onChange={(e) => handleOnChange('codigo', e.target.value)}
                            type='text'
                            placeholder='Código Proveedor' />
                    </div>
                    <div className='w-full mb-5'>
                        <label
                            className='block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'
                            htmlFor='nombre'>
                            Nombre
                        </label>
                        <input
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:text-gray-600 focus:shadow-outline'
                            value={selectedProveedor.nombre}
                            onChange={(e) => handleOnChange('nombre', e.target.value)}
                            type='text'
                            placeholder='Nombre Proveedor' />
                    </div>
                    <div className='w-full mb-5'>
                        <label
                            className='block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'
                            htmlFor='direccion'>
                            Dirección
                        </label>
                        <input
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:text-gray-600 focus:shadow-outline'
                            value={selectedProveedor.direccion}
                            onChange={(e) => handleOnChange('direccion', e.target.value)}
                            type='text'
                            placeholder='Dirección' />
                    </div>
                    <div className='w-full mb-5'>
                        <label
                            className='block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'
                            htmlFor='email'>
                            Email
                            </label>
                        <input
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:text-gray-600 focus:shadow-outline'
                            value={selectedProveedor.email}
                            onChange={(e) => handleOnChange('email', e.target.value)}
                            type='text'
                            placeholder='Email' />
                    </div>
                    <div className='w-full mb-5'>
                        <label
                            className='block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2'
                            htmlFor='telefono'>
                            Teléfono
                            </label>
                        <input
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:text-gray-600 focus:shadow-outline'
                            value={selectedProveedor.telefono}
                            onChange={(e) => handleOnChange('telefono', e.target.value)}
                            type='text'
                            placeholder='Teléfono' />
                    </div>
                    <div className='flex items-center justify-between'>
                        <button className='block mt-5 bg-green-400 w-full hover:bg-green-500 text-white font-bold py-2 px-4 rounded focus:text-gray-600 focus:shadow-outline'>
                            Edit Proveedor
                        </button>
                    </div>
                    <div className='text-center mt-4 text-gray-500'>
                        <Link to='/proveedores'>Cancel</Link>
                    </div>
                </form>
            </div>
        </React.Fragment>
    );
}