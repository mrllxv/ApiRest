package com.murilloaragao.BookManager.controllers;

import com.murilloaragao.BookManager.entities.Book;
import com.murilloaragao.BookManager.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //EndPoint de inserção
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(obj));
    }

    //EndPoint Delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //EndPoint Livro pelo id
    @GetMapping(value = "{id}")
    public ResponseEntity<Book> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.getId(id));
    }

    //EndPoint todos os livros
    @GetMapping
    public ResponseEntity<List <Book>> getAll(){
        return ResponseEntity.ok().body(bookService.getAll());
    }

    //EndPoint Atualiza Livro
    @PutMapping(value ="/{id}")
    public ResponseEntity<Book> update (@PathVariable Long id, @RequestBody Book obj){
        obj.setId(id);
        return ResponseEntity.ok().body(bookService.update(obj));
    }
}
