import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MonedasService {
  constructor(private http: HttpClient) { }
  getMonedas() {
    return this.http.get("http://localhost:8080/api/v1/monedas");
  }
  getMonedaId(id: number) {
    return this.http.get('http://localhost:8080/api/v1/monedas/${id}');
  }
}

