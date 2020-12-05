package com.demo.controller;

import com.demo.domain.Book;
import com.demo.exception.LogicException;
import com.demo.model.Response;
import com.demo.service.BookService;
import com.demo.utils.validatorgroup.SaveBookCheck;
import com.demo.utils.validatorgroup.UpdateBookCheck;
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
     * 获取图书信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取图书信息")
    @GetMapping
    public Response getBook(@RequestParam(value = "id") String id) {
        Book book = bookService.get(id);
        return new Response(book);
    }

    /**
     * 图书入库
     *
     * @param book
     * @return 返回标识
     */
    @ApiOperation(value = "图书入库")
    @PostMapping
    public Response saveBook(@RequestBody @Validated(value = {SaveBookCheck.class}) Book book) {
        bookService.saveBook(book);
        return new Response(book.getId());
    }

    /**
     * 图书信息更新
     *
     * @param book
     * @return
     */
    @ApiOperation(value = "图书信息更新")
    @PutMapping
    public Response updateBook(@RequestBody @Validated(value = {UpdateBookCheck.class}) Book book) throws LogicException {
        bookService.updateBook(book);
        return new Response();
    }

    /**
     * 删除图书
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除图书")
    @DeleteMapping
    public Response removeBook(@RequestParam(value = "id") String id) throws LogicException {
        bookService.removeBook(id);
        return new Response();
    }

}
