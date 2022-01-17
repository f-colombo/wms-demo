import http from "../httpCommon";

class ProveedorDataService {
    getAll() {
        return http.get('/proveedores');
    }
}

export default new ProveedorDataService();