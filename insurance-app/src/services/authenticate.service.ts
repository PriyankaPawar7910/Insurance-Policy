import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  authenticate(username, password) {
    if (username === "john@gmail.com" && password === "JohnDoe@123") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }


}