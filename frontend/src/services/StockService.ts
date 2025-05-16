import axios from "axios";

const loginUrl = 'http://localhost:8080/stocks';

export const stockService = (ticker: String) => {
    return axios.get(loginUrl, { params: { ticker: ticker } });
}