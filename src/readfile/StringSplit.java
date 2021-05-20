package readfile;

public class StringSplit {

    public String[] deleteAndSplit (String str){
        String[] rs;
        str = str.replace("(", " ");
        str = str.replace(")", " ");
        str = str.replace(",", " ");
        str = str.trim();
        rs = str.split("\\s+");
        int i = 0;
        for (String r: rs){
            rs[i] = r.trim();
            i++;
        }
        return rs;
    }
}
