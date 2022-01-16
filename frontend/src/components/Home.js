import React, { useState, useEffect } from 'react';
import DashboardDataService from '../services/DashboardDataService';

export const Home = () => {
    const initDashboardItems = {
        entidades: [],
        transacciones: [],
        valorInventario: {}
    };
    const [dashboardItems, setDashboardItems] = useState(initDashboardItems);

    useEffect(() => {
        function obtieneDashboardItems() {
            DashboardDataService.getItems()
                .then(response => {
                    setDashboardItems(response.data);
                    console.log(response.data);
                })
                .catch(ex => {
                    console.log(ex);
                });
        }
        obtieneDashboardItems();
    }, []);
    
    return (
        <React.Fragment>
            <section className="bg-white dark:bg-gray-900">
                <div className="container px-6 py-10 mx-auto">
                    <h1 className="text-3xl font-semibold text-gray-800 capitalize lg:text-4xl dark:text-white">WMS - Demo <br /> POC <span className="underline decoration-blue-500">Wharehouse Management System</span></h1>

                    <p className="mt-4 text-gray-500 xl:mt-6 dark:text-gray-300">
                        Software diseñado y creado para optimizar los procesos de almacenamiento, distribución, cadena de suministro y cumplimiento dentro de una empresa de distribución de medicinas.
                    </p>

                    <div className="grid grid-cols-1 gap-8 mt-8 xl:mt-12 xl:gap-12 md:grid-cols-2 xl:grid-cols-3">

                        {dashboardItems.entidades.map((row) => {
                            return (
                                <div key={row.nombre} className="p-8 space-y-3 border-2 border-blue-400 dark:border-blue-300 rounded-xl">
                                    <span className="inline-block text-blue-500 dark:text-blue-400">
                                        <svg xmlns="http://www.w3.org/2000/svg" className="w-8 h-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d={row.svg} />
                                        </svg>
                                    </span>

                                    <h1 className="text-2xl font-semibold text-gray-700 capitalize dark:text-white">{row.cantidad} {row.nombre}</h1>

                                    <p className="text-gray-500 dark:text-gray-300">
                                        {row.texto}
                                    </p>

                                    <a href={row.enlace} className="inline-flex p-2 text-blue-500 capitalize transition-colors duration-200 transform bg-blue-100 rounded-full dark:bg-blue-500 dark:text-white hover:underline hover:text-blue-600 dark:hover:text-blue-500">
                                        <svg xmlns="http://www.w3.org/2000/svg" className="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M13 9l3 3m0 0l-3 3m3-3H8m13 0a9 9 0 11-18 0 9 9 0 0118 0z" />
                                        </svg>
                                    </a>
                                </div>
                            );
                        })}

                        {dashboardItems.transacciones.map((row) => {
                            return (
                                <div key={row.nombre} className="p-8 space-y-3 border-2 border-blue-400 dark:border-blue-300 rounded-xl">
                                    <span className="inline-block text-blue-500 dark:text-blue-400">
                                        <svg xmlns="http://www.w3.org/2000/svg" className="w-8 h-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d={row.svg} />
                                        </svg>
                                    </span>

                                    <h1 className="text-2xl font-semibold text-gray-700 capitalize dark:text-white">{row.nombre}</h1>

                                    <p className="text-gray-500 dark:text-gray-300">
                                        {row.texto}
                                    </p>

                                    <a href={row.enlace} className="inline-flex p-2 text-blue-500 capitalize transition-colors duration-200 transform bg-blue-100 rounded-full dark:bg-blue-500 dark:text-white hover:underline hover:text-blue-600 dark:hover:text-blue-500">
                                        <svg xmlns="http://www.w3.org/2000/svg" className="w-6 h-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 5l7 7-7 7" />
                                        </svg>
                                    </a>
                                </div>
                            );
                        })}
                    </div>
                </div>
            </section>
            <div className='container mx-auto'>
                <div className=" bg-gray-100 ">
                    <div className="container p-10 mx-auto">
                        <h1 className="text-4xl font-bold text-gray-700 mb-6">Valor del Inventario</h1>
                        <div>
                            <h3 className="text-lg font-semibold">Utilidad:</h3>
                            <p className="text-5xl font-semibold mb-6">{dashboardItems.valorInventario.utilidad}</p>
                            <div className="grid grid-cols-2 bg-white mb-6 border-2 p-6 rounded-md">
                                <div className="flex flex-col items-center">
                                    <p className="text-lg font-semibold">Precio Venta:</p>
                                    <p className="text-5xl font-semibold text-green-500">{dashboardItems.valorInventario.precioVenta}</p>
                                </div>
                                <div className="flex flex-col items-center">
                                    <p className="text-lg font-semibold">Costo Compra:</p>
                                    <p className="text-5xl font-semibold text-red-500">{dashboardItems.valorInventario.costoCompra}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </React.Fragment>
    );
};