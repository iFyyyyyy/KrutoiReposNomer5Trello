import { AuthorizationService } from './../../../service/authorization.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NbThemeService } from '@nebular/theme';
import { User } from 'src/app/Entities/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  user: User;

  constructor(
    private authorizationService: AuthorizationService,
    private router: Router,
    private themeService: NbThemeService,
    ){
    this.user = new User();
    this.user.username = "admin";
    this.user.password = "admin";
  }

  ngOnInit(){
    if (localStorage.getItem("isLoggedIn")){
      this.router.navigate(["home"]);
    }
  };

  login() {

    this.authorizationService.login(this.user.username,this.user.password).subscribe(
        data => {
          if (data){
              this.router.navigate(["home"]);

          }
        },
      );
  }

  register(){
    this.router.navigate(["register"]);
  };

}
