import { HttpHandler, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';


export const authInterceptor : HttpInterceptorFn = (req, next) =>{

    const token = localStorage.getItem('token');

    // If clone exists -> clone request and add header 
    const authReq = token ? req.clone({
      setHeaders: {Authorization: `Bearer ${token}`},}) : req;

  // Send the (modified or unmodified request to the next interceptor or to 
  // the backend,  handle() continue to request pipeline  
    return next(authReq);
  
}
