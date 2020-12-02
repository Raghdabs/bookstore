package com.vermeg.ams.repositories;
//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.ams.entities.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}