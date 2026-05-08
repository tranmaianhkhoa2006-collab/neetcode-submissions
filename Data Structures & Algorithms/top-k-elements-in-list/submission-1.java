class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] solution = new int[k]
        HashMap<Integer,Integer> frequentHashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            frequentHashMap.put(nums[i],0);
        }
        
        if(frequentHashMap.size()==k){
            int i=0;
            for(Integer number : frequentHashMap.keySet()){
                solution[i++] = number;
            }
            return solution;
        }

        TreeMap<Integer,ArrayList<Integer>> sortedSolution = new TreeMap<>(Comparator.reverseOrder());


        for(int i=0;i<nums.length;i++){
            frequentHashMap.put(nums[i], frequentHashMap.get(nums[i])+1);
        }

         for(Map.Entry<Integer,Integer> elements : frequentHashMap.entrySet()){
           sortedSolution.put(elements.getValue(), new ArrayList<>());
        }


        for(Map.Entry<Integer,Integer> elements : frequentHashMap.entrySet()){
           ArrayList<Integer> tmp = sortedSolution.get(elements.getValue());
           tmp.add(elements.getKey());
           sortedSolution.put(elements.getValue(), tmp);
        }
       int i=0;
        for(Map.Entry<Integer,ArrayList<Integer>> elements : sortedSolution.entrySet()){
            ArrayList<Integer> tmp = elements.getValue();

            for(int j=0;j< tmp.size();j++){
                solution[i++] = tmp.get(j);
                if(i==k)
                break;
            }

            if(i==k)
                break;
        }

        return solution;
    }
}
