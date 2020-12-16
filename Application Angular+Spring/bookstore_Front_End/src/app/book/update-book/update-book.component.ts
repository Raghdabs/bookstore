import { Component, OnInit } from '@angular/core';
import { BookService } from '../BookService/book.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { formatDate } from "@angular/common";
import { registerLocaleData } from '@angular/common';
import localeES from "@angular/common/locales/es";
@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

    id :any;
    bookToUpdate:any;
    title:any;
    author:any;
    price:any;
    releasedate :any;
  
  constructor(private service: BookService, private router: Router, private route: ActivatedRoute) { }
  ngOnInit() {
    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('id');
      }
    );
    this.bookToUpdate = this.service.getBook(this.id).subscribe(
      response => {        
        this.title = response["title"];        
        this.author = response["author"];       
        this.price = response["price"];       
        this.releasedate= response["releasedate"];
        
        //this.relasedate = formatDate(this.date,'yyyy-MM-dd','en-TN');
      }
    );
    
  }
  updateBook() {
    this.bookToUpdate = {
      'title':this.title,
      'author': this.author,
      'price': this.price,
      'releasedate':formatDate(this.releasedate,'yyyy-MM-dd','en-TN'),
      'id': this.id
    }
    
    this.service.updateBook(this.bookToUpdate).subscribe(
      response => {
        console.log(response);
      }
    );
  }
}
