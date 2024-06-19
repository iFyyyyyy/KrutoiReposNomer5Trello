import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NbThemeService } from '@nebular/theme';
import { User } from 'src/app/Entities/User';
import { AuthorizationService } from 'src/app/service/authorization.service';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.scss']
})
export class RegistrationPageComponent {
  user: User;

  constructor(
    private authorizationService: AuthorizationService,
    private router: Router,
    private themeService: NbThemeService,
    ){
    this.user = new User();
    this.user.username = "";
    this.user.password = "";
  }


  register(){

    this.authorizationService.register(this.user.username,this.user.password).subscribe(
        data => {
          if (data){
             // this.router.navigate(["home"]);
             console.log("user registered");

          }
        },
      );
  }
}
