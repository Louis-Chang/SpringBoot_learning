package com.louis.springbootdemo.web;

import com.louis.springbootdemo.domain.Book;
import com.louis.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BookApp {
    @Autowired //要注入
    BookService bookService;

    // 簡易查詢
    // 獲取讀書清單列表
    @GetMapping(value = "/books")
    public Page<Book> getAll(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        //return bookService.findAll();
        return bookService.findAllByPage(pageable);
    }
    //獲取一條書單字料
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookService.findOne(id);
    }
    //建立一筆新資料
    @PostMapping("/books")
    public Book post(Book book) {
        /*Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setStatus(status);
        book.setDescription(description);*/
        return bookService.save(book);
    }
    //更新一筆書單資料
    @PutMapping("/books")
    public Book update(@RequestParam long id, @RequestParam String name, @RequestParam String author, @RequestParam String description, @RequestParam int status) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setStatus(status);
        book.setDescription(description);
        return bookService.save(book);
    }
    //刪除一筆資料
    @DeleteMapping("/books/{id}")
    public void deleteOne(long id) {
        bookService.delete(id);
    }


    //複雜查詢
    //根據作者查詢書單列表
    @PostMapping("/books/by") //名字不要跟前面重複
    public int findBy(@RequestParam long id, @RequestParam int status, @RequestParam long uid) {
        //return bookService.findByAuthor(author);
        //return bookService.findByAuthorAndStatus(author, status);
        //return bookService.findByDescriptionContains(description);
        //return bookService.findByJPQL(len);
        //return bookService.updateByJPQL(status, id);
        //return bookService.deleteByJPQL(id);
        return bookService.deleteAndUpdate(id, status, uid);
    }

}
