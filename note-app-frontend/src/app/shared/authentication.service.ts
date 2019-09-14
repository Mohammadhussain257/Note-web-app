import { Injectable } from '@angular/core';
import {AppService} from './app-service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../model/user';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private USER_URL = 'http://localhost:8080/user/api';
  private VALIDATE_LOGIN = '/validateLogin';

  constructor(private http: HttpClient) { }

  authenticate(username, password): Observable<User> {
    const headers = new HttpHeaders({Authorization: 'Basic' + btoa(username + ':' + password) });
    return this.http.get<User>(this.USER_URL + this.VALIDATE_LOGIN, {headers}).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);
          return userData;
        }
      )
    );
  }

  isUserLogin() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username');
  }
}
