import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }
  authenticate(username:any, password:any) {
    // if (username === "aaa" && password === "123") {
    // sessionStorage.setItem('username', username)
    // return true;
    // } else {
    // return false;
    // }
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
 return this.httpClient.get('http://localhost:3000/basicauth', { headers }).pipe
(
 map(
 userData => {
 sessionStorage.setItem('username', username);
 sessionStorage.setItem('password', password);
 console.log(username + " " + password);
 let authString = 'Basic ' + btoa(username + ':' + password);
 sessionStorage.setItem('basicauth', authString);

 return userData;
 }
 )
 );
    }
    isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
    }
    logOut() {
    sessionStorage.removeItem('username')
    }
   }