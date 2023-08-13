import http from "@/http-common";

class PersonService {
    getAll(): Promise<any> {
        return http.get("/persons");
    }

}

export default new PersonService();
