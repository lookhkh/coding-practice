package dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
	
	public static void main(String[] args) {
		Student s1 = new Student("ÇöÀÏ",180,5);
		Student s2 = new Student("¹Î¿ì",170,1);
		Student s3 = new Student("¹è·¯",165,3);
		Student s4 = new Student("¿¡¸¯",182,2);
		Student s5 = new Student("±è",170,4);
		
		List<Student> list = new ArrayList<>();
		list.add(s1); list.add(s2); list.add(s3); list.add(s4); list.add(s5);
		list.sort(null);
		
		int num = Collections.binarySearch(list, s2, null);
		System.out.println(num);

	}
	
}

class Student implements Comparable<Student>{
	
	private String name;
	private int height;
	private int serialNum;
	
	public Student(String name, int height, int serialNum) {
		super();
		this.name = name;
		this.height = height;
		this.serialNum = serialNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	@Override
	public int compareTo(Student o) {
		
		boolean result = this.serialNum>o.getSerialNum();
		
		if(result) {
			return 1;
		}else if(!result) {
			if(this.serialNum==o.getSerialNum()) {
				if(this.height>o.getHeight()) {
					return 1;
				}else if(this.height<o.getHeight()){
					return -1;
				}else {
					return 0;
				}
			}else {
				return -1;
			}
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "name is : "+this.name+" serialNum and height are "+this.serialNum+" "+this.height;
	}
}
