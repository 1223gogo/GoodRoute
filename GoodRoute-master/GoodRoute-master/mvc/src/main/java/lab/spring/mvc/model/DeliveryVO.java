package lab.spring.mvc.model;

public class DeliveryVO {
	private String invoice_num;
	private String rec_name;
	private String addr;
	private String lng;
	private String lat;
	private int rank;
	public DeliveryVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getInvoice_num() {
		return invoice_num;
	}
	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}
	public String getRec_name() {
		return rec_name;
	}
	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public DeliveryVO(String invoice_num, String rec_name, String addr, String lng, String lat, int rank) {
		super();
		this.invoice_num = invoice_num;
		this.rec_name = rec_name;
		this.addr = addr;
		this.lng = lng;
		this.lat = lat;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "DeliveryVO [invoice_num=" + invoice_num + ", rec_name=" + rec_name + ", addr=" + addr + ", lng=" + lng
				+ ", lat=" + lat + ", rank=" + rank + "]";
	}
	
	
}
