import http from "../httpCommon";

class ProductoDataService {
    getAll() {
        return http.get('/productos');
    }
}

export default new ProductoDataService();