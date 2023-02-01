package javaMid3.ex13.again;

public class Jisa {	// getter, setter
	String jisaName;	// 지사명
	String proName;	// 제품명
	int proPrice;	// 제품가격
	int saleAmount;	// 판매량
	int saleStatus; // 매출현황
	
	public String getJisaName() {
		return jisaName;
	}
	public void setJisaName(String jisaName) {
		this.jisaName = jisaName;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}
	public int getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(int saleStatus) {
		this.saleStatus = saleStatus;
	}
}