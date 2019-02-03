import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    public static List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if (source == null || source.length == 0) return res;

        // If the ignore tag is true, the content is in between /* */
        boolean ignore = false;
        StringBuilder code = new StringBuilder();

        for (String line : source) {
            char[] charArr = line.toCharArray();
            // For each line, inspect evey char
            for (int i = 0; i < charArr.length; i++) {
                char c = charArr[i];
                // Pattern: "*/", end ignore
                if (c == '*' && i < charArr.length - 1 && charArr[i + 1] == '/') {
                    ignore = false;
                    i++;
                } else {
                    if (c == '/' && i < charArr.length - 1) {

                        // pattern: "//", ignore the rest of this line
                        if (charArr[i + 1] == '/') break;
                        //  pattern: "/*"
                        if (charArr[i + 1] == '*') {
                            ignore = true;
                            i++;
                        }


                    }

                    if (!ignore) {
                        code.append(c);
                    }
                }
            }

            if (code.length() > 0 && !ignore) {
                res.add(code.toString());
                code = new StringBuilder();
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeComments(new String[] {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"}));
    }
}
