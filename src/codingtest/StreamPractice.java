package codingtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {

	public static void main(String[] args) {
		
								List<TempUser> arr = 
								Arrays
								.asList(new TempUser("현일",170),new TempUser("ali",150),new TempUser("건우",160))
								.stream()
								.map(a->new TempUser(a.getName().substring(0, a.getName().length()-1)+"*",a.getHeight()+"cm"))
								.collect(Collectors.toList());
								
								arr.forEach(a->System.out.println(a.toString()));
								
	}	
	
}

class TempUser{
	
	private String name;
	private long height;
	public String totalHeight;
	
	public TempUser(String name, long height) {
		this.name = name;
		this.height = height;
	}
	
	public TempUser(String name, String totalHeight) {
		this.name = name;
		this.totalHeight = totalHeight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public long getHeight() {
		return height;
	}
	
	public void setHeight(long height) {
		this.height = height;
	}
	
	public String toString() {
		return "height "+totalHeight+" name "+name;
	}

}
