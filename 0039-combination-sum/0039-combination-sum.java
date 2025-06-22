class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        combination(candidates, target, temp, 0);
        return res;
    }

    public void combination(int[] candidates, int target, List<Integer> temp, int index){
        //Goal State
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        //Exploration
        for(int i = index; i< candidates.length; i++){
            if(candidates[i] <= target){
                //Action
                temp.add(candidates[i]);
                //Recursive call
                combination(candidates, target-candidates[i], temp, i);
                //Undo
                temp.remove(temp.size() - 1);
            }
        }
    }
}