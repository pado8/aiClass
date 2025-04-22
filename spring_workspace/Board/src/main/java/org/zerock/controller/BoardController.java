package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	//주입. 자동 주입
	private BoardService service;
	
	//등록화면
	@GetMapping("/register")
	public void register() {}
	//목록
	//@GetMapping("/list")
	//public void list(Model model) {
	//	model.addAttribute("list", service.getList());
	//}
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list", service.getList(cri));
		
		int total = service.getTotal(cri); // 전체 글 수
		model.addAttribute("pageMaker", new PageDTO(cri, total)); //1.2.3.....10 페이지 번호 생성

	}
	//등록
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	//상세보기
	@GetMapping({"/get","/modify"})
	public void get(Long bno,Model model) {
		model.addAttribute("board", service.get(bno));
	}
	//수정
	 @PostMapping("/modify")
	 public String modify(BoardVO board, RedirectAttributes rttr) {
		 if (service.modify(board)) {
			 rttr.addFlashAttribute("result", "success");
		 }
		 return "redirect:/board/list";
 	}
	//수정
	 @PostMapping("/remove")
	 public String remove(Long bno, RedirectAttributes rttr) {
		 if (service.remove(bno)) {
			 rttr.addFlashAttribute("result", "success");
		 }
		 return "redirect:/board/list";
 	}
 
	
}
