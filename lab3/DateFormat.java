import java.util.*;
import java.text.*;
import java.lang.*;
class DateFormat {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String str = new String();
        str = scanner.nextLine();
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(str);
        Date date = new Date();
        String outputDate = dateTimeFormat.format(date);
        System.out.println(outputDate);
   }
}

