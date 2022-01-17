import React from "react";
import { render, unmountComponentAtNode } from "react-dom";
import { act } from "react-dom/test-utils";
import { Home } from "../components/Home";

let container = null;
beforeEach(() => {
    // setup a DOM element as a render target
    container = document.createElement("div");
    document.body.appendChild(container);
});

afterEach(() => {
    // cleanup on exiting
    unmountComponentAtNode(container);
    container.remove();
    container = null;
});

it("renders home data", async () => {
    const fakeDashboard = {
        entidades: [
            {
                svg: "M19.428 15.428a2 2 0 00-1.022-.547l-2.387-.477a6 6 0 00-3.86.517l-.318.158a6 6 0 01-3.86.517L6.05 15.21a2 2 0 00-1.806.547M8 4h8l-1 1v5.172a2 2 0 00.586 1.414l5 5c1.26 1.26.367 3.414-1.415 3.414H4.828c-1.782 0-2.674-2.154-1.414-3.414l5-5A2 2 0 009 10.172V5L8 4z",
                nombre: "Proveedores",
                cantidad: 3,
                texto: "Laboratorios fabricantes de las medicinas en venta",
                enlace: "/proveedores"
            },
            {
                svg: "M20 7l-8-4-8 4m16 0l-8 4m8-4v10l-8 4m0-10L4 7m8 4v10M4 7v10l8 4",
                nombre: "Productos",
                cantidad: 9,
                texto: "Medicinas habilitadas para la venta y distribución",
                enlace: "/productos"
            },
            {
                svg: "M3 10h18M3 14h18m-9-4v8m-7 0h14a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v8a2 2 0 002 2z",
                nombre: "Ubicaciones",
                cantidad: 169,
                texto: "Ubicaciones disponibles para el almacenaje de las medicinas",
                enlace: "/ubicaciones"
            }
        ],
        transacciones: [
            {
                svg: "M19 11H5m14 0a2 2 0 012 2v6a2 2 0 01-2 2H5a2 2 0 01-2-2v-6a2 2 0 012-2m14 0V9a2 2 0 00-2-2M5 11V9a2 2 0 012-2m0 0V5a2 2 0 012-2h6a2 2 0 012 2v2M7 7h10",
                nombre: "Producto/Ubicación",
                texto: "Listado de Productos con su ubicación de almacenaje",
                enlace: "/productos/ubicaciones"
            },
            {
                svg: "M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z",
                nombre: "Recepción de Productos",
                texto: "Realice una recepción de productos al almacén",
                enlace: "productos/recepciones"
            },
            {
                svg: "M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01",
                nombre: "Inventario de Lotes",
                texto: "Lotes de productos con su ubicación y cantidad",
                enlace: "productos/lotes"
            }
        ],
        valorInventario: {
            precioVenta: 52088,
            costoCompra: 30000,
            utilidad: 22088
        }
    }
    jest.spyOn(global, "fetch").mockImplementation(() =>
        Promise.resolve({
            json: () =>
                Promise.resolve(fakeDashboard)
        }));
    // Use the asynchronous version of act to apply resolved promises
    await act(async () => {
        render(<Home />, container);
    });

    // expect(container.querySelector("summary").textContent).toBe(fakeDashboard.name);
    // expect(container.querySelector("strong").textContent).toBe(fakeDashboard.age);
    expect(container.textContent).toContain("WMS - Demo");

    // remove the mock to ensure tests are completely isolated 
    global.fetch.mockRestore();
});