import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoComplete {
    class TreeNode {
        HashMap<Character, TreeNode> children;
        char cha;
        boolean isWord;
        TreeNode(char cha) {
            this.cha = cha;
            this.children = new HashMap<>();
            this.isWord = isWord;
        }
        TreeNode() {
            this.children = new HashMap<>();
        }

        void isWord() {
            this.isWord = true;
        }
    }

    TreeNode root;

    /**
     * Constructor
     * @param library
     */
    public AutoComplete(String[] library) {
        this.root = new TreeNode();

        for (String word: library) {
            TreeNode cur = root;
            char[] cArray = word.toCharArray();
            for (int i = 0; i < cArray.length; i++) {
                if (cur.children.get(cArray[i]) == null)
                    cur.children.put(cArray[i], new TreeNode(cArray[i]));
                cur = cur.children.get(cArray[i]);

            }
            cur.isWord();
        }


    }

    public List<String> complete(String prefix) {

        List<String> res = new ArrayList<>();
        char[] cArray = prefix.toCharArray();
        TreeNode cur = root;
        for (char c: cArray) {
            if (cur == null) return res;
            cur = cur.children.get(c);
        }

        completeHelper(res, new StringBuilder(prefix), cur);

        return res;
    }

    //Depth first search helper, add all completed words into list
    private void completeHelper(List<String> list, StringBuilder tmp, TreeNode cur) {
        if (cur == null) return;
        if (cur.isWord) {
            list.add(tmp.toString());
        }

        for (TreeNode node: cur.children.values()) {
            tmp.append(node.cha);
            completeHelper(list, tmp, node);
            tmp.delete(tmp.length() - 1, tmp.length());

        }
    }

    public static void main(String[] args) {

        String[] sArray = { "bat", "ball", "barrage", "barrier", "bell"};
        String[] sArray2 = {
                "whids",
               "whyever",
               "whiff",
               "whiffable",
               "whiffed",
               "Whiffen",
               "whiffenpoof",
               "whiffer",
               "whiffers",
               "whiffet",
               "whiffets",
               "whiffy",
               "whiffing",
               "whiffle",
               "whiffled",
               "whiffler",
               "whifflery",
               "whiffleries",
               "whifflers",
               "whiffles",
               "whiffletree",
               "whiffletrees",
               "whiffling",
               "whifflingly",
               "whiffs",
               "whyfor",
               "whift",
               "Whig"
        };

        AutoComplete a = new AutoComplete(sArray2);
        System.out.println(a.complete("whi"));

        System.out.println(a.complete("ba"));
        System.out.println(a.complete("be"));
        System.out.println(a.complete("a"));
        System.out.println(a.complete(""));

        //fizz buzz:
//        for (int i = 1; i <= 100; i++) {
//
//            if (i % 5 == 0 && i % 3 == 0) System.out.println("fizz buzz");
//            else if (i % 3 == 0) System.out.println("buzz");
//            else if (i % 5 == 0) System.out.println("fizz");
//            else System.out.println(i);
//        }

    }

}
