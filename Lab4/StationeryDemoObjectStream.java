import java.io.*;
import java.util.*;

class Stationery implements Serializable{
    String name;
    String item;
    int total;
    double unitPrice;
    Stationery(){
    }
    Stationery(String name, String item, int total, double unitPrice){
        this.name = name;
        this.item = item;
        this.total = total;
        this.unitPrice =unitPrice;
    }
    double calculateTotalPrice(){
        return unitPrice * total;
    }
}

class StationeryDemoObjectStream {
    public ArrayList<Stationery> als = new ArrayList<Stationery>();

    void readFromFile(String filename) throws IOException, FileNotFoundException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = null;
        while((line = br.readLine()) != null){
            String[] elements = line.split(",");
            Stationery s = new Stationery (elements[0], elements[1], Integer.parseInt(elements[2]), Double.parseDouble(elements[3]));
            als.add(s);
        }

    }

    void addStationery(Stationery s) {
        als.add(s);
    }

    void readFromBinaryFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream s = new ObjectInputStream(in);
        Stationery st = new Stationery();
        try
        {
            for (;;)
            {
                st = (Stationery)s.readObject();
                System.out.println(st.name + "\t\t" + st.item);
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

    void writeToBinaryFile(String filename) throws IOException {
        Iterator<Stationery> is = als.iterator();
        ObjectOutputStream oos = null;
        FileOutputStream fout = null;
        try{
            fout= new FileOutputStream(filename);
            oos = new ObjectOutputStream(fout);
            System.out.println("writeToBinaryFile");
            while(is.hasNext()){
                Stationery s = is.next();
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
        StationeryDemoObjectStream s = new StationeryDemoObjectStream();
        s.readFromFile("stationary.data.txt");   // Reads from a text file provided
        Stationery st = new Stationery ("Chirath","Pencil",95,189.05); // Create a new stationary object to add to the ListArray
        s.addStationery(st); // Adds a Stationery item to the list
        s.writeToBinaryFile("stationaryout.data");  // Writes to a binary file provided
        System.out.println("\nRead from Binary file\n");
        s.readFromBinaryFile("stationaryout.data"); // reads from a binary file
    }
}
