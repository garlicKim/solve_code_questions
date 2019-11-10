package basic;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class PocketMon {

    public int solution(int[] nums) {

        int answer = nums.length / 2;

        Set<Integer> numSet = new HashSet<>();

        for(int i: nums)
            numSet.add(i);


        if(numSet.size() < answer)
            return numSet.size();

        return answer;
    }


    @org.junit.Test
    public void pocketMonTest1() {

        int[] nums = {3,1,2,3};

        Assert.assertEquals(2, solution(nums));
    }

    @org.junit.Test
    public void pocketMonTest2() {

        int[] nums = {3,3,3,2,2,4};

        Assert.assertEquals(3, solution(nums));
    }


    @org.junit.Test
    public void pocketMonTest3() {

        int[] nums = {3,3,3,2,2,2};

        Assert.assertEquals(2, solution(nums));
    }

}
