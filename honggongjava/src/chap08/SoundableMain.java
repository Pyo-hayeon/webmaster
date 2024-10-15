package chap08;

public class SoundableMain {

	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		//메소드로 인터페이스 호출
		printSound(new Cat());
		printSound(new Dog());
		
		
		
		Soundable soundable;
		//객체로 인터페이스 호출
		soundable = new Cat();
		System.out.println(soundable.sound());
		
		//인터페이스로 변경됬으면 강제로 자식객체로 바꿀수있음
		if(soundable instanceof Cat) {
			System.out.println("dd");
			Cat cat = (Cat)soundable;
			System.out.println(cat.sound()); 
			System.out.println("dd");
		}
		
		soundable = new Dog();
		System.out.println(soundable.sound());

	}

}
