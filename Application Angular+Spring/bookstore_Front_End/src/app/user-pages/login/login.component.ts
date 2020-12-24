import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  invalidLogin = false;
 
  successMessage = "Authentication success";
  errorMessage = "Invalide username or password";
  constructor(private router: Router, public loginservice: AuthenticationService) { }
  ngOnInit() {
  }
  checkLogin() {
    (this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {
      this.router.navigate(['dashboard'])
      this.invalidLogin = false
    },
    error => {
    this.invalidLogin = true
    }
    )
    );
  }
}
