package codingtest;

import java.util.concurrent.atomic.AtomicLong;

public class TargetNumber {
	 
	static private int cnt = 0;
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1,1};
		int target = 3;
		System.out.println(solution(nums, target));
	}
	
	public static int solution(int[] numbers, int target) {
	        dfs(numbers,target,0,0);
	       
	        
	        return cnt;
	}
	
	private static void dfs(int[] nums, int tar, int idx, int sum) {
		if(idx==nums.length) {
			System.out.println("���� ����");
			if(sum==tar) {
				cnt++;
				System.out.println("�� ����");
			}
			return;
		}
		
		System.out.println("���� idx = "+idx);
		sum += nums[idx];
		dfs(nums, tar, idx+1, sum);
		sum-=nums[idx];
		sum+=(-1*nums[idx]);
		dfs(nums, tar, idx+1, sum);
	}
	
	
}
