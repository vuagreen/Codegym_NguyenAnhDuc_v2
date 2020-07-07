package Commons;
import Models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ArrayOop {
    private Object oop;
    public List<Object> arrayOops = new ArrayList<>();
    private String fileName;

    public <T> ArrayOop (String fileName, T t) {
        this.fileName = fileName;
        oop = t;
        this.readAndAddArray();
    }

    public  void addInput() {
        arrayOops.add(((FunctionArrays) oop).returnArraySetInput());
        this.writeArray();
    }

    public int show() {
        int i = 0;
        for (Object u : arrayOops) {
            i++;
            System.out.print(i + ". ");
            System.out.println(((FunctionArrays) u).showInfor());
        }
        return i;
    }

    public void showNameNotDuplicate(){
        TreeSet<String > nameObjects = new TreeSet<>();
        for (Object o:arrayOops) {
            nameObjects.add( ((FunctionArrays)o).getName());
        }
        for (String str:nameObjects) {
            System.out.println(str);
        }
    }

    public  void readAndAddArray() {
        String str = ReadAndWriteCSV.readCSV(this.fileName);
        if (str.length() != 0) {
            String[] arrStrVillas = str.split("\n");
            arrayOops.clear();
            for (String strVilla : arrStrVillas) {
                arrayOops.add(((FunctionArrays)oop).stringToObject(strVilla));
            }
        }
    }

    public void writeArray(){
        String str1="";
        for (Object o: arrayOops) {
            str1+=((FunctionArrays)o).objectToString((FunctionArrays)o);
        }
        ReadAndWriteCSV.writeCSV(fileName,str1);
    }

    public static void main(String[] args) {
        ArrayOop arrayOop = new ArrayOop("FuramaResort/src/Data/villa.csv",new Villa());
        arrayOop.addInput();
        arrayOop.writeArray();
        arrayOop.show();
    }
}
