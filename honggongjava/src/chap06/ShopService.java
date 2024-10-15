package chap06;

public class ShopService {
	static ShopService sp1 = new ShopService();
	
	ShopService(){}
	
	static ShopService get(){
		return sp1;
	}
}
