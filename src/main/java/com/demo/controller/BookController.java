package com.demo.controller;

import com.demo.domain.Book;
import com.demo.model.Response;
import com.demo.service.BookService;
import com.demo.utils.validatorgroup.SaveBookCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 书库controller
 */
@Api(value = "书库controller")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 图书入库
     *
     * @param book
     * @return
     */
    @ApiOperation(value = "图书入库")
    @PostMapping
    public Response saveBoob(@RequestBody @Validated(value = {SaveBookCheck.class}) Book book) {
        bookService.saveBook(book);
        return new Response();
    }

    @GetMapping
    public String test() {
        return "test";
    }

}
