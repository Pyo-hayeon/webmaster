package test13;

import java.util.ArrayList;
import java.util.List;

public class ArrayListControl {
	//리스트<객체명> 변수 = new 리스트명<객체명>();
	List<String> list = new ArrayList<String>();
	
	void setArrat(String str) {
		list.add(str);
	}
}
