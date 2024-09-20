import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'ProjetoModal';

  ngOnInit(): void {
    initFlowbite();
  }

  filtroNome: string = '';
  filtroIdade: number | null = null;

  constructor(private dataService: DataService) { }

  DataResponse: any;

  // Método para buscar por nome
  buscarPorNome(): void {
    if (this.filtroNome) {
      this.dataService.buscarPorNome(this.filtroNome).subscribe({
        next: (response: any) => {
          console.log('Dados recebidos (Nome): ', response);
        },
        error: (error) => console.log('Erro na requisição (Nome): ', error),
      });
    }
  }

  // Método para buscar por idade
  buscarPorIdade(): void {
    if (this.filtroIdade !== null) {
      this.dataService.buscarPorIdade(this.filtroIdade).subscribe({
        next: (response: any) => {
          this.DataResponse = response;
          console.log('Dados recebidos (Idade): ', this.DataResponse);
        },
        error: (error) => console.log('Erro na requisição (Idade): ', error),
      });
    } else {
      console.log('Filtro de idade é nulo ou indefinido');      
    }
  }


}

