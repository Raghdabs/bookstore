import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { ListBookComponent } from'./list-book/list-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';


const routes: Routes = [
   { path: "", pathMatch: "full", redirectTo: "app-navbar" },
   { path: "listBook", component: ListBookComponent },
   { path: "addBook", component: AddBookComponent },
   { path: "updateBook/:id", component: UpdateBookComponent },
  
];

@NgModule({
   imports: [RouterModule.forRoot(routes)],
   exports: [RouterModule]
})
export class AppRoutingModule { }