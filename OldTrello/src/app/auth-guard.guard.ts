import { Injectable } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthorizationService } from './service/authorization.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(private authorizationService: AuthorizationService,  private router: Router){}

  canActivate(): boolean{
        if(!localStorage.getItem('isLoggedIn')){

          this.router.navigate(['login']);
          return false;
      }
          return true;
    }

}