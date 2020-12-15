import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { formatDate } from "@angular/common";
import { registerLocaleData } from '@angular/common';
import localeES from "@angular/common/locales/es";
registerLocaleData(localeES, "es");
@Injectable({
  providedIn: 'root'
})
export class BookService {

  urlBooks = 'http://127.0.0.1:3000/books';
  book: any;
  constructor(private Http: HttpClient) { }
  listBooks() {
    return this.Http.get(this.urlBooks + '/list');
  }
  createBook(myform) {
    const format = 'yyyy-MM-dd';
    const myDate = myform.value.bookreleasedate;
    const locale = 'en-TN';
    const formattedDate = formatDate(myDate,format,locale);
    this.book = {
      'title': myform.value.booktitle,
      'author': myform.value.bookauthor,
      'price': myform.value.bookprice,
      'releasedate':formattedDate
    }
    return this.Http.post(this.urlBooks + '/add', this.book);
  }
  updateBook(myObj) {
    return this.Http.put(this.urlBooks + '/' + myObj['id'], myObj);
  }
  deleteBook(myObj) {
    return this.Http.delete(this.urlBooks + '/' + myObj['id'], myObj)
  }
  getBook(id) {
    return this.Http.get(this.urlBooks + '/' + id)
  }
}
