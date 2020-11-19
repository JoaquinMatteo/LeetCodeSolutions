class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> list=new ArrayList();
        TreeSet<String> set = new TreeSet<>();
        HashMap<String,Integer>[] map= new HashMap[501];

        for(int i=0;i<orders.size();i++){
            int table = Integer.parseInt(orders.get(i).get(1));
            String food = orders.get(i).get(2);
            if(map[table]!=null){
                Map<String,Integer> items = map[table];
                if(items.containsKey(food)){
                    items.put(food,items.get(food)+1);
                }else{
                    items.put(food,1);
                    set.add(food);
                }
            }else{
                HashMap<String,Integer> items=new HashMap<String,Integer>();
                items.put(food,1);
                set.add(food);
                map[table]=items;
            }

        }
        List<String> header = new ArrayList();
        header.add("Table");
        for(String s:set){
            header.add(s);
        }
        list.add(header);

        for(int i=0; i<501;i++){
            if(map[i]!=null){
                List<String> l = new ArrayList();
                l.add(String.valueOf(i));
                HashMap<String,Integer> m = map[i];
                for(String s:set){
                    if(m.containsKey(s)){
                        l.add(String.valueOf(m.get(s)));
                    }else{
                        l.add("0");
                    }
                }
                list.add(l);
            }