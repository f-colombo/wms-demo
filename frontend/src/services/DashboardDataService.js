import http from "../httpCommon";

class DashboardDataService {
    getItems() {
        return http.get('/dashboard');
    }
}

export default new DashboardDataService();