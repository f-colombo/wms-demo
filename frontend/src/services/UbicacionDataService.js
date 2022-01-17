import http from "../httpCommon";

class UbicacionDataService {
    getAll() {
        return http.get('/ubicaciones');
    }
}

export default new UbicacionDataService();