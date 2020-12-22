package com.zzd.bookmanagersystem.service.impl;

import com.zzd.bookmanagersystem.common.dto.BookDto;
import com.zzd.bookmanagersystem.entity.Book;
import com.zzd.bookmanagersystem.mapper.BookMapper;
import com.zzd.bookmanagersystem.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：福尔摩东
 * @since 2020-11-23
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


	public Book addCover(BookDto book,MultipartFile photo) {
		String path = "D:/360MoveData/Users/张振东/Desktop/图书管理系统/bookmanagersystem/src/main/resources/static/asserts/img/"; // 保存路径
		String fileName = null;
		if (!photo.isEmpty()) {
			fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
			System.out.println(suffix);
			if (!suffix.equals(".jpg") || !suffix.equals(".png") || !suffix.equals(".gif")) {

			}
			try {
				// Spring提供了文件操作类FileCopyUtils
				FileCopyUtils.copy(photo.getInputStream(), new FileOutputStream( path + fileName + suffix));
				fileName = "http://www.nucsell.com:8080/asserts/img/" + fileName + suffix;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//					return dealResultMap(false, "上传失败");
			}
		}
		System.out.println(path);
		Book book1 = new Book();
		book1.setId(book.getId());
		book1.setName(book.getName());
		book1.setPrice(book.getPrice());
		book1.setCover(fileName);
		book1.setDescription(book.getDescription());
		book1.setCid(book.getCid());

		return  book1;
	}


}
