import axios from "axios";
import type { UserInfoRequestModel } from "../model/UserInfoRequestModel";

const loginUrl = 'http://localhost:8080/login';

export const loginUserService = (params: UserInfoRequestModel) => {
    return axios.post(loginUrl, params);
}