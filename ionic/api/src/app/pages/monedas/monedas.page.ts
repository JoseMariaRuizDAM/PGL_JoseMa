import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-monedas',
  templateUrl: './monedas.page.html',
  styleUrls: ['./monedas.page.scss'],
})
export class MonedasPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  filtrarFormulario(formulario:NgForm){
    let controles = formulario.form.controls;
    console.log(controles['inputidmoneda'].value);
    console.log(controles['inputnombremoneda'].value);
  }

}
