export default function appReducer(state, action) {
    console.log(action);
    switch (action.type) {
        case "ADD_PROVEEDOR":
            return {
                ...state,
                proveedores: [...state.proveedores, action.payload]
            };

        case "EDIT_PROVEEDOR":
            const updatedProveedor = action.payload;
            const updatedProveedors = state.proveedores.map((proveedor) => {
                if (proveedor.id === updatedProveedor.id) {
                    return updatedProveedor;
                }
                return proveedor;
            });
            return {
                ...state,
                proveedores: updatedProveedors
            };

        case "REMOVE_PROVEEDOR":
            return {
                ...state,
                proveedores: state.proveedores.filter(
                    (proveedor) => proveedor.id !== action.payload
                )
            };
            
        default:
            return state;
    }
}