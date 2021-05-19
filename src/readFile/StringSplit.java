package readFile;

public class StringSplit {

    public String[] deleteAndSplit (String str){
        String[] rs;
        str = str.replace("(", " ");
        str = str.replace(")", " ");
        str = str.replace(",", " ");
        str = str.trim();
        rs = str.split("\\s+");
        return rs;
    }
}
