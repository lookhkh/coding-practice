package programmersLevel2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 파일명정렬 {

	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] files2 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] files3 = {"img000", "img00"};
		String[] files4 = {"O00321", "O49qcGPHuRLR5FEfoO00321"};

		List<String> result = sol.solution(files4);
		
		result.forEach(a->System.out.println(a));
	}
}

class Solution6 {
    public List<String> solution(String[] files) {
        List<File> result = new ArrayList();
        
        
        for(String file : files) {
        	        	
        	StringBuilder headBuilder = new StringBuilder();
        	StringBuilder numberBuilder = new StringBuilder();
        	StringBuilder tailBuilder = new StringBuilder();
        	
        	
        	File newFile = extractedFileFromName(file, headBuilder, numberBuilder, tailBuilder);
        	result.add(newFile);
        }
        
        Collections.sort(result, new Comparator<File>() {
        	@Override
        	public int compare(File o1, File o2) {
        		int result =  o1.head.compareToIgnoreCase(o2.head);
        		if(result == 0) return o1.number > o2.number ? 1: o1.number<o2.number ? -1: 0;
        		else return result;
        	}
		});
        
        
        
        result.forEach(a->System.out.println(a.toString()));
        
        return result.stream().map(file->file.orginal).collect(Collectors.toList());
    }

	private File extractedFileFromName(String file, StringBuilder headBuilder, StringBuilder numberBuilder,
			StringBuilder tailBuilder) {
		
		int firstNum= -1;
		
		boolean isHead =true;
		boolean isNumber = false;
		boolean isTail = false;
		
		for(int i=0; i<file.length(); i++) {
			
			String charAtIndex = file.substring(i,i+1);
			
			if(isNotNumber(charAtIndex) && isHead) {
				headBuilder.append(charAtIndex);
			}else if(isNotNumber(charAtIndex) && !isHead) {
				isTail= true;
				tailBuilder.append(charAtIndex);
			}else if(!isNotNumber(charAtIndex) && !isTail) {
				if(firstNum == -1) {
					isHead = false;
					firstNum = i;
				}
				
				numberBuilder.append(charAtIndex);
				
			}

			
			
		}
		
		
		File newFile = new File(headBuilder.toString(), Integer.valueOf(numberBuilder.toString()),  tailBuilder.toString(),file);
		return newFile;
	} 
    
    private boolean isNotNumber(String charAtGivenIndex) {
    	char[] arr = charAtGivenIndex.toCharArray();
    	  
    	for (char c : arr)
    	    {
    	        if (!Character.isDigit(c)) return true;
    	    }
    	    return false;
    }

	class File{
    	String head;
    	int number;
    	String tail;
    	String orginal;
    	
    	public File(String head, int number, String tail, String original) {

    		this.head = head;
    		this.number = number;
    		this.tail = tail;
    		this.orginal = original;
    		
		}
    	
    	@Override
    	public String toString() {
    		return "head => "+this.head+" number => "+this.number+" tail => "+this.tail;
    	}
    	
    }
}