package com.zzd.bookmanagersystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzd.bookmanagersystem.entity.User;
import com.zzd.bookmanagersystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 *
 * @author 关注公众号：福尔摩东
 * @since 2020-11-23
 */
@Controller
@Api("管理员控制类")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserService userService;
	@ApiOperation("管理员登录")
	@PostMapping("/login")
	public String login(@ApiParam("管理员账号") @RequestParam("username") String username, @ApiParam("管理员密码")@RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
		User admin = userService.getOne(new QueryWrapper<User>().eq("username", username).eq("password", password));
		if (admin != null&&admin.getAuthority()==0) {
//			为防止表单重复提交，可以重定向到主页
			session.setAttribute("loginUser", username);
			return "redirect:/main.html";
		} else {
			map.put("msg", "用户名密码错误");
			return "admin";

		}
	}
	@ApiOperation("登出")
	@GetMapping("/loginout")
	public String loginOut(HttpSession session){
		session.removeAttribute("loginUser");
		return "redirect:/admin.html";
	}
}
