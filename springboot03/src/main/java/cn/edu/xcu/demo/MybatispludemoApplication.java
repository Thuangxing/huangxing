package cn.edu.xcu.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.edu.xcu.demo.entity.Book;
import cn.edu.xcu.demo.entity.Type;
import cn.edu.xcu.demo.service.impl.BookServiceImpl;
import cn.edu.xcu.demo.service.impl.TypeServiceImpl;

@SpringBootApplication

public class MybatispludemoApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext contex=SpringApplication.run(MybatispludemoApplication.class, args);
		BookServiceImpl bookServiceImpl=contex.getBean(BookServiceImpl.class);
		TypeServiceImpl typeServiceImpl=contex.getBean(TypeServiceImpl.class);
//		List<Book> books=bookServiceImpl.list();
//		for (Book book : books) {
//			System.out.println(book);	
//		}
		IPage<Type> toWhichPage1=new Page(2,1);
		QueryWrapper<Type> wrepper1=new QueryWrapper<>();
		wrepper1.gt("id", 1);
		wrepper1.like("name", "wen");
		IPage<Type> resultPage1=typeServiceImpl.page(toWhichPage1,wrepper1);
		System.out.println(resultPage1.getRecords());
		System.out.println(resultPage1.getPages());
		
		System.out.println("------------------------------------------------------");
		IPage<Book> toWhichPage=new Page(5,3);
		QueryWrapper<Book> wrapper=new QueryWrapper<>();
		wrapper.gt("id", 2);
		wrapper.like("name","9");
		IPage<Book> resultPage=bookServiceImpl.page(toWhichPage,wrapper);
		System.out.println(resultPage.getRecords());
		System.out.println(resultPage.getPages());
		
		
	}

}
