import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../Model/Usuario';

@Injectable()

export class ServiceService {

  constructor(private http: HttpClient) { }

  Url = 'http://localhost:8080/Desarrollo/Desarrollo/test';

  getUsuarios() {
    return this.http.get<Usuario[]>(this.Url);
  }
  createUsuario(usuario: Usuario) {
    return this.http.post<Usuario>(this.Url, usuario);
  }
}
