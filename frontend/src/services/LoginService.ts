import axios from "axios";
import type { UserInfoModel } from "../model/UserInfoModel";

const loginUrl = 'http://localhost:8080/login';

export const loginUserService = (params: UserInfoModel) => {
    return axios.post(loginUrl, params);
}