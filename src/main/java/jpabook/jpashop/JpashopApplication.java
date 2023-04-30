package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {

		Hello hello = new Hello();
		hello.setData("init Hello");
		String a = hello.getData();
		System.out.println(a);

		SpringApplication.run(JpashopApplication.class, args);
	}

}
