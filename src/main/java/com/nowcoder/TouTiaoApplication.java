package com.nowcoder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by AnNing on 2019/02/15
 */
@SpringBootApplication
@ComponentScan(basePackages ={"com.nowcoder"})
@MapperScan("mapping")
public class TouTiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouTiaoApplication.class, args);
	}

}

