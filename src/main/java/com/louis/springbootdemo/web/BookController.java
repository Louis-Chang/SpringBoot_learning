package com.louis.springbootdemo.web;

import com.louis.springbootdemo.domain.Book;
import com.louis.springbootdemo.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //獲取所有書單列表
    @GetMapping("/books")
    public String list(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
                       Model model) {
        //List<Book> books = bookService.findAll();
        Page<Book> page1 = bookService.findAllByPage(pageable);
        model.addAttribute("page", page1);
        return "books";
    }

    //獲取書單詳情
    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        if (book == null) {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }

    //跳轉input 提交頁面
    @GetMapping("/books/input")
    public String inputPage(Model model) {
        String message = "新增";
        model.addAttribute("book", new Book());
        model.addAttribute("message", message);
        return "input";
    }

    //跳轉到更新頁面
    @GetMapping("/books/input/{id}")
    public String inputEditPage(@PathVariable long id, Model model) {
        String message = "更新";
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        model.addAttribute("message", message);
        return "input";
    }

    //提交書單並返回
    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes, @RequestParam String message) {
        Book book1 = bookService.save(book);
        if (book1 != null) {
            attributes.addFlashAttribute("message", "《" + book1.getName() + "》" + message + "成功");
        }
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String delete(@PathVariable long id, final RedirectAttributes attributes) {
        bookService.delete(id);
        attributes.addFlashAttribute("message", "刪除成功");
        return "redirect:/books";
    }
}
