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

        if (cur.isWord) {
            list.add(tmp.toString());
            return;
        }

        for (TreeNode node: cur.children.values()) {
            tmp.append(node.cha);
            completeHelper(list, tmp, node);
            tmp.delete(tmp.length() - 1, tmp.length());

        }

    }

    public static void main(String[] args) {
        String[] sArray = { "bat", "ball", "barrage", "barrier", "bell"};
        AutoComplete a = new AutoComplete(sArray);


        System.out.println(a.complete("ba"));
    }

}
