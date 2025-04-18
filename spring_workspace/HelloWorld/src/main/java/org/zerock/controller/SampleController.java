package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.dto.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	// return 값이 void 이면 주소와 같은 이름의 jsp로 이동
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println(dto);
		return "/sample/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		return "/sample/ex02";
	}
	
	
	// @ModelAttribute("page") 는 model.addAttribut("page", page)와 같은 역활
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page, Model model) {

		// request.setAtrribute()와 같은역활
		model.addAttribute("dto", dto);
		
		System.out.println("dto: " + dto);
		System.out.println("page: " + page);

		return "/sample/ex04";
	}
	
	
	@GetMapping("/ex05")
	public String ex05() {
		return "redirect:/sample/basic";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto; //dto가 json 형태로 변환돼서 view
	}
	
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		String msg="{\"name\":\"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {

		files.forEach(file -> {
			log.info("----------------------------------");
			log.info("name:" + file.getOriginalFilename());
			log.info("size:" + file.getSize());

		});
	}
	
	
	
	
}
