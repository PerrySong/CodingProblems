import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class WorstLink {

    int lines = 0;

    class Link{
        int score;
        String source;
        String dest;

        public Link(int score, String name, String dest) {
            this.score = score;
            this.dest = dest;
            this.source = name;
        }
    }

    public Link[] read(){
        Link[] links = new Link[50];
        try{
            BufferedReader br = new BufferedReader(new FileReader("links.txt"));
            String line;
            int i = 0;
            while((line = br.readLine()) != null) {
                String[] words = line.split(",");
                Link nl = new Link(Integer.valueOf(words[0]), words[1], words[2]);
                links[i++] = nl;

            }

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return links;
    }

    public Link[] source(String page) {
        if(page.trim().equals("finish.html")) {
            this.lines++;
            System.out.println("lines = " + lines);
            return null;
        }
        Link[] links= read();
        Link[] res = new Link[50];
        int i = 0;
        for(Link l: links) {
            if(l == null) break;
            if(l.source.trim().equals(page.trim())) {
                res[i++] = l;
            }
        }
        return res;
    }


    public void print(Link[] links) {
        for(Link l: links) {
            if(l == null) break;
            System.out.println(l.source);
        }
    }

    public double pos(Link[] links) {
        print(links);
        if(links == null) return 1;
        double total = 0;
        double small = links[0].score;
        for(Link l: links) {
            if(l == null) break;
            total += l.score;
        }
        double res = (total - small)/total;
        if(res == 0) {
            res = 1;
        }
        return res;
    }


    public static void main(String[] args) {
//        WorstLink a = new WorstLink();
////        WorstLink.Link[] links = a.source("start.html");
////        Queue<Link[]> queue = new LinkedList<>();
////
////        queue.offer(links);
////        double res = 1;
////        while(!queue.isEmpty()) {
////            for(Link l: links) {
////                if(l == null) break;
////                if (a.source(l.dest) != null && a.source(l.dest)[0] != null) {
////                    queue.offer(a.source(l.dest));
////                }
////            }
////            links = queue.poll();
////            res *= a.pos(links);
////
////
////            System.out.println("! res = " + res);
////        }
////        System.out.println("res = " + res);

        String word = "smmaaggemgegmseeemaaemgmaaemaasasesmgmegaeaagmmegssggaammmaagseeamemeaeaaegsmseemmsesagaggeaagmgagma";
        for(int i = 0; i < word.length()/2; i ++) {
            
        }


        long res = 1;
        long i = 1;
        for(i = 1;  res <= Math.pow(100, 10); i++) {
            res *= i;
            System.out.println(i);
        }
        System.out.println(i);
    }



}
