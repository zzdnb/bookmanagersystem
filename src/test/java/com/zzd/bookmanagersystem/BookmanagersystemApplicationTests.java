package com.zzd.bookmanagersystem;


import com.zzd.bookmanagersystem.entity.Book;

import com.zzd.bookmanagersystem.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookmanagersystemApplicationTests {

	@Autowired
	private BookMapper bookMapper;



	@Test
	public void test1() {
		List<Book> book= bookMapper.selectList(null);
		book.forEach(System.out::println);
	}

}
