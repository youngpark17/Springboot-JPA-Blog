package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 - > 데이터 응답.
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	//인터넷 브라우저 요청은 무조건 get
	// http://localhost:8080/http/get(select)
	
	@GetMapping("/http/lombok")
	public  String lombokTest() {
		Member m = Member.builder().username("ssar").password("1234").email("mduddns@naver.com").build();
		System.out.println(TAG+"getter : "+m.getId());
		m.setId(5000);
		System.out.println(TAG+"setter"+m.getId());
		return "lombok 테스트 완료:";
	}
	@GetMapping("/http/get")
	public String getTest(Member m) {

		return "get 요청"+m.getId()+","+m.getUsername()+","+m.getPassword();
	}
	//insert
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		
		
		
		return "post 요청"+m.getId()+","+m.getUsername()+","+m.getPassword();
	}
	
	//update
	@PutMapping("/http/put")
	public String putTest() {
		
		return "put 요청";
	}
	
	//delete
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		
		return "delete 요청";
	}
}
