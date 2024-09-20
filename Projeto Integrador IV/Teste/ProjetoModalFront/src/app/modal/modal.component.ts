import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-modal',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css',
})
export class ModalComponent {
  filtroNome: string = '';
  filtroIdade: number | null = null;
  filtroSelecionado: string = 'nome'; // Inicialize com "nome" por padrão
  resultado: any[] = []; // Array para armazenar os resultados da requisição

  constructor(private dataService: DataService) {}

  abrirModal() {
    this.filtroNome = '';
    this.filtroIdade = null;
    this.resultado = [];
  }

  onFilterChange(event: Event): void {
    const target = event.target as HTMLSelectElement;
    this.filtroSelecionado = target.value; // Atualiza o filtro selecionado
    this.filtroNome = '';
    this.filtroIdade = null;
    this.resultado = []; // Limpa os resultados quando o filtro é alterado
  }

  buscar(): void {
    if (this.filtroSelecionado === 'nome') {
      this.buscarPorNome();
    } else if (this.filtroSelecionado === 'idade') {
      this.buscarPorIdade();
    }
  }

  buscarPorNome(): void {
    if (this.filtroNome) {
      this.dataService.buscarPorNome(this.filtroNome).subscribe({
        next: (response: any) => {
          this.resultado = response; // Armazena os dados recebidos
        },
        error: (error) => console.log('Erro na requisição (Nome): ', error),
      });
    }
  }

  buscarPorIdade(): void {
    if (this.filtroIdade !== null) {
      this.dataService.buscarPorIdade(this.filtroIdade).subscribe({
        next: (response: any) => {
          this.resultado = response; // Armazena os dados recebidos
        },
        error: (error) => console.log('Erro na requisição (Idade): ', error),
      });
    } else {
      console.log('Filtro de idade é nulo ou indefinido');
    }
  }
}
