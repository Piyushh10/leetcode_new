class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        combination(candidates, target, temp, 0);
        return res;
    }

    public void combination(int[] candidates, int target, List<Integer> temp, int index) {
        //Goal State
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        //Exploration
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            //Action
            temp.add(candidates[i]);
            //Recursive call
            combination(candidates, target - candidates[i], temp, i + 1);
            //Undo
            temp.remove(temp.size() - 1);
        }
    }
}