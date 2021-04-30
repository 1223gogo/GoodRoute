package lab.spring.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.mvc.model.DeliveryVO;
import lab.spring.mvc.service.DeliveryService;

@Controller
public class GoodrouteController{
	@Autowired
	DeliveryService Service;

	@RequestMapping(value="/goodroute.do", method = RequestMethod.GET)
	public String GoodroutePage(Model model) {
		DeliveryVO vo = new DeliveryVO();
		List<DeliveryVO> locationlist = Service.allLocation(vo);
		String[] invoiceNum = new String[locationlist.size()];
		float[] lat = new float[locationlist.size()];
		float[] lng = new float[locationlist.size()];
		float latStart = 37, lngStart = 127, latEnd = 37, lngEnd = 127;
		
		for(int i = 0; i < locationlist.size(); i++) {
			
			if(locationlist.get(i).getInvoice_num().equals("000000")) {
				latStart = Float.parseFloat(locationlist.get(i).getLat());
				lngStart = Float.parseFloat(locationlist.get(i).getLng());				
			} 
			else if(locationlist.get(i).getInvoice_num().equals("999999")) {
				latEnd = Float.parseFloat(locationlist.get(i).getLat());
				lngEnd = Float.parseFloat(locationlist.get(i).getLng());
			}
			invoiceNum[i] = locationlist.get(i).getInvoice_num();
			lat[i] = Float.parseFloat(locationlist.get(i).getLat());
			lng[i] = Float.parseFloat(locationlist.get(i).getLng());
			
			model.addAttribute("latEnd",latEnd);
			model.addAttribute("lngEnd",lngEnd);
			model.addAttribute("latStart",latStart);
			model.addAttribute("lngStart",lngStart);
			model.addAttribute("invoiceNums",invoiceNum);
			model.addAttribute("lats",lat);
			model.addAttribute("lngs",lng);
		}
		return "goodroute";
	}
	
	@RequestMapping(value="/goodroute.do", method = RequestMethod.POST)
	public ModelAndView addGoodrouteInfo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		//DeliveryVO vo = new DeliveryVO();
		
		mav.setViewName("goodrouteSuccess");
		
		return mav;
	}

}
