import axios from "axios";

const loginUrl = 'http://localhost:8080/login';

export const loginUserService = () => {
    return axios.get(loginUrl);
}