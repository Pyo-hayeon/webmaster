package chap13;

public class Student {
	public int studnetNum;
	public String name;
	
	public Student(int studnetNum, String name) {
		this.studnetNum = studnetNum;
		this.name = name;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			//return true;
			return student.name.equals(name) && (student.studnetNum==studnetNum);
		}else {
			return false;			
		}
	}
	
	@Override
	public int hashCode() {
		//return super.hashCode();
		return studnetNum;
	}

}
