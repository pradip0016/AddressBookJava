import java.io.IOException;
import  java.util.*;

public interface AddressBookInterface {

    public HashMap<String, ArrayList<Person>>  addperson(String filename);

    public void savedata(String key,ArrayList<Person> personarraylist17) throws IOException;

    public String editperson() ;

    public String deleteperson() ;

    public String searchperson() ;

    public String sortbyzipperson() ;

    public String sortbynameperson() ;

    public String Display();

}
