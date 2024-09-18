import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrlNome = 'http://localhost:8080/usuarios/nome'; // Substituir pela url do Endpoint
  private apiUrlIdade = 'http://localhost:8080/usuarios/idade'; // Substituir pela url do Endpoint

  constructor(private http: HttpClient) {}

  // Método para buscar por nome
  buscarPorNome(filtroNome: string): Observable<any>{
    let params = new HttpParams().set('nome', filtroNome);
    return this.http.get(this.apiUrlNome, { params });
  }

  // Método para buscar por idade
  buscarPorIdade(filtroIdade: number): Observable<any>{
    let params = new HttpParams().set('idade', filtroIdade.toString());
    return this.http.get(this.apiUrlIdade, { params })
  }
}
