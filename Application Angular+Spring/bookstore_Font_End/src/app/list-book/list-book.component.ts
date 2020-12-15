import { Component, OnInit } from '@angular/core';
import { BookService } from '../BookService/book.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.css']
})
export class ListBookComponent implements OnInit {

  books: any;
  constructor(private service: BookService, private router: Router) { }
  ngOnInit() {
  this.service.listBooks().subscribe(
  response => {
  this.books = response;
  }
  );
  }
 
  deleteBook(myObj) {
   //console.log(this.provider);
   this.service.deleteBook(myObj).subscribe(response => {
   console.log(response);
   this.refreshListBooks();
   })
   }
   refreshListBooks() {
   this.service.listBooks().subscribe(
   response => {
   this.books = response;
   }
   );
   }
   updateBook(myObj) {
   this.router.navigate(['updateBook' + '/' + myObj['id']]);
   }

}
