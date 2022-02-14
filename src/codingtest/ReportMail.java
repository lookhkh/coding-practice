package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportMail {
	
	public static void main(String[] args) {
		Solution23 sol = new Solution23();
		String[] idList = {"a", "b", "c", "d"};
		String[] report = {"a b","a c","a b","b c","c d","a d","a b","a c","a b","b c","c d","a d","a b","a c","a b","b c","c d","a d"};
		int k = 2;
		for(int a : sol.solution(idList, report, k)) {System.out.println(a);};
	}
	
	
}



class Solution23 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        List<Report> reports = Arrays
					        	.stream(report)
					        	.map(rt -> rt.split(" "))
					        	.map(arr -> new Report(arr[0]+arr[1],arr[0],arr[1]))
					        	.collect(Collectors.toList());
        
		ReportManager manager = new DefaultReportManager(reports,k);
		List<String> result = manager.execute();
		
		List<String> idList = Arrays.asList(id_list);
		
		
		for(int i=0; i<idList.size(); i++) {
			String target = idList.get(i);
			int cnt = 0;
			
			for(int j=0; j<result.size(); j++) {
				if(result.get(j).equals(target)) {
					cnt++;
				}
			}
			
			answer[i] = cnt;			
		}

		
        return answer;
    }

    
    class Report{
    	private int id;
    	private String fromId;
    	private String toId;
    	
    	public Report(String keys,String fromId, String toId) {
    		    		
    		this.id = keys.hashCode();
    		this.fromId = fromId;
    		this.toId = toId;
    		
		}
    	
    	public String getReportedId() {
    		return this.toId;
    	}
    	
    	public String getReporter() {
    		return this.fromId;
    	}
    	
    	public int getId() {
    		return this.id;
    	}
    	
    	@Override
    	public String toString() {
    		return this.fromId+"  "+this.toId;
    	}

    	@Override
    	public boolean equals(Object obj) {
    		Report report = (Report)obj;
    		return this.id==report.getId()?true:false;
    	}
    	
    	@Override
    	public int hashCode() {
    		return this.id;
    	}
    }
    
    interface ReportManager{
    	public List<String> execute();
    	
    }
    
    class DefaultReportManager implements ReportManager{
    	
    	private Set<Report> reports;
    	private int k;
    	
    	public DefaultReportManager(List<Report> reports,int k) {
    		this.reports =new HashSet<>((reports));
    		this.k = k;
    		
    	}
    	
    	@Override
    	public List<String> execute() {
    		return decideWhoEmailedAndReturnedTheList(checkList());
    	}

    	private Map<String, Integer> checkList() {
        	Map<String, Integer> history = new HashMap<>();
    		
    		
    		for(Report report : this.reports) {
    			String key = report.getReportedId();
    		
    			if(history.containsKey(key)) {
    				history.put(key, history.get(key)+1);
    			}else {
    				history.put(key, 1);
    			}
    		}
    		
    		return history;
    	}
    	
    	private List<String> decideWhoEmailedAndReturnedTheList(Map<String, Integer> history) {
        	List<String> userWhoReported = new ArrayList<String>();

    		List<String> reportedDevil = history
							    			.entrySet()
							    			.stream()
							    			.filter(set->set.getValue()>=k)
							    			.map(a->a.getKey())
							    			.collect(Collectors.toList());    		
    		    		
    		for(Report report : this.reports) {
    			if(reportedDevil.contains(report.getReportedId())) {
    				userWhoReported.add(report.getReporter());
    			}
    		}
    	
    		return userWhoReported;
    		
    	}
    	
    	
    }
    
}