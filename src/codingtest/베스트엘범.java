package codingtest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class º£½ºÆ®¿¤¹ü {

	public static void main(String[] args) {
		Solution23242 sol = new Solution23242();
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		sol.solution(genres, plays);
	}
}


class Solution23242 {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        class Song{
        	public int id;
        	public String genre;
        	public int plays;
        	
        	public Song(int id, String genre, int plays) {
        		this.id = id;
        		this.genre = genre;
        		this.plays = plays;
			}
        	
        	@Override
        	public int hashCode() {
        		// TODO Auto-generated method stub
        		return this.id;
        	}
        	
        	@Override
        	public boolean equals(Object obj) {
        		return this.hashCode()==obj.hashCode();
        	}
        }
        
        List<Song> list = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++) {
        	list.add(new Song(i,genres[i],plays[i]));
        }

        Map<String, Integer> score = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
        	if(score.containsKey(genres[i])) {
        		score.put(genres[i], score.get(genres[i])+plays[i]);
        	}else {
        		score.put(genres[i], plays[i]);

        	}
        }
        
        System.out.println(score);
        
        while(!score.isEmpty()) {
        	int max = Integer.MIN_VALUE;
        	String key = "";
        	
        	Iterator<String> itr = score.keySet().iterator();
        	while(itr.hasNext()) {
        		String tempKey = itr.next();
        		if(score.get(tempKey)>max) {
        			key = tempKey;
        			max = score.get(tempKey);
        		}
        	}
        	
        	System.out.println(key+" is the most");
        	score.remove(key);
        	
        	List<Song> tempList = new ArrayList<>();
        	for(int i=0; i<genres.length; i++) {
              if(genres[i].equals(key)) tempList.add(new Song(i,genres[i],plays[i]));
            }
        	
        	tempList.sort(new Comparator<Song>() {

				@Override
				public int compare(Song o1, Song o2) {
					return o1.plays>o2.plays?-1:o1.plays==o2.plays?0:1;
				}
			});
        	
        	for(int i=0; i<tempList.size(); i++) {
        		if(i<2) {
        			answer.add(tempList.get(i).id);
        		}
        	}
       
        }
        
        answer.forEach(a->System.out.println(a));
        
        
        return answer;
    }
}