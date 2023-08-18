import { Router } from '@angular/router';
import { AuthorizationService } from './../../../service/authorization.service';
import { Component } from '@angular/core';
import { NbThemeService } from '@nebular/theme';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent {

  constructor(
    private authorizationService: AuthorizationService,
     private router: Router,
     private themeService: NbThemeService,
     ){}

  ngOnInit(){
    this.authorizationService.logout().subscribe(result => {
      localStorage.clear();
      this.router.navigate(['/login']);
      //this.themeService.changeTheme('default');
    });
  }
}
