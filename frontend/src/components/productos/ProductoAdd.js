import React, { useState, useContext } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalState';

export const ProductoAdd = () => {
    let history = useHistory();

    return (
        <React.Fragment>
            ProductoAdd
            <p className='text-center bg-gray-100 text-gray-500 py-5'>
                No data.
            </p>
        </React.Fragment>
    );
}