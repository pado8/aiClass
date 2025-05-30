package org.zerock.mreview.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.mreview.dto.MovieDTO;
import org.zerock.mreview.dto.PageRequestDTO;
import org.zerock.mreview.service.MovieService;

@Controller
@RequestMapping("/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService; //자동주입.final필요

    //등록화면
    @GetMapping("/register")
    public void register(){}
    //등록처리
    @PostMapping("/register")
    public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes){
        Long mno = movieService.register(movieDTO);

        redirectAttributes.addFlashAttribute("msg", mno);

        return "redirect:/movie/list";
    }
    //목록
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        model.addAttribute("result", movieService.getList(pageRequestDTO));
    }
    //상세보기.수정화면
    @GetMapping({"/read", "/modify"})
    public void read(long mno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model ){
        MovieDTO movieDTO = movieService.getMovie(mno);

        model.addAttribute("dto", movieDTO);
    }


}