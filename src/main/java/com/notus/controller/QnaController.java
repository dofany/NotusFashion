package com.notus.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notus.domain.QnaVO;
import com.notus.service.QnaService;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Inject
	QnaService service;
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	 public void getWrite() throws Exception {
	  logger.info("get write");
	 }

	 // 글 작성 post
	 @RequestMapping(value = "/write", method = RequestMethod.POST)
	 public String postWrite(QnaVO vo) throws Exception {
	  logger.info("post write");
	  
	  service.write(vo);
	  
	  return "redirect:/";
	 }
	 
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public void list(Model model) throws Exception {
	  logger.info("get list");
	  
	  List<QnaVO> list = service.list();
	  
	  model.addAttribute("list", list);
	 }
}
