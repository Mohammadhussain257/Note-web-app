import { Component, OnInit } from '@angular/core';
// @ts-ignore
import {AuthenticationService} from '../shared/authentication.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private loginService: AuthenticationService) { }

  ngOnInit() {
  }

}
