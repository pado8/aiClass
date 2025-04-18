package com.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.domain.KeyWordVO;
import com.application.mapper.KeyWordMapper;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/app/*")
@Log4j
public class AppController {
	 @Autowired
    private KeyWordMapper service;
	

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // input type="date" 값: "yyyy-MM-dd"
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
    }

	@GetMapping("/application")
	public void exUpload() {}
	
	@PostMapping("/keypost")
	public String keypost(@ModelAttribute KeyWordVO keyWordVO) {

		service.insert(keyWordVO);
		return "redirect:/app/application";
	}
}
