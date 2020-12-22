package com.zzd.bookmanagersystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzd.bookmanagersystem.common.lang.Result;
import com.zzd.bookmanagersystem.entity.User;
import com.zzd.bookmanagersystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 关注公众号：福尔摩东
 * @since 2020-12-19
 */
@Controller
@RequestMapping("/user")
@Api("用户控制类")
public class UserController {
	@Autowired
	UserService userService;


	Result result = null;

	@ApiOperation("用户登录")
	@PostMapping("/login")
	@ResponseBody
	public Result login(@ApiParam("用户账号") @RequestParam("username") String username, @ApiParam("用户密码") @RequestParam("password") String password, HttpSession session) {
		User user = userService.getOne(new QueryWrapper<User>().eq("username", username).eq("password", password));

		if (user != null && user.getAuthority() == 1) {
//			为防止表单重复提交，可以重定向到主页
			session.setAttribute("user", user);
			return Result.succ("账号密码正确");
		} else {
			return Result.fail("用户名账号或者密码错误");
		}
	}

	@ApiOperation("登出")
	@GetMapping("/loginout")
	public String loginOut(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/index.html";
	}

	@ApiOperation("用户或者管理员注册")
	@PostMapping("/regist")
	@ResponseBody
	public Result regist(@ApiParam("用户详细信息") User user) {
		if (user != null) {
				userService.save(user);
				return Result.succ("注册成功");

		} else {
			return Result.fail("注册失败，请联系管理员");
		}
	}
	@ApiOperation("欢迎用户")
	@GetMapping("/findUser")
	@ResponseBody
	public Object finsUser(HttpServletRequest req){
		Object user = req.getSession().getAttribute("user");
			return user;
	}



	@ApiOperation("查询所有用户返回列表页面")
	@GetMapping("/users")
	public String list(Model model) {
		Collection<User> all = userService.list();
		model.addAttribute("users", all);
		return "user/list";
	}

	@ApiOperation("到用户添加页面")
	@GetMapping("/user")
	public String toAddPage() {
		return "user/add";
	}


	//	springmvc自动将请求参数和入参对象的属性一一对应：要求请求参数的名字和javabean入参的对象里面的属性名是一样的
	@ApiOperation("用户添加")
	@PostMapping("/user")
	public String addUser(@ApiParam("实体类") User user) {
		userService.save(user);
//		redirect：表示重定向到一个地址  / 表示当前项目路径
//		forward:表示转发一个地址
		return "redirect:/user/users";
	}

	@ApiOperation("获取单个用户的信息")
	@GetMapping("/user/{id}")
	public String toEditPage(@ApiParam("用户id") @PathVariable("id") Integer id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
//		回到修改页面（add是一个修改添加二合一的）
		return "user/add";
	}
	@ApiOperation("修改用户信息")
	@PutMapping("/user")
	public String updateUser(@ApiParam("实体类") User user) {
		userService.updateById(user);
		return "redirect:/user/users";
	}
	@ApiOperation("删除用户信息")
	@DeleteMapping("/user/{id}")
	public String deleteUser(@ApiParam("用户id") @PathVariable("id") Integer id) {
		userService.removeById(id);
		return "redirect:/user/users";
	}
}

