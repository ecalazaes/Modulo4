import { EmpresaService } from './../../services/empresa.service';
import { Component, inject, OnInit } from '@angular/core';
import { initFlowbite } from 'flowbite';

@Component({
  selector: 'app-empresas',
  standalone: true,
  imports: [],
  templateUrl: './empresas.component.html',
  styleUrl: './empresas.component.css'
})
export class EmpresasComponent implements OnInit {

  EmpresaResponse: any;
  private EmpresaService = inject(EmpresaService)

  ngOnInit(): void {
    initFlowbite();
    this.getAllEmpresas();
  }

  getAllEmpresas(): void {
    this.EmpresaService.getAllEmpresas().subscribe({
      next: (response:any) => {
        response && (this.EmpresaResponse = response);
        console.log(this.EmpresaResponse)
      },
      error: (error) => console.log(error),
    });
  }
}
