package com.zzd.bookmanagersystem.service;

import com.zzd.bookmanagersystem.common.dto.BookDto;
import com.zzd.bookmanagersystem.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：福尔摩东
 * @since 2020-11-23
 */
public interface BookService extends IService<Book> {
	public Book addCover(BookDto book, MultipartFile photo);

}
