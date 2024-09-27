import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class DataService {
  private baseUrl = 'http://localhost:8080/usuarios'; // Substituir pela url do Endpoint

  constructor(private http: HttpClient) {}

  // Método genérico para fazer buscas
  private buscarPorFiltro(endpoint: string, paramsObj: { [key: string]: string }): Observable<any> {
  let params = new HttpParams({ fromObject: paramsObj }); // Constrói os parâmetros dinamicamente
  return this.http.get(`${this.baseUrl}/${endpoint}`, { params });
}

  // Método para buscar por nome
  buscarPorNome(filtroNome: string): Observable<any> {
    return this.buscarPorFiltro('nome', { nome: filtroNome });
  }

  // Método para buscar por idade
  buscarPorIdade(filtroIdade: number): Observable<any> {
    return this.buscarPorFiltro('idade', { idade: filtroIdade.toString() });
  }
}
