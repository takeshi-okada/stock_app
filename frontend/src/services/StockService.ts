import axios, { type AxiosResponse } from "axios";

import type { StockDataModel } from "../model/StockDataModel";

const loginUrl = 'http://localhost:8080/stocks';

export const stockService = (ticker: String):  Promise<AxiosResponse<StockDataModel, any>>=> {
    return axios.get(loginUrl, { params: { ticker: ticker } });
}