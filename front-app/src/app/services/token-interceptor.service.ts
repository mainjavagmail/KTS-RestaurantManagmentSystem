import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { HttpRequest } from '@angular/common/http';
import { HttpHandler } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpEvent } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token: string|null = "";
    if(sessionStorage.getItem("token")){
      token = sessionStorage.getItem("token");
    }
    let str = 'Bearer ' + token;
    request = request.clone({
      setHeaders: {
        
        'Authorization': str
      }
    });
    return next.handle(request);
  }
}
