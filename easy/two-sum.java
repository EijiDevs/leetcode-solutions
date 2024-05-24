class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        int i = 0;

        while(i < nums.length){
            if(m.containsKey(target - nums[i])){
                return new int[] {i, m.get(target - nums[i])};
            } 
            m.put(nums[i], i);
            i++;
        }

        return null;
    }
}