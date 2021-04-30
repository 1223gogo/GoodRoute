package lab.spring.mvc.service;

import java.util.List;

import lab.spring.mvc.model.DeliveryVO;

public interface DeliveryService {
	
	public Object addQr(DeliveryVO vo);
	
	//update Location(lng, lat) info to oracleDB
	public int updateLocation(DeliveryVO vo);
	
	//select lat, lng from delivery
	public  List<DeliveryVO> allLocation(DeliveryVO vo);
	
	public int addStartEndPoint(DeliveryVO vo);
}
