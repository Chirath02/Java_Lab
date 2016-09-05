import java.io.*;
import java.util.*;

class StationaryBonus implements Serializable{
    String name;
    String item;
    int total;
    double unitPrice;
    double bonus;
    StationaryBonus(){
    }
    StationaryBonus(String name, String item, int total, double unitPrice){
        this.name = name;
        this.item = item;
        this.total = total;
        this.unitPrice =unitPrice;
        this.bonus = 0;
    }
    StationaryBonus(String name, String item, int total, double unitPrice, double bonus){
        this.name = name;
        this.item = item;
        this.total = total;
        this.unitPrice =unitPrice;
        this.bonus = bonus;
    }
    double calculateTotalPrice(){
        return unitPrice * total;
    }
    int getTotal() {
        return total;
    }
    void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class StationaryBonusDemo {
    public ArrayList<StationaryBonus> als = new ArrayList<StationaryBonus>();

    void readFromFile(String filename) throws IOException, FileNotFoundException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = null;
        while((line = br.readLine()) != null){
            String[] elements = line.split(",");
            StationaryBonus s = new StationaryBonus (elements[0], elements[1], Integer.parseInt(elements[2]), Double.parseDouble(elements[3]));
            als.add(s);
        }

    }

    void readFromBinaryFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream s = new ObjectInputStream(in);
        StationaryBonus st = new StationaryBonus();
        try
        {
            for (;;)
            {
                st = (StationaryBonus)s.readObject();
                System.out.println(st.name + "\t" + st.item + "\t" + st.bonus);
            }
        }
        catch (EOFException exc)
        {
            System.out.println("End of file");
        }
        catch (IOException exc)
        {
            // some other I/O error: print it, log it, etc.
            exc.printStackTrace(); // for example
        }
        finally {
            if(s != null){
                s.close();
            }
        }

    }

    void addStationery(StationaryBonus s) {
        als.add(s);
    }

    void writeToBinaryFile(String filename) throws IOException {
        Iterator<StationaryBonus> is = als.iterator();
        ObjectOutputStream oos = null;
        FileOutputStream fout = null;
        try{
            fout= new FileOutputStream(filename);
            oos = new ObjectOutputStream(fout);
            System.out.println("writeToBinaryFile");
            while(is.hasNext()){
                StationaryBonus s = is.next();
                if(s.calculateTotalPrice() > 400 || s.getTotal() > 100) {
                    s.setBonus(0.1);
                }
                oos.writeObject(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(oos != null){
                oos.close();
            }
        }
    }
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        StationaryBonusDemo s = new StationaryBonusDemo();
        s.readFromFile("stationary.data.txt");   // Reads from a text file provided
        StationaryBonus st = new StationaryBonus ("Chirath", "Pencil", 95, 189.05, 0.1); // Create a new stationary object to add to the ListArray
        s.addStationery(st); // Adds a Stationery item to the list
        s.writeToBinaryFile("stationaryout.data");  // Writes to a binary file provided
        System.out.println("\nRead from Binary file\n");
        s.readFromBinaryFile("stationaryout.data"); // reads from a binary file
    }
}
