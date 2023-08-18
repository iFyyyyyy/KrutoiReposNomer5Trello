import { Router } from '@angular/router';
import { AuthorizationService } from './../../../service/authorization.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent {

  constructor(private authorizationService: AuthorizationService, private router: Router){}

  ngOnInit(){
    this.authorizationService.logout().subscribe(result => {
    localStorage.removeItem("Theme");
    localStorage.removeItem("UserId");
    localStorage.removeItem("Username");
    localStorage.removeItem("isLoggedIn");
    this.router.navigate(['/login']);
    });
  }
}
