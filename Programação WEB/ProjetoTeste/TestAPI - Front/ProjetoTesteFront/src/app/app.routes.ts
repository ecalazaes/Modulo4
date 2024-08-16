import { Routes } from '@angular/router';
import { EmpresasComponent } from './components/empresas/empresas.component';

export const routes: Routes = [
  {
    path:'',
    redirectTo:'empresas',
    pathMatch:'full'
  },
  {
    path: 'empresas',
    component: EmpresasComponent
  }
]
