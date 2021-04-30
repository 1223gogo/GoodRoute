package lab.spring.mvc.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryDAOImpl implements DeliveryDAO{
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public DeliveryDAOImpl() {
		System.out.println("1. DeliveryDAOImpl");
	}
	
	public Object addQr(DeliveryVO vo) {
		return sqlSession.insert("lab.mybatis.user.DeliveryMapper.addQr", vo);
	}
	
	//update Location(lng, lat) info to oracleDB
	public int updateLocation(DeliveryVO vo) {
		return sqlSession.update("lab.mybatis.user.DeliveryMapper.updateLocation", vo);
	};
			
	//select lat, lng from delivery
	public  List<DeliveryVO> allLocation(DeliveryVO vo){
		return sqlSession.selectList("lab.mybatis.user.DeliveryMapper.allLocation");
	};
	
	//update delivery set addr=?, lat =?, lng=? where rec_name=?
	public int addStartEndPoint(DeliveryVO vo) {
		return sqlSession.update("lab.mybatis.user.DeliveryMapper.addStartEndPoint", vo);
	}
	
}
