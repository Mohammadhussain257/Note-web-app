import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AppService} from '../shared/app-service';
import {AuthenticationService} from '../shared/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = '';
  password = '';
  invalidLogin = false;
  constructor(private router: Router, private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }
checkLogin() {
  (this.authenticationService.authenticate(this.username, this.password).subscribe(
    res => {
      this.router.navigate(['notes']);
      this.invalidLogin = false;
      console.log('Inside response-----> Username: ' + this.username, 'Password : ' + this.password);
    },
    err => {
      this.invalidLogin = true;
      console.log('Inside error--> Username: ' + this.username,  'Password: ' + this.password);
    }
  ));
}
}
