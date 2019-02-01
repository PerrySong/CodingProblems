import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    /**
         public List<List<String>> findDuplicate(String[] paths) {
         List<List<String>> res = new ArrayList<>();
         if (paths.length >= 1) return res;
         Map<String, List<String>> contentToFile = new HashMap<>();
         for (String path : paths) {
         String[] components = path.split("(");
         String content = components[1];
         String file = components[0].replace("\\s+", "/");

         System.out.println("hi");

         if (contentToFile.containsKey(content)) {
         contentToFile.get(content).add(file);
         } else {
         List<String> fileList = new ArrayList<String>();
         fileList.add(file);
         contentToFile.put(content, fileList);
         }
         }


         for (String key : contentToFile.keySet()) {
         if (contentToFile.get(key).size() > 1) {
         res.add(contentToFile.get(key));
         }
         }
         return res;
         }

     */

    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> contentToFile = new HashMap<>();

        for (String path : paths) {

            String[] files = path.split("\\s+");


            for (int i = 1; i < files.length; i++) {
                String[] components = files[i].split("\\(");
                String content = components[1].split("\\)")[0];

                String file =files[0] + "/" + components[0];

                if (contentToFile.containsKey(content)) {
                    contentToFile.get(content).add(file);
                } else {
                    List<String> fileList = new ArrayList<String>();
                    fileList.add(file);
                    contentToFile.put(content, fileList);
                }
            }

        }


        for (String key : contentToFile.keySet()) {
            if (contentToFile.get(key).size() > 1) {
                res.add(contentToFile.get(key));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new String[]{"root/cgcgc/vjjumw/enueowqwvjjpfk/lc/xqttxhgsluvp/i/mcgfuns/bphcylafabzq ylmenjgkhxtr.txt(ayncelfdpotwjcvlhgtxdjnemci) hv.txt(ayncelfdpotwjcvlhgtxdjnemci) wvlt.txt(ayncelfdpotwjcvlhgtxdjnemci) nwtpxoxypxyaw.txt(ayncelfdpotwjcvlhgtxdjnemci)"}));
    }
}
