class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        boolean map[] = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();

        all(nums , list , map, ls);
        return ls;
    }
    public void all(int[]nums ,List<Integer> list , boolean[]map,List<List<Integer>> ls){

        if(list.size() == nums.length){
            ls.add(new ArrayList<>(list));
            return;
        }
        for(int i=0 ; i<nums.length ; i++){
            if(!map[i]){
                list.add(nums[i]);
                map[i] = true;
                all(nums , list , map,ls);
                list.remove(list.size()-1);
                map[i] = false;
            }
        }
    }
}