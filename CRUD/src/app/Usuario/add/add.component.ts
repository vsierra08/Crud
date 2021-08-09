import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/Model/Usuario';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private router: Router, private service: ServiceService) { }

  ngOnInit(){
  }
  Guardar(usuario: Usuario) {
    this.service.createUsuario(usuario)
      .subscribe(data => {
        alert("¡Se Agrego con Exito!");
        this.router.navigate(["listar"]); 
      })
  }
}
