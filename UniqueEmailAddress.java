import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            emailSet.add(parseEmail(email));
        }
        return emailSet.size();
    }

    private static String parseEmail(String email) {
        String[] components = email.split("@");
        String localName = components[0];

        localName = localName.split("\\+")[0];
        localName = localName.replaceAll(".", "");
        System.out.println(localName + components[1]);
        return localName + "@" + components[1];
    }

    public static void main(String[] args) {
        numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
    }
}
