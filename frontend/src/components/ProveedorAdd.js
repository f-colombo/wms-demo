import React, { useState, useContext } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { GlobalContext } from '../context/GlobalState';

export const ProveedorAdd = () => {
    let history = useHistory();
    const { proveedores, addProveedor } = useContext(GlobalContext);
    const [codigo, setCodigo] = useState('');
    const [nombre, setNombre] = useState('');
    const [direccion, setDireccion] = useState('');
    const [email, setEmail] = useState('');
    const [telefono, setTelefono] = useState('');

    const onSubmit = (e) => {
        e.preventDefault();
        const newProveedor = {
            id: proveedores.length + 1,
            codigo,
            nombre,
            direccion,
            email,
            telefono
        };
        addProveedor(newProveedor);
        history.push('/');
    };

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
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:text-gray-600'
                            value={codigo}
                            onChange={(e) => setCodigo(e.target.value)}
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
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:text-gray-600'
                            value={nombre}
                            onChange={(e) => setNombre(e.target.value)}
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
                            value={direccion}
                            onChange={(e) => setDireccion(e.target.value)}
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
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:text-gray-600'
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
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
                            className='shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:text-gray-600'
                            value={telefono}
                            onChange={(e) => setTelefono(e.target.value)}
                            type='text'
                            placeholder='Teléfono' />
                    </div>
                    <div className='flex items-center justify-between'>
                        <button className='mt-5 bg-green-400 w-full hover:bg-green-500 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline'>
                            Add Proveedor
                        </button>
                    </div>
                    <div className='text-center mt-4 text-gray-500'>
                        <Link to='/'>Cancel</Link>
                    </div>
                </form>
            </div>
        </React.Fragment>
    );
}