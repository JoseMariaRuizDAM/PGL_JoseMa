import { MonedasService } from 'src/app/services/monedas.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

interface Moneda{
  idmoneda: number;
  nombre: string;
  pais: string;
  historicos: Historico[];
}

interface Historico{
  idhistoricocambioeuro: number;
  fecha: string;
  equivalenteeuro: number;
}

@Component({
  selector: 'app-monedas',
  templateUrl: './monedas.page.html',
  styleUrls: ['./monedas.page.scss'],
})
export class MonedasPage implements OnInit {

  constructor(private monedasService:MonedasService) { }

  ngOnInit() {
    this.monedasService
    .getMonedas()
    .subscribe((datos:any) =>{
      this.monedasFiltradas = datos;
    })
  }

  monedasFiltradas!: Moneda[]; //Este atributo se usa en el html para *ngFor

  filtrarFormulario(formulario:NgForm){
    let controles = formulario.form.controls;
    //console.log(controles);
    console.log(controles['inputidmoneda'].value);
    console.log(controles['inputnombremoneda'].value);
    if(controles['inputidmoneda'].value > 0){
      this.monedasService
        .getMonedaId(controles['inputidmoneda'].value)
        .subscribe((datos: any) =>{
          this.monedasFiltradas = [datos];
        });
    }
  }

}
