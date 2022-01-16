import React, { useState, useContext, useEffect } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalState';

export const ProductoEdit = (route) => {
    let history = useHistory();
    const currentProductoId = route.match.params.id;

    return (
        <React.Fragment>
            ProductoEdit
            <p className='text-center bg-gray-100 text-gray-500 py-5'>
                No data.
            </p>
        </React.Fragment>
    );
}