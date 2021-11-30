import { Injectable } from '@angular/core';
import {
    HttpRequest,
    HttpHandler,
    HttpInterceptor,
    HttpEvent
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';


@Injectable()
export class TokenInterceptor implements HttpInterceptor {
    constructor(public auth: AuthService) { }
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        throw new Error('Method not implemented.');
    }
    /* intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
 
         if (this.auth.tokenIsPresent()) {
             request = request.clone({
                 setHeaders: {
                     Authorization: `Bearer ${this.auth.getToken()}`
                 }
             });
         }
         return next.handle(request);
     }*/
}