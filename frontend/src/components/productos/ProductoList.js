import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalState';
import { Heading } from '../Heading';

export const ProductoList = () => {
    const { productos, removeProducto } = useContext(GlobalContext);

    return (
        <React.Fragment>
            <Heading />
            <p className='text-center bg-gray-100 text-gray-500 py-5'>
                No data.
            </p>
        </React.Fragment>
    );
}