package com.zzd.bookmanagersystem.controller;


import com.zzd.bookmanagersystem.common.dto.BookDto;
import com.zzd.bookmanagersystem.entity.Book;
import com.zzd.bookmanagersystem.entity.Category;
import com.zzd.bookmanagersystem.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * @since 2020-12-19
 */
@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@ApiOperation("找到书的类型集合")
	@GetMapping("/category/findAll")
	@ResponseBody
	public List<Category> finsAll() {
		List<Category> cs = categoryService.list();
		return cs;
	}
	


	@ApiOperation("查询书籍类型")
	@GetMapping("categorys")
	public String list(Model model) {
		Collection<Category> all = categoryService.list();
		model.addAttribute("categorys", all);
		return "category/list";
	}

	@ApiOperation("到书籍类型添加页面")
	@GetMapping("category")
	public String toAddPage() {
		return "category/add";
	}


	//	springmvc自动将请求参数和入参对象的属性一一对应：要求请求参数的名字和javabean入参的对象里面的属性名是一样的
	@ApiOperation("书籍类型添加")
	@PostMapping("category")
	public String addBookType(@ApiParam("书籍类") Category category) {

		categoryService.save(category);
//		redirect：表示重定向到一个地址  / 表示当前项目路径
//		forward:表示转发一个地址
		return "redirect:/categorys";
	}

	@ApiOperation("获取单个书籍类型的信息")
	@GetMapping("category/{id}")
	public String toEditPage(@ApiParam("书籍类型id") @PathVariable("id") Integer id, Model model) {
		Category category = categoryService.getById(id);
		model.addAttribute("category", category);


//		回到修改页面（add是一个修改添加二合一的）

		return "category/add";
	}
	@ApiOperation("修改书籍类型信息")
	@PutMapping("category")
	public String updateBookType( @ApiParam("书籍" +
			"类型类")Category category) {
		categoryService.updateById(category);
		return "redirect:/categorys";
	}
	@ApiOperation("删除书籍类型信息")
	@DeleteMapping("category/{id}")
	public String deleteBookType(@ApiParam("书籍类型id") @PathVariable("id") Integer id) {
		categoryService.removeById(id);
		return "redirect:/categorys";
	}

}
