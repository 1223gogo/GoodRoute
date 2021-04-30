package lab.spring.mvc.model;

import java.util.List;

public interface DeliveryDAO {
	//Add Qrcode data(invoice_num, rec_name, addr) to oracleDB
	public Object addQr(DeliveryVO vo);
	
	//update Location(lng, lat) info to oracleDB
	public int updateLocation(DeliveryVO vo);
		
	//select lat, lng from delivery
	public  List<DeliveryVO> allLocation(DeliveryVO vo);
	
	//insert startpoint or endpoint
	public int addStartEndPoint(DeliveryVO vo);
}
