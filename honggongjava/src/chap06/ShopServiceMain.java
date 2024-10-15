package chap06;

public class ShopServiceMain {
	public static void main(String[] args) {
		ShopService sp = ShopService.get();
		ShopService sp2 = ShopService.get();
		
		if(sp==sp2) {
			System.out.println("같은 객체");
		}else {
			System.out.println("다른 객체");
		}
		
	}
}
