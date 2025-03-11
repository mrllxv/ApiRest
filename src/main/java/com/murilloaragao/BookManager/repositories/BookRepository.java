package com.murilloaragao.BookManager.repositories;

import com.murilloaragao.BookManager.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//Contato com o banco de dados (H2) fazendo as acões
public interface BookRepository extends JpaRepository<Book,Long> {
}
