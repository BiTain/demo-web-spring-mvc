	package com.demospring.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demospring.dto.NewDTO;
import com.demospring.service.ICategoryservice;
import com.demospring.service.INewService;
import com.demospring.util.MessageUtils;

@Controller(value = "newControllerOfAdmin")
public class NewController {

	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryservice categoryservice;
	
	@Autowired
	private MessageUtils messageUtils;
	
	@RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
//	@ModelAttribute("model") NewModel model thay cho formUtil đc build 
	public ModelAndView showList(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpServletRequest request) {
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/new/list");
		Pageable pageable = new PageRequest(page-1, limit);
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()) );
		if(request.getParameter("message")!=null) {
			Map<String, String> message =  messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);//thay cho request.setAttribute
		return mav;
	}
	
	@RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		NewDTO model = new NewDTO();
		if(id!=null) {
			model = newService.findById(id);
		}
		if(request.getParameter("message")!=null) {
			Map<String, String> message =  messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", categoryservice.findAll());
		mav.addObject("model",model);
		return mav;
	}
}
