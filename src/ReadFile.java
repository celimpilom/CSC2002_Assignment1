import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    File myObj;
    Scanner myReader;
    ArrayList<Float> list;
    
    
    ReadFile(String fileName) throws FileNotFoundException{
        myObj = new File("Files/" + fileName);
        myReader = new Scanner(myObj);
        list = new ArrayList<Float>();
    
    }
    void array() throws FileNotFoundException {
        if (myReader.hasNextLine()){
            myReader.nextLine();
        }
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            int indspace = data.indexOf(" ");
            int size = data.length();
            list.add(Float.parseFloat(data.substring(indspace + 1, size).replace(",",".")));
        }       
          myReader.close();
    }

    public ArrayList<ArrayList<Float>> splitarr(int fisize){
        ArrayList<ArrayList<Float>> l = new ArrayList<ArrayList<Float>> ();
        for (int i = 0; i < list.size()-fisize-1; i++){
            ArrayList<Float> n = new ArrayList<>();
            for (int j = 0; j < fisize; j++){
                n.add(list.get(i+j));
            }
            l.add(n);
        }
        return l;
    }


    public ArrayList<ArrayList<Float>> getArray(int flsize) throws FileNotFoundException{
        array();
        ArrayList<ArrayList<Float>> l = splitarr(flsize);
        return l;
    }

    public Float median(ArrayList<Float> l){
        Collections.sort(l);
        int m = l.size()/2;
        return l.get(m);
    }
    
}