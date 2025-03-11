package com.murilloaragao.BookManager.services;

import com.murilloaragao.BookManager.entities.Book;
import com.murilloaragao.BookManager.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Regras de Negócio da Aplicação(Comunica com os dados vindo do Repositorio)
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //salva o objeto no banco
    public Book create(Book obj) {
        return bookRepository.save(obj);
    }

    //deleta do banco
    public void delete(Long id){
        bookRepository.deleteById(id);
    }
    //buscar por Id
    public Book getId(Long id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.get();
    }

    //Lista de livros completa dentro do banco
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    //atualizacao de livros
    public Book update(Book obj){
        Optional<Book> newObj = bookRepository.findById(obj.getId());
        updateBook(newObj, obj);
        return bookRepository.save(newObj.get());
    }

    //atualizando o nome do livro
    private void updateBook(Optional<Book> newObj, Book obj) {
        newObj.get().setName(obj.getName());
    }
}
