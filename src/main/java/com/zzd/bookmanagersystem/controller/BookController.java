package com.zzd.bookmanagersystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzd.bookmanagersystem.common.dto.BookDto;
import com.zzd.bookmanagersystem.entity.Book;
import com.zzd.bookmanagersystem.service.BookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 关注公众号：福尔摩东
 * @since 2020-11-23
 */
@Controller
@Api("书籍控制类")
public class BookController {
	@PostMapping("name")
	@ApiOperation("返回书籍名称")
	public String toBook(@ApiParam("书籍名称") @RequestBody String bookname) {
		return bookname;
	}

	@Autowired
	BookService bookService;


	@ApiOperation("查询所有书籍返回列表页面")
	@GetMapping("/books")
	public String list(Model model) {
		Collection<Book> all = bookService.list();
		model.addAttribute("books", all);
		return "book/list";
	}

	@ApiOperation("到书籍添加页面")
	@GetMapping("/book")
	public String toAddPage() {
		return "book/add";
	}


	//	springmvc自动将请求参数和入参对象的属性一一对应：要求请求参数的名字和javabean入参的对象里面的属性名是一样的
	@ApiOperation("书籍添加")
	@PostMapping("/book")
	public String addBook(@ApiParam("书籍dto类") BookDto book, @ApiParam("书籍封面文件") @RequestParam(value = "cover", required = false) MultipartFile photo) {
		Book book1 = bookService.addCover(book, photo);
		System.out.println(book1);
		bookService.save(book1);
//		redirect：表示重定向到一个地址  / 表示当前项目路径
//		forward:表示转发一个地址
		return "redirect:/books";
	}

	@ApiOperation("获取单个书籍的信息")
	@GetMapping("/book/{id}")
	public String toEditPage(@ApiParam("书籍id") @PathVariable("id") Integer id, Model model) {
		Book book = bookService.getById(id);
		model.addAttribute("book", book);


//		回到修改页面（add是一个修改添加二合一的）

		return "book/add";
	}

	@ApiOperation("修改书籍信息")
	@PutMapping("/book")
	public String updateBook(@ApiParam("书籍dto类") BookDto book, @RequestParam(value = "cover", required = false) MultipartFile photo) {
		Book book1 = bookService.addCover(book, photo);
		bookService.updateById(book1);
		return "redirect:/books";
	}

	@ApiOperation("删除书籍信息")
	@DeleteMapping("/book/{id}")
	public String deleteBook(@ApiParam("书籍id") @PathVariable("id") Integer id) {
		bookService.removeById(id);
		return "redirect:/books";
	}

	@ApiOperation("查询本类型书籍返回列表页面")
	@GetMapping("/booksInC/{id}")
	@ResponseBody
	public List<Book> list(@ApiParam("书籍类型id") @PathVariable("id") Integer id) {

		List<Book> all = bookService.list(new QueryWrapper<Book>().eq("cid", id));
		return all;
	}

	@ApiOperation("查询所有书籍")
	@GetMapping("/getbooks")
	@ResponseBody
	public List<Book> getBooks() {
		List<Book> all = bookService.list();
		return all;
	}

	@ApiOperation("根据书籍类型和书籍最低价格查询书籍")
	@GetMapping("/getBooks1")
	@ResponseBody
	public List<Book> getBooksByCidAndPrice(@ApiParam("书籍类型id") Integer cid, @ApiParam("书籍价格") String price) {
		List<Book> all = bookService.list(new QueryWrapper<Book>().eq("cid", cid).gt("price", price));
		return all;
	}
}
