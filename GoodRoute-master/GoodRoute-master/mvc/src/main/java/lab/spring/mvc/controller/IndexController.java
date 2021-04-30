package lab.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.mvc.model.DeliveryVO;
import lab.spring.mvc.service.DeliveryService;

@Controller
@RequestMapping("/")
public class IndexController{
	@Autowired
	DeliveryService Service;

	
	@RequestMapping(value="startEndPoint.do", method = RequestMethod.POST)
	public ModelAndView MainInfo(String startpoint, String endpoint, @RequestParam(value="start_latlng") String start, @RequestParam(value="end_latlng") String end) {
		ModelAndView mav = new ModelAndView();
		DeliveryVO startVO = new DeliveryVO();
		DeliveryVO endVO = new DeliveryVO();
		
		System.out.println(startpoint+" "+endpoint+" "+start+" "+end);
		
		String[] startArr = start.split(", ");
		String[] endArr = end.split(", ");
		try {
			startVO.setInvoice_num("000000");
			startVO.setRec_name("출발지");
			startVO.setAddr(startpoint);
			startVO.setLat(startArr[0]);
			startVO.setLng(startArr[1]);
			
			Service.addStartEndPoint(startVO);
			
			endVO.setInvoice_num("999999");
			endVO.setRec_name("도착지");
			endVO.setAddr(endpoint);
			endVO.setLat(endArr[0]);
			endVO.setLng(endArr[1]);
			
			Service.addStartEndPoint(endVO);
			
			mav.setViewName("addStartEndPointSuccess");
		}catch(Exception e){
			System.out.println(e);
			mav.setViewName("addStartEndPointFail");
		}
		return mav;
	}

}
