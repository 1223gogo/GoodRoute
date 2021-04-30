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
public class QrController{
	@Autowired
	DeliveryService Service;

	
	@RequestMapping(value="/qr.do", method = RequestMethod.GET)
	public String QrReadingPage() {
		return "qr";
	}
	
	@RequestMapping(value="/qr.do", method = RequestMethod.POST)
	public ModelAndView addQrInfo(@RequestParam("outputData") String qrCodeMessage) {
		ModelAndView mav = new ModelAndView();
		DeliveryVO vo = new DeliveryVO();
		
		System.out.println(qrCodeMessage);
		
		String[] qrCodeMessageArr = qrCodeMessage.split(", ");
		if(qrCodeMessageArr.length >4) {
			
			try {
				vo.setInvoice_num(qrCodeMessageArr[0]);
				vo.setRec_name(qrCodeMessageArr[1]);
				vo.setAddr(qrCodeMessageArr[2]);
				vo.setLat(qrCodeMessageArr[3]);
				vo.setLng(qrCodeMessageArr[4]);
				
				Service.addQr(vo);
				mav.setViewName("qrSuccess");			
			} 
			catch(Exception e) {
				mav.setViewName("qrFail");
			}

		} else {
			mav.setViewName("qrFail");
		}
		
		return mav;
	}

}
