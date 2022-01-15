import React from 'react';
import { Heading } from './Heading';
import { ProveedorList } from './ProveedorList';

export const Home = () => {
    return (
        <React.Fragment>
            <div className='container mx-auto'>
                <h3 className='text-center text-3xl mt-20 text-base leading-8 text-black font-bold tracking-wide uppercase'>
                    WMS Demo with React, SpringBoot and Postgre
                </h3>
                <Heading />
                <ProveedorList />
            </div>
        </React.Fragment>
    );
};