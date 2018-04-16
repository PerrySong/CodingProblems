import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Million {

    class Things {
        String thing;
        int money;
        public Things(String thing, int money) {
            this.thing =thing;
            this.money = money;
        }
    }
    Things[] ts;
    public Million() {
        this.ts = read();
    }

    public Things[] read(){
        Things[] ts = new Things[50];
        try{
            BufferedReader br = new BufferedReader(new FileReader("M.txt"));
            String line;
            line = br.readLine();
            int i = 0;
            while(line != null) {
                String[] words = line.split("£");
                ts[i++] = new Things(words[0], Integer.valueOf((words[1].replace(",", "").trim())));
                line = br.readLine();
            }

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return ts;
    }

    public void print(List<Things> list) {
        System.out.println("Here !!!");
        for(Things t: list) {
            if(t != null)
                System.out.println(t.thing + " " + t.money);

        }
        System.out.println("Finished !!!");
        System.out.println("  ");
    }

    public void findtodo() {
        todo(new ArrayList<Things>(), 0);
    }

    public void todo(List<Things> list, Integer total) {
        if(total == 1000000) {
            print(list);
            return;
        }
        if(total > 1000000) return;

        for(Things t: ts) {
            if(t == null) break;
            list.add(t);
            total += t.money;
            todo(new ArrayList(list), total);
            list.remove(list.size() - 1);
            total -= t.money;
        }
    }

    public static void main(String[] args) {
        Million a = new Million();
        a.findtodo();
    }
}

// ,Donut, Virginia, Mercury, yellow