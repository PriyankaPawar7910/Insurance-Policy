import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticateService {

  constructor() { }

  setUserId(userId) {
      sessionStorage.setItem('userId', userId)
      console.log(userId)
      return true;
  
  }

  getUserId() {
    let user = sessionStorage.getItem('userId')
    console.log(user);
    return user;
    
  }

  removeUserId() {
    sessionStorage.removeItem('userId')
  }
}