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

  logOutUserId() {
    sessionStorage.removeItem('userId')
  }
  setUserName(userName){
    sessionStorage.setItem('userName',userName)
    console.log(userName)
    return true;
  }

  getUserName() {
    let user = sessionStorage.getItem('userName')
    console.log(user);
    return user;
    
  }

  removeUserName() {
    sessionStorage.removeItem('userName')
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('userName')
    console.log(!(user === null))
    return !(user === null)
  }

  logOutUserName() {
    sessionStorage.removeItem('userName')
  }
}