package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {



        List<List<Integer>> combinations = new ArrayList<>();

        Arrays.sort(candidates);



        List<Integer> comb = new ArrayList<>();
        findCombination(combinations, candidates, 0, comb, 0, target );
        return combinations;
    }


    public void findCombination(List<List<Integer>>  combinations, int[] candidates, int index, List<Integer> comb, int currentSum, int target) {
        if(currentSum ==target) {

            List<Integer> newComb  = new ArrayList<Integer>(comb);
            combinations.add(newComb);
            return;
        }

        if(currentSum < target) {

            for(int i= index; i<candidates.length; i++) {
                comb.add(candidates[i]);

                currentSum += candidates[i];
                findCombination(combinations, candidates, i, comb, currentSum, target );

                currentSum -= candidates[i];
                comb.remove(comb.size() -1);
            }
        }

        return;

    }

    public static void main(String[] args) {

        CombinationSum runClass = new CombinationSum();

        int[] candidates = {1};
        int target = 2;
        List<List<Integer>> res = runClass.combinationSum(candidates, target);

        for(List<Integer> com : res) {
            System.out.println(com.stream().map( e -> {
                return String.valueOf(
                        e
            );
            }).collect(Collectors.joining(",")));
        }

    }
}
