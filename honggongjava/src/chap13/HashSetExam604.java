package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import chap13.*;

public class HashSetExam604 {

	public static void main(String[] args) {

		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.studnetNum + " : " + student.name);
			System.out.println(student.hashCode());
		}
		
	}
}
