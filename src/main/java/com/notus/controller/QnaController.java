package com.notus.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	 @RequestMapping(value = "/write", method = RequestMethod.POST)
	 public String postWrite(QnaVO vo) throws Exception {
	  logger.info("post write");
	  
	  service.write(vo);
	  
	  return "redirect:/qna/list";
	 }
	 
	 @RequestMapping(value = "read",method = RequestMethod.GET)
	 public void getRead(@RequestParam("bno") int bno, Model model) throws Exception{
		 logger.info("get read");
		 QnaVO vo = service.read(bno);
		 model.addAttribute("read", vo);
	 }
	 
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public void list(Model model) throws Exception {
	  logger.info("get list");
	  
	  List<QnaVO> list = service.list();
	  
	  model.addAttribute("list", list);
	 }
	 
	 @RequestMapping(value = "/modify", method = RequestMethod.GET)
	 public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
	  logger.info("get modify");
	  
	  QnaVO vo = service.read(bno);
	  
	  model.addAttribute("modify", vo);
	  
	 } 
	 
	 @RequestMapping(value = "/modify", method = RequestMethod.POST)
	 public String postModify(QnaVO vo) throws Exception {
	  logger.info("post modify");
	  
	  service.update(vo);
	  
	  return "redirect:/qna/list";
	  
	 }
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public void getDelete(@RequestParam("bno") int bno, Model model) throws Exception {
	  logger.info("get delete");
	    
	  model.addAttribute("delete", bno);
	  
	 }
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.POST)
	 public String postDelete(@RequestParam("bno") int bno) throws Exception {
	  logger.info("post delete");
	    
	  service.delete(bno);
	  
	  return "redirect:/qna/list";
	 }

}
