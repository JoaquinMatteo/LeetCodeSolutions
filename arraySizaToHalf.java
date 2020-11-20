class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int size = arr.length;
        int halfSize= (size/2);
        ArrayList<Integer> maxOrder=new ArrayList<>();
        int setCounter=0;

        for(int i=0; i<size;i++){

            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int i:map.values()){
            maxOrder.add(i);
        }

        Collections.sort(maxOrder,Collections.reverseOrder());


        for(int i=0;i<maxOrder.size();i++){
            size-=maxOrder.get(i);
            setCounter++;
            if(size<=halfSize){
                break;
            }
        }

        return setCounter;
    }
}