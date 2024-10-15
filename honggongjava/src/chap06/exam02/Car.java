package chap06.exam02;

import chap06.exam02.hankook.*;
import chap06.exam02.kumho.*;
import chap06.exam02.hyundai.Engine;

public class Car {
	Engine engine = new Engine(); 
	SnowTire tire1 = new SnowTire();
	BigWidthTire tire2 = new BigWidthTire();
	//다른 패키지지만 클래스 이름이 동일하다면 어느 패키지의 클래스인지 명시해줘야한다
	chap06.exam02.hankook.Tire tire3 = new chap06.exam02.hankook.Tire(); 
	chap06.exam02.kumho.Tire tire4 = new chap06.exam02.kumho.Tire(); 
}
