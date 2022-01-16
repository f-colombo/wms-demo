import axios from 'axios';
import API_BASE_URL from './constants';

export default axios.create({
    baseURL: 'http://localhost:3004', //API_BASE_URL,
    headers : {
        'Content-type':'application/json'
    }
});