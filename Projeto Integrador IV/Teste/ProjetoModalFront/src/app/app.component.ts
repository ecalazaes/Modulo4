// import { Component, OnInit } from '@angular/core';
// import { FormsModule } from '@angular/forms';
// import { RouterOutlet } from '@angular/router';
// import { initFlowbite } from 'flowbite';
// import { DataService } from '../services/data.service';

// @Component({
//   selector: 'app-root',
//   standalone: true,
//   imports: [RouterOutlet, FormsModule],
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css'],
// })
// export class AppComponent implements OnInit {
//   title = 'ProjetoModal';

//   filtroNome: string = '';
//   filtroIdade: number | null = null;
//   filtroSelecionado: string = 'nome'; // Inicialize com "nome" por padrão

//   constructor(private dataService: DataService) {}

//   ngOnInit(): void {
//     initFlowbite();
//   }

//   onFilterChange(event: Event): void {
//     const target = event.target as HTMLSelectElement;
//     this.filtroSelecionado = target.value; // Atualiza o filtro selecionado
//   }

//   buscar(): void {
//     if (this.filtroSelecionado === 'nome') {
//       this.buscarPorNome();
//     } else if (this.filtroSelecionado === 'idade') {
//       this.buscarPorIdade();
//     }
//   }

//   buscarPorNome(): void {
//     if (this.filtroNome) {
//       this.dataService.buscarPorNome(this.filtroNome).subscribe({
//         next: (response: any) => {
//           console.log('Dados recebidos (Nome): ', response);
//         },
//         error: (error) => console.log('Erro na requisição (Nome): ', error),
//       });
//     }
//   }

//   buscarPorIdade(): void {
//     if (this.filtroIdade) {
//       this.dataService.buscarPorIdade(this.filtroIdade).subscribe({
//         next: (response: any) => {
//           console.log('Dados recebidos (Idade): ', response);
//         },
//         error: (error) => console.log('Erro na requisição (Idade): ', error),
//       });
//     }
//   }
// }


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
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ProjetoModal';

  filtroNome: string = '';
  filtroIdade: number | null = null;
  filtroSelecionado: string = 'nome'; // Inicialize com "nome" por padrão
  resultado: any[] = []; // Array para armazenar os resultados da requisição

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    initFlowbite();
  }

  abrirModal(){
    this.filtroNome = '';
    this.filtroIdade = null;
    this.resultado = [];
  }

  buscar(): void {
    if (this.filtroSelecionado === 'nome') {
      this.buscarPorNome();
    } else if (this.filtroSelecionado === 'idade') {
      this.buscarPorIdade();
    }
  }

  onFilterChange(event: Event): void {
    const target = event.target as HTMLSelectElement;
    this.filtroSelecionado = target.value; // Atualiza o filtro selecionado
    this.filtroNome = '';
    this.filtroIdade = null;
    this.resultado = []; // Limpa os resultados quando o filtro é alterado
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
    }
  }
}
