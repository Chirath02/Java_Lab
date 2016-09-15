import java.io.*;
import java.util.*;

class Stationary{
    String name;
    String item;
    int total;
    double unitPrice;
    Stationary(){
    }
    Stationary(String name, String item, int total, double unitPrice){
        this.name = name;
        this.item = item;
        this.total = total;
        this.unitPrice =unitPrice;
    }
    double calculateTotalPrice(){
        return unitPrice * total;
    }
}
class StationaryDemo{
    public static void main(String[] args) throws IOException, FileNotFoundException{
        ArrayList<Stationary> als = new ArrayList<Stationary>();
        BufferedReader br = new BufferedReader(new FileReader("stationary.data.txt"));
        String line = null;
        while((line = br.readLine()) != null){
            String[] elements = line.split(",");
            Stationary s = new Stationary(elements[0], elements[1], Integer.parseInt(elements[2]), Double.parseDouble(elements[3]));
            als.add(s);
        }
        Iterator<Stationary> is = als.iterator();
        while(is.hasNext()){
            Stationary s = is.next();
            System.out.println(s.name + "\t" + s.item);
        }
    }
}
