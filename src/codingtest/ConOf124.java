package codingtest;

import java.util.ArrayList;
import java.util.List;

public class ConOf124 {
	
		static class Solution {
		
		public static void main(String[] args) {
			String[] test = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
			System.out.println(solution(test));
		}
			
	    public static String[] solution(String[] record) {
	    	
	            String[] answer;
	            List<User> box = new ArrayList<>();
	            List<Cmd> command = new ArrayList<>();
	            
	            User currentuser;
	            
	            for(String item : record) {
	            	
	            	String[] cmds = item.split(" ");
	            	currentuser = new User(cmds[1],cmds.length!=3?"":cmds[2]);
	            	
	            	if(cmds[0].equalsIgnoreCase("Enter")) {
	            		if(box.contains(currentuser)) { 
	            			
	            			User oldUser =box.get(box.indexOf(currentuser));
	            			if(!oldUser.getNickname().equals(currentuser.getNickname())) {
	            				
	            				oldUser.setNickname(currentuser.getNickname());
	            			}
	            		}            		
	            		else {
	            			box.add(currentuser);
	            		}
	            		
	            		Cmd temp = new Cmd(box.get(box.indexOf(currentuser)),cmds[0],box.get(box.indexOf(currentuser)).getUid()+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
	            		command.add(temp);
	            		
	            	}else if(cmds[0].equalsIgnoreCase("change")) {
	            		box.get(box.indexOf(currentuser)).setNickname(currentuser.getNickname());

	            	}else if(cmds[0].equalsIgnoreCase("Leave")) {
	            		command.add(new Cmd(box.get(box.indexOf(currentuser)),cmds[0],box.get(box.indexOf(currentuser)).getNickname()+"´ÔÀÌ ³ª°¬½À´Ï´Ù."));
	            	}	            	            
	            }	         	
	            
	            answer = new String[command.size()];
	            
	            for(int i=0; i<command.size(); i++) {
	            	command.get(i).setMsg(command.get(i).getMsg().replace(command.get(i).getUser().getUid(), command.get(i).getUser().getNickname()));
	            	answer[i] = command.get(i).getMsg();
	            	System.out.println(answer[i]);
	            }
	            
	            return  answer;
	        	}
		}	    	
}

class Cmd{
	private User user;
	private String action;
	private String msg;
	
	public Cmd(User user, String action, String msg) {
		super();
		this.user = user;
		this.action = action;
		this.msg = msg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public boolean equals(Object obj) {
		Cmd other = (Cmd)obj;
		return other.getUser().equals(this.user);
	}

}
class  User{
	private String uid;
	private String nickname;
	private boolean isChanged;
	
	public User(String uid, String nickname) {
		this.uid=uid;
		this.nickname = nickname;
	}

	
	public String getUid() {
		return uid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
	public boolean isChanged() {
		return isChanged;
	}


	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}


	@Override
	public String toString() {
		return "uid "+this.uid+ " nickname "+this.nickname;
	}

	@Override
	public boolean equals(Object obj) {
		User other = (User)obj;
		return this.uid.equals(other.getUid());
	}
}