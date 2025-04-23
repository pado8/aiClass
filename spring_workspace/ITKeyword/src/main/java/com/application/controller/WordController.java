package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.application.domain.Criteria;
import com.application.domain.PageDTO;
import com.application.domain.WordVO;
import com.application.service.WordService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/word/*")
@AllArgsConstructor
public class WordController {
    private WordService service;
    
    // 등록화면
    @GetMapping("/register")
    public void register() {}

    // 목록
    @GetMapping("/list")
    public void list(Criteria cri, Model model) {
        model.addAttribute("list", service.getList(cri));  // 페이징 처리된 리스트
        int total = service.getTotal(cri);  // 전체 글 수
        model.addAttribute("pageMaker", new PageDTO(cri, total));  // 페이지 네비게이션 정보
    }

    // 등록
    @PostMapping("/register")
    public String register(WordVO word, RedirectAttributes rttr) {
        service.register(word);
        rttr.addFlashAttribute("result", word.getNo());
        return "redirect:/word/list";
    }

    // 상세보기 및 수정
    @GetMapping({ "/get", "/modify" })
    public void get(@RequestParam("no") Long no, @ModelAttribute("cri") Criteria cri, Model model) {
        model.addAttribute("word", service.get(no));
    }

    // 수정
    @PostMapping("/modify")
    public String modify(WordVO word, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
        if (service.modify(word)) {
            rttr.addFlashAttribute("result", "success");
        }

        // 기존 페이지 정보 유지
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        rttr.addAttribute("type", cri.getType());
        rttr.addAttribute("searchkeyword", cri.getSearchkeyword());  // 수정된 메서드 호출

        return "redirect:/word/list";
    }

    // 삭제
    @PostMapping("/remove")
    public String remove(Long no, RedirectAttributes rttr) {
        if (service.remove(no)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/word/list";
    }
}
