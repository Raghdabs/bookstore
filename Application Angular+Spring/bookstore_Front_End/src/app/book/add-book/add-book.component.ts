import { Component, OnInit } from '@angular/core';
import { BookService } from '../BookService/book.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  provider: any;
 constructor(private service: BookService, private router : Router) { }
 ngOnInit() {
 }
 createBook(myform) {

  this.service.createBook(myform).subscribe(
  response => {
  console.log(response);
  }
  );
 
  this.router.navigate(['listBook']);
  }
}
