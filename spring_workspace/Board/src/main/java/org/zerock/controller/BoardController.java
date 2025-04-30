package org.zerock.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	//주입. 자동주입. 생성자 의존성 주입	
	private BoardService service;
	//등록화면
	@GetMapping("/register")
	public void register() {}
	//목록
//	@GetMapping("/list")
//	public void list(Model model) {
//		// request.setAttribute("list", service.getList()); 와 같은 역할
//		model.addAttribute("list", service.getList());
//	}
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list", service.getList(cri));
		
		int total=service.getTotal(cri); //전체글수
		model.addAttribute("pageMaker", new PageDTO(cri,total)); //1.2.3...10 페이지번호생성
	}
	
	
	//등록
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	//상세보기.수정화면
	@GetMapping({"/get","/modify"})
	public void get(Long bno,@ModelAttribute("cri") Criteria cri,Model model) {
		model.addAttribute("board", service.get(bno));
	}
	//수정
	@PostMapping("/modify")
	public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}
	//삭제
	@PostMapping("/remove")
	public String remove(Long bno, Criteria cri, RedirectAttributes rttr) {
		//첨부파일목록
		List<BoardAttachVO> attachList=service.getAttachList(bno);		
				
		if(service.remove(bno)) {
			//첨부파일삭제
			deleteFiles(attachList);
			
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list"+cri.getListLink();
	}
	
	//첨부파일삭제
	private void deleteFiles(List<BoardAttachVO> attachList) {
		//첨부파일이 없으면 종료
		if(attachList==null || attachList.size()==0) {
			return;
		}
		attachList.forEach(attach->{
			try {
				Path file=Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\"+attach.getUuid()+"_"+attach.getFileName());
				Files.deleteIfExists(file); //파일삭제
				
				//이미지파일이면 썸네일도 삭제
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail=Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_"+attach.getUuid()+"_"+attach.getFileName());
					Files.delete(thumbNail);//파일삭제
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	
	//첨부파일목록
	@GetMapping(value="/getAttachList",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}
	
}
