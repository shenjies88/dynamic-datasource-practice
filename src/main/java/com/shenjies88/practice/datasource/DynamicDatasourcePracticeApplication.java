package com.shenjies88.practice.datasource;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class DynamicDatasourcePracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourcePracticeApplication.class, args);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/insert-user")
	public void insertUser() {
		jdbcTemplate.execute("INSERT INTO user (name,age) VALUES ('张三',12)");
	}

	@GetMapping("/get-user")
	public List<Map<String, Object>> getUser() {
		return jdbcTemplate.queryForList("SELECT * FROM user");
	}

	@DS("slave")
	@GetMapping("/get-member")
	public List<Map<String, Object>> getMember() {
		return jdbcTemplate.queryForList("SELECT * FROM member");
	}
}
