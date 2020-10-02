import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Endpoints } from 'src/app/endpoints.config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private _http: HttpClient
  ) { }

  customerLogin(username, password) {
    let URL = Endpoints.customer.login;
    return this._http.get(URL, {
      params: {
        username: username,
        password: password
      }
    })
  }

  customerRegister(customer) {
    let URL = Endpoints.customer.register;
    return this._http.post(URL, customer)
  }
}
