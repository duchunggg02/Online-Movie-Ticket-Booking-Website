import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/VePhim";
const SERVER = "http://localhost:8080"

export const endpoint = {
    "movies": `${SERVER_CONTEXT}/api/movies/`,
    "movies_detail": (phimID) => `${SERVER_CONTEXT}/api/movies/${phimID}/`,
    "showtimes": (phimID) => `${SERVER_CONTEXT}/api/movies/${phimID}/showtimes/`,
    "showtimes_id": (suatChieuID) => `${SERVER_CONTEXT}/api/showtimes/${suatChieuID}/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "register": `${SERVER_CONTEXT}/api/users/`,
    "seats": (suatChieuID) => `${SERVER_CONTEXT}/api/showtimes/${suatChieuID}/seats/`,
    "booking-ticket": `${SERVER_CONTEXT}/api/tickets/add/`,
    "ticket": (nguoiDungID) => `${SERVER_CONTEXT}/api/users/${nguoiDungID}/tickets/`,
    "feedbacks": (phimID) => `${SERVER_CONTEXT}/api/movies/${phimID}/feedbacks/`,
    "add_feedbacks": `${SERVER_CONTEXT}/api/feedbacks/`,
    "ticket_detail": (veID) => `${SERVER_CONTEXT}/api/tickets/${veID}/`,
    "isExistUsername":  `${SERVER_CONTEXT}/api/users/check-username/`
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization": cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL: SERVER
})