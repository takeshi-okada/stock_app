import axios from "axios";

import type { NewRegistUserRequestModel } from "../model/NewRegistUserRequestModel";

const registUserUrl = 'http://localhost:8080/new_regist';

export const registUserService = (params: NewRegistUserRequestModel) => {
    return axios.post(registUserUrl, params);
}