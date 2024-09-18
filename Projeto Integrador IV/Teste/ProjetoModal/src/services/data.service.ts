import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrl = 'https://api.example.com/buscar'; // Substituir pela url do Endpoint

  constructor(private http: HttpClient) {}

  // Método para buscar por nome
  buscarPorNome(filtroNome: string): Observable<any>{
    let params = new HttpParams().set('nome', filtroNome);
    return this.http.get(this.apiUrl, { params });
  }

  // Método para buscar por idade
  buscarPorIdade(filtroIdade: number): Observable<any>{
    let params = new HttpParams().set('idade', filtroIdade.toString());
    return this.http.get(this.apiUrl, { params })
  }
}
