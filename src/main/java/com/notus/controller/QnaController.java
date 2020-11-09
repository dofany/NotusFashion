package com.notus.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.notus.domain.Criteria;
import com.notus.domain.PageMaker;
import com.notus.domain.QnaReplyVO;
import com.notus.domain.QnaVO;
import com.notus.domain.SearchCriteria;
import com.notus.service.QnaReplyService;
import com.notus.service.QnaService;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);

	@Inject
	QnaService service;
	
	@Inject
	QnaReplyService RepService;

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite(HttpSession session, Model model) throws Exception {
		logger.info("get write");
		
		Object loginInfo = session.getAttribute("member");
		if(loginInfo == null) {
			model.addAttribute("msg","login_error");
		}
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(QnaVO vo) throws Exception {
		logger.info("post write");

		service.write(vo);

		return "redirect:/qna/list";
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void getRead(@RequestParam("bno") int bno, @ModelAttribute("scri") SearchCriteria scri,Model model) throws Exception {
		logger.info("get read");
		QnaVO vo = service.read(bno);
		model.addAttribute("read", vo);
		model.addAttribute("scri",scri);
		
		List<QnaReplyVO> repList = RepService.readReply(bno);
		model.addAttribute("repList",repList);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("get list");

		List<QnaVO> list = service.list();

		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno,@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		logger.info("get modify");

		QnaVO vo = service.read(bno);

		model.addAttribute("modify", vo);
		model.addAttribute("scri",scri);

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void getDelete(@RequestParam("bno") int bno, @ModelAttribute("scri") SearchCriteria scri,Model model) throws Exception {
		logger.info("get delete");

		model.addAttribute("delete", bno);
		model.addAttribute("scri",scri);

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(QnaVO vo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		logger.info("post modify");

		service.update(vo);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		

		return "redirect:/qna/listSearch";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(@RequestParam("bno") int bno,@ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		logger.info("post delete");

		service.delete(bno);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

		return "redirect:/qna/listSearch";
	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("get list page");

		List<QnaVO> list = service.listPage(cri);
		model.addAttribute("list", list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/listSearch", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		logger.info("get list search");

		List<QnaVO> list = service.listSearch(scri);
		model.addAttribute("list", list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount());
		//pageMaker.setTotalCount(service.countSearch(scri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	public String replyWrite(QnaReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		logger.info("reply write");
		
		RepService.writeReply(vo);
		 
		 rttr.addAttribute("bno", vo.getBno());
		 rttr.addAttribute("page", scri.getPage());
		 rttr.addAttribute("perPageNum", scri.getPerPageNum());
		 rttr.addAttribute("searchType", scri.getSearchType());
		 rttr.addAttribute("keyword", scri.getKeyword());
		 
		 return "redirect:/qna/read";
	}
	
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.POST)
	public String replyUpdate(QnaReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
	 logger.info("reply update");
	 
	 RepService.replyUpdate(vo);
	 
	 rttr.addAttribute("bno", vo.getBno());
	 rttr.addAttribute("page", scri.getPage());
	 rttr.addAttribute("perPageNum", scri.getPerPageNum());
	 rttr.addAttribute("searchType", scri.getSearchType());
	 rttr.addAttribute("keyword", scri.getKeyword());
	 
	 return "redirect:/qna/read";
	}

	// 댓글 삭제 POST
	@RequestMapping(value = "/replyDelete", method = RequestMethod.POST)
	public String replyDelete(QnaReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
	 logger.info("reply delete");
	 
	 RepService.replyDelete(vo);
	 
	 rttr.addAttribute("bno", vo.getBno());
	 rttr.addAttribute("page", scri.getPage());
	 rttr.addAttribute("perPageNum", scri.getPerPageNum());
	 rttr.addAttribute("searchType", scri.getSearchType());
	 rttr.addAttribute("keyword", scri.getKeyword());
	 
	 return "redirect:/qna/read";
	}
	
	// 댓글 수정 GET
	@RequestMapping(value = "/replyUpdate", method = RequestMethod.GET)
	public void getReplyUpdate(@RequestParam("rno") int rno,
	      @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
	 logger.info("reply update");
	 
	 QnaReplyVO vo = null;
	 
	 vo = RepService.readReplySelect(rno);
	 
	 model.addAttribute("readReply", vo);
	 model.addAttribute("scri", scri);
	}

	// 댓글 수정 GET
	@RequestMapping(value = "/replyDelete", method = RequestMethod.GET)
	public void getReplyDelete(@RequestParam("rno") int rno,
	      @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
	 logger.info("reply delete");
	 
	 QnaReplyVO vo = null;
	 
	 vo = RepService.readReplySelect(rno);
	 
	 model.addAttribute("readReply", vo);
	 model.addAttribute("scri", scri);
	}

}
