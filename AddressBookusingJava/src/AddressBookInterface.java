import java.io.*;
import  java.util.*;

public interface AddressBookInterface {

    public HashMap<String, ArrayList<Person>>  addperson(String fileName);

    public void savedata(String key,ArrayList<Person> personarraylist17) throws IOException;

    public String editperson(String fileNames) throws FileNotFoundException, IOException ;

    public String deleteperson(String fileName) throws  IOException ;

    public String searchperson(String fileName) ;

    public String sortbyzipperson(String fileName) throws   IOException,FileNotFoundException;

    public String sortbynameperson(String fileName) throws FileNotFoundException, IOException;

    public String Display(String fileName);

}
