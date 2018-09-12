public class AddAndSearchWord {
    /**
         Design a data structure that supports the following two operations:

         void addWord(word)
         bool search(word)
         search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

         Example:

         addWord("bad")
         addWord("dad")
         addWord("mad")
         search("pad") -> false
         search("bad") -> true
         search(".ad") -> true
         search("b..") -> true
         Note:
         You may assume that all words are consist of lowercase letters a-z.
     */
    class Node {
        boolean isWord;
        char val;
        Node[] children;
        public Node(char val, boolean isWord) {
            this.val = val;
            children = new Node[26];
            this.isWord = isWord;
        }
    }

    private Node head; // Store a dummy node that have 26 children
    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        head = new Node('A', false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null) return;
        char[] cArr = word.toCharArray();
        Node cur = head;
        for (char c : cArr) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node(c, false);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return true;
        return search(word, this.head);
    }

    /**
     Return true if there is word under the given head
     */
    public boolean search(String word, Node head) {
        if (word == null || head == null) return false;
        if (word.length() == 0 && head.isWord) return true;
        if (word.length() == 0) return false;
        char c = word.charAt(0);
        if (c == '.') {
            for (Node child : head.children) {
                if (search(word.substring(1, word.length()), child))
                    return true;
            }
            return false;
        }
        return search(word.substring(1, word.length()), head.children[c - 'a']);
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
