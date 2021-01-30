package com.louis.springbootdemo.web;

import com.louis.springbootdemo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/api/v2")
public class HelloController {

    /*@Autowired
    private Book book;*/

    //@RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping("/say")
    public String hello() {
        return "hello fuckkk";
    }

    @GetMapping("/books")
    //@ResponseBody
    public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size", defaultValue = "1") int size) {
        Map<String, Object> book = new HashMap<>();
        book.put("name", "OKR");
        book.put("author", "John");
        book.put("isbn", "66666");

        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "0 to 1");
        book2.put("author", "Smith");
        book2.put("isbn", "77777");

        List<Map> contents = new ArrayList<Map>();
        contents.add(book);
        contents.add(book2);

        Map<String, Object> pagemap = new HashMap<>();
        pagemap.put("page", page);
        pagemap.put("size", size);
        pagemap.put("contents", contents);

        return pagemap;
    }

    @GetMapping("/books/{id}")
    public Object getOne(@PathVariable long id) {

        return null;
    }

    @PostMapping("/books")
    public Object post(@RequestParam String name, String author, String isbn) {
        Map<String, Object> book = new HashMap<String, Object>();
        book.put("name", name);
        book.put("author", author);
        book.put("isbn", isbn);
        return book;
    }
}
