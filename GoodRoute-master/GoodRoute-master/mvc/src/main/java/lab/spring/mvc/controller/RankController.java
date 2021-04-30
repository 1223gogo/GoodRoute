package lab.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.mvc.model.DeliveryVO;
import lab.spring.mvc.service.DeliveryService;

@Controller
public class RankController{
	@Autowired
	DeliveryService Service;

	
	@RequestMapping(value="/rank.do", method = RequestMethod.GET)
	public String RankPage() {
		return "rank";
	}
	
	@RequestMapping(value="/rank.do", method = RequestMethod.POST)
	public ModelAndView updateRank() {
		ModelAndView mav = new ModelAndView();
		//DeliveryVO vo = new DeliveryVO();
		
		mav.setViewName("rankSuccess");
		
		return mav;
	}

}
