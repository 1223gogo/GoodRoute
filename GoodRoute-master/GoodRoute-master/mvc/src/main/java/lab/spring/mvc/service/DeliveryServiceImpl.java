package lab.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.mvc.model.DeliveryDAO;
import lab.spring.mvc.model.DeliveryVO;


@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService{
	@Autowired
	DeliveryDAO dao ;

	public DeliveryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryDAO getDao() {
		return dao;
	}

	public void setDao(DeliveryDAO dao) {
		this.dao = dao;
	}
	
	public Object addQr(DeliveryVO vo) {
		return dao.addQr(vo);
	}
	
	//update Location(lng, lat) info to oracleDB
	public int updateLocation(DeliveryVO vo) {
		return dao.updateLocation(vo);
	}
	
	//select lat, lng from delivery
	public  List<DeliveryVO> allLocation(DeliveryVO vo){
		return dao.allLocation(vo);
	}
	
	public int addStartEndPoint(DeliveryVO vo) {
		return dao.addStartEndPoint(vo);
	}
	
}
