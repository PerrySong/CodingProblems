import java.util.*;

import static com.sun.xml.internal.xsom.impl.UName.comparator;

public class WordLadderII {
    /**
         Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

         Only one letter can be changed at a time
         Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
         Note:

         Return an empty list if there is no such transformation sequence.
         All words have the same length.
         All words contain only lowercase alphabetic characters.
         You may assume no duplicates in the word list.
         You may assume beginWord and endWord are non-empty and are not the same.
         Example 1:

         Input:
         beginWord = "hit",
         endWord = "cog",
         wordList = ["hot","dot","dog","lot","log","cog"]

         Output:
         [
         ["hit","hot","dot","dog","cog"],
         ["hit","hot","lot","log","cog"]
         ]
         Example 2:

         Input:
         beginWord = "hit"
         endWord = "cog"
         wordList = ["hot","dot","dog","lot","log"]

         Output: []

         Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */

    class TreeNode {
        String val;
        ArrayList<TreeNode> children;
        boolean isEnd;

        public TreeNode(String val) {
            children = new ArrayList<>();

            this.val = val;
            isEnd = false;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) return res;
        Set<String> wordSet = new HashSet(wordList);
        if (!wordSet.contains(endWord)) return res;
        Set<String> visited = new HashSet<>();


        Queue<TreeNode> queue = new LinkedList<>();

        visited.add(beginWord);
        TreeNode head = new TreeNode(beginWord);
        queue.offer(head);
        boolean end = false;

        while (!queue.isEmpty() && !end) {
            int size = queue.size();
            Set<String> thisLevelWords = new HashSet<>();
            for (int count = 0; count < size; count++) {
                TreeNode curNode = queue.poll();
                char[] curWord = curNode.val.toCharArray();


                for (int i = 0; i < curWord.length; i++) {

                    char curChar = curWord[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curWord[i] = c;
                        String curString = new String(curWord);
                        if (curString.equals(endWord)) {

                            curNode.isEnd = true;
                            end = true;
                            break;
                        } else if (wordSet.contains(curString) && !visited.contains(curString)) {

                            thisLevelWords.add(curString);
                            TreeNode nextNode = new TreeNode(curString);
                            curNode.children.add(nextNode);
                            queue.offer(nextNode);

                        }
                        curWord[i] = curChar;

                    }
                }
            }

            visited.addAll(thisLevelWords);
        }

        dfsTree(res, new ArrayList<>(), head, endWord);
        return res;

    }

    private void dfsTree(List<List<String>> res, List<String> tmpList, TreeNode curNode, String endWord) {
        if (curNode.isEnd) {
            List<String> newPath = new ArrayList<>(tmpList);
            newPath.add(curNode.val);
            newPath.add(endWord);
            res.add(newPath);
            return;
        }
        List<TreeNode> children = curNode.children;
        if (children == null || children.size() == 0) return;

        tmpList.add(curNode.val);
        for (int i = 0; i < children.size(); i++) {
            TreeNode nextNode = children.get(i);
            dfsTree(res, tmpList, nextNode, endWord);
        }
        tmpList.remove(tmpList.size() - 1);
    }

    public static void main(String[] args) {
        String[] dict = new String[] {"ted","tex","red","tax","tad","den","rex","pee"};

        WordLadderII a = new WordLadderII();
        System.out.println(a.findLadders("red", "tax", Arrays.asList(dict)));
    }

}
