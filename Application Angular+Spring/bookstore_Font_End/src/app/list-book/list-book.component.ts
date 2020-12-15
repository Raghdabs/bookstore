import { Component, OnInit } from '@angular/core';
import { BookService } from '../BookService/book.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.css']
})
export class ListBookComponent implements OnInit {

  providers: any;
  constructor(private service: BookService, private router: Router) { }
  ngOnInit() {
  this.service.listBooks().subscribe(
  response => {
  this.providers = response;
  }
  );
  }
 
  deleteProvider(myObj) {
   //console.log(this.provider);
   this.service.deleteProvider(myObj).subscribe(response => {
   console.log(response);
   this.refreshListProviders();
   })
   }
   refreshListProviders() {
   this.service.listProviders().subscribe(
   response => {
   this.providers = response;
   }
   );
   }
   updateProvider(myObj) {
   this.router.navigate(['updateProvider' + '/' + myObj['id']]);
   }

}
