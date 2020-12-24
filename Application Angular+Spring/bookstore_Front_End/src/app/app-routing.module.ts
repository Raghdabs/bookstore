import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBookComponent } from './book/add-book/add-book.component';
import { ListBookComponent } from './book/list-book/list-book.component';
import { UpdateBookComponent } from './book/update-book/update-book.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGaurdService } from './services/auth-gaurd-service.service';
import { LoginComponent } from './user-pages/login/login.component';
import { LogoutComponent } from './user-pages/logout/logout.component';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent,canActivate: [AuthGaurdService] },
  { path: 'basic-ui', loadChildren: () => import('./basic-ui/basic-ui.module').then(m => m.BasicUiModule) ,canActivate: [AuthGaurdService]},
  { path: 'charts', loadChildren: () => import('./charts/charts.module').then(m => m.ChartsDemoModule) ,canActivate: [AuthGaurdService]},
  { path: 'forms', loadChildren: () => import('./forms/form.module').then(m => m.FormModule),canActivate: [AuthGaurdService] },
  { path: 'tables', loadChildren: () => import('./tables/tables.module').then(m => m.TablesModule) ,canActivate: [AuthGaurdService]},
  { path: 'icons', loadChildren: () => import('./icons/icons.module').then(m => m.IconsModule),canActivate: [AuthGaurdService] },
  { path: 'icons', loadChildren: () => import('./icons/icons.module').then(m => m.IconsModule),canActivate: [AuthGaurdService] },
  { path: 'general-pages', loadChildren: () => import('./general-pages/general-pages.module').then(m => m.GeneralPagesModule),canActivate: [AuthGaurdService] },
  { path: 'apps', loadChildren: () => import('./apps/apps.module').then(m => m.AppsModule) ,canActivate: [AuthGaurdService]},
  { path: 'user-pages', loadChildren: () => import('./user-pages/user-pages.module').then(m => m.UserPagesModule) },
  { path: 'error-pages', loadChildren: () => import('./error-pages/error-pages.module').then(m => m.ErrorPagesModule) ,canActivate: [AuthGaurdService]},
  { path: "listBook", component: ListBookComponent,canActivate: [AuthGaurdService] },
  { path: "addBook", component: AddBookComponent,canActivate: [AuthGaurdService] },
  { path: "updateBook/:id", component: UpdateBookComponent ,canActivate: [AuthGaurdService]},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
