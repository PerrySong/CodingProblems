import java.util.*;

public class UniqueMeal {

    class Meal {
        List<String> ingredients;
        public Meal(List<String> ingredients) {
            this.ingredients = ingredients;
        }
    }
    public int uniqueMeal(List<Meal> meals){
        Set<List<String>> set = new HashSet<List<String>>();
        for (Meal m : meals) set.add(m.ingredients);
        return set.size();
    }

    /**
     *
     * @param list1
     * @param list2
     * @return
     */
    public String findRestaurant(String[] list1, String[] list2) {
        if(list1 == null || list2 == null){
            return null;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < list2.length; j++){
            if(map.containsKey(list2[j])){
                int index = map.get(list2[j]) + j;
                if(index <min){
                    res = new LinkedList<String>(); //如果比原来的小就新建一个
                    res.add(list2[j]);
                    min = index;    //最小值替换掉
                }
            }
        }
        if(res.size() != 0) return res.get(0);
        return "Yelpwich";
    }

    /**
     *
     */
    class BusinessInfo{
        int id;
        int rating;

        public BusinessInfo(int id, int rating){
            this.id = id;
            this.rating = rating;
        }
    }

    public static List<BusinessInfo> sortBusinessByRating(List<BusinessInfo> business) {

        Collections.sort(business, Comparator.comparingInt(b -> b.rating));
        return business;
    }

    /**
     *
     * @param color
     * @return
     */
    public List<String> TopColor(ArrayList<ArrayList<String>> color){
        if(color == null) return null;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < color.size(); i++){
            for(int j = 0; j < color.get(i).size(); j++){
                if(map.containsKey(color.get(i).get(j))) {
                    map.put(color.get(i).get(j), map.get(color.get(i).get(j))+1);
                }else{
                    map.put(color.get(i).get(j),1);
                }
            }
        }
        LinkedList<String> res = new LinkedList<String>();
        int max = Integer.MIN_VALUE;
        for(String key : map.keySet()){
            if(map.get(key) >= max){
                if(map.get(key) > max){
                    res = new LinkedList<String>();
                }
                res.add(key);
                max = map.get(key);
            }
        }
        if(res.size() > 1) Collections.sort(res);
        return res;
    }

    /**
     *
     * @param s
     * @return
     */
    public String CompressString(String s){
        if(s == null) return null;
        StringBuilder res = new StringBuilder();
        int i = 0, num = 0;
        char word = s.charAt(0);
        while(i < s.length()){
            if(s.charAt(i) == word) {
                num++;
                i++;
            }else{
                res.append(String.valueOf(num));
                res.append(String.valueOf(word));
                num = 0;
                word = s.charAt(i);
            }
        }
        res.append(String.valueOf(num));
        res.append(String.valueOf(word));
        return res.toString();
    }

    /**
     *
     * @param s
     * @return
     */
    public String ReduceString(String s){
        if(s == null) return null;
        StringBuilder res = new StringBuilder();
        char word = s.charAt(0);
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == word){
                i++;
            }else{
                res.append(String.valueOf(word));
                word = s.charAt(i);
            }
        }
        res.append(String.valueOf(word));
        return res.toString();
    }

    /**
     *
     */
    class bussinessInfo{
        int id;
        List<String> category;
    }

    public List<Integer> find(List<bussinessInfo> s, String A, String B){
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).category.contains(A) && s.get(i).category.contains(B)){
                res.add(s.get(i).id);
            }
        }
        return res;
    }





}
