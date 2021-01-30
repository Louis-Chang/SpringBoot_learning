package com.louis.springbootdemo.service;

import com.louis.springbootdemo.domain.Book;
import com.louis.springbootdemo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //簡易查詢（新增查詢修改刪除）
    //查詢所有書單列表
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    //分頁查詢書單列表
    public Page<Book> findAllByPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
    //查詢一筆資料
    public Book findOne(long id) {
        return bookRepository.findById(id).orElse(null);
    }
    //新增、更新一個書單，利用Spring 裡面的save方法
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public void delete(long id) {
        bookRepository.deleteById(id);
    }


    //複雜查詢
    //根據作者查詢書單列表
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    //根據作者與status查詢
    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }
    //以...為description結尾
    public List<Book> findByDescriptionContains(String des) {
        return bookRepository.findByDescriptionContains(des);
    }


    //自定義查詢
    //依照length
    public List<Book> findByJPQL(int len) {
        return bookRepository.findByJPQL(len);
    }


    //自定義更新
    //update
    @Transactional
    public int updateByJPQL(int status, long id) {
        return bookRepository.updateByJPQL(status, id);
    }
    //delete
    public int deleteByJPQL(long id) {
        return bookRepository.deleteByJPQL(id);
    }


    //事務處理
    //測試事務操作方法
    @Transactional
    public int deleteAndUpdate(long id, int status, long uid) {
        int dcount = bookRepository.deleteByJPQL(id);
        int ucount = bookRepository.updateByJPQL(status, uid);
        return dcount + ucount;
    }
}
