import axios from "axios";

const backendServer = "localhost";
const backendPort = "8080";

//const backendServer = import.meta.env.VITE_BACKEND_SERVER;
//const backendPort = import.meta.env.VITE_BACKEND_PORT;

//console.log(backendServer, backendPort);

export default axios.create({
    baseURL: `http://${backendServer}:${backendPort}`,
    headers: {
        'Content-Type': 'application/json'
    }
});