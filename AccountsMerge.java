import java.util.*;

public class AccountsMerge {

    /**
         Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

         Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

         After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

         Example 1:
         Input:
         accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
         Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
         Explanation:
         The first and third John's are the same person as they have the common email "johnsmith@mail.com".
         The second John and Mary are different people as none of their email addresses are used by other accounts.
         We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
         ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
         Note:

         The length of accounts will be in the range [1, 1000].
         The length of accounts[i] will be in the range [1, 10].
         The length of accounts[i][j] will be in the range [1, 30].

     */
    //Question: is the given input sorted?
    // Not sure if collections.sort will sort the String
    // If the inners list is guareenteed have name and emails? size() >= 2?

    //T(n) = O(n ^ 3)
    //Question: is the given input sorted?
    // Not sure if collections.sort will sort the String
    // If the inners list is guareenteed have name and emails? size() >= 2?

    //T(n) = O(n ^ 2 * mlg(m))
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }


        int aNums = accounts.size();
        boolean[] visited = new boolean[aNums];

        // Traverse all accounts
        for (int i = 0; i < aNums; i++) {
            if (visited[i]) continue;
            List<String> tmp = accounts.get(i);
            for (int j = i + 1; j < aNums; j++) {
                List<String> testAccount = accounts.get(j);
                if (isSameAccount(testAccount, tmp)) {
                    mergeAccount(testAccount, tmp);
                    visited[j] = true;
                }
            }
            Collections.sort(tmp.subList(1, tmp.size()));
            dedupeSortedList(tmp);
            res.add(tmp);
        }

        return res;
    }

    // T(n) = O(m);
    private boolean isSameAccount(List<String> account1, List<String> account2) {
        if (account1 == null || account2 == null || account1.size() <= 1 || account2.size() <= 1) return false;
        if (!account1.get(0).equals(account2.get(0))) return false;

        int a1Nums = account1.size();
        int a2Nums = account2.size();

        Set<String> a1Emails = new HashSet<>();
        for (int i = 1; i < a1Nums; i++) {
            a1Emails.add(account1.get(i));
        }

        for (int j = 1; j < a2Nums; j++) {
            if (a1Emails.contains(account2.get(j))) return true;
        }

        return false;
    }

    //T(n) = O(mlog(m));
    //Merge the first account to the second one
    private void mergeAccount(List<String> account1, List<String> account2) {
        String name = account1.get(0);



        Set<String> emails = new HashSet<>();
        int a2Nums = account2.size();

        // Put account2's emails to a set
        for (int i = 1; i < a2Nums; i++) {
            if (!emails.add(account2.get(i))) {
                account2.remove(i--);
                a2Nums--;
            }
        }

        // Put account1's emails to account2 without duplicate
        int a1Nums = account1.size();
        for (int i = 1; i < a1Nums; i++) {
            String curEmail = account1.get(i);
            if (!emails.contains(curEmail)) account2.add(curEmail);
        }

    }

    private void dedupeSortedList(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).equals(list.get(i))) {
                list.remove(i--);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>( Arrays.asList(new String[] {"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"})));
        accounts.add(new ArrayList<>( Arrays.asList(new String[] {"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"})));
        accounts.add(new ArrayList<String>( Arrays.asList(new String[] {"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"})));
        accounts.add(new ArrayList<String>(Arrays.asList(new String[] {"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"})));
        accounts.add(new ArrayList<String>(Arrays.asList(new String[] {"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"})));

        AccountsMerge a = new AccountsMerge();
        System.out.println(a.accountsMerge(accounts));
    }
}
