import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  urlBooks = 'http://127.0.0.1:3000/book';
  book: any;
  constructor(private Http: HttpClient) { }
  listBooks() {
  return this.Http.get(this.urlBooks + '/list');
  }
  createProvider(myform) {
  this.book = {
  'title': myform.value.bookTitle,
  'author': myform.value.bookAuthor,
  'price': myform.value.bookPrice,
  'releasedate': myform.value.bookReleasedate
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
