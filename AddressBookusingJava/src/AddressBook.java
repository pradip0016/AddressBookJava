import java.util.*;
import java.io.*;
public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public static String fileNames;
    public static String path = "E:\\Pradip\\CSV\\";
    public static String key;
    public FileReader fr;
    public static int flag=0;
    public static FileWriter fileWriter;
    public static File file;
    public static BufferedWriter bw;
    public static BufferedReader br;
    public static HashMap<String, ArrayList<Person>> personarraylist1o = new HashMap<>(100);
    public static ArrayList<Person> personarraylist17 = new ArrayList<Person>(100);

    public static void main(String[] args) throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        System.out.println("_______WELCOME TO ADDRESS_BOOK_______");
        System.out.print("Enter the desired name of your Book: ");
        fileNames = sc.next();
        String fileName = fileNames + ".csv";
        file = new File(path + fileName + ".csv");
        if(file.isFile())
        {
            System.out.println("file already Present");
        }
        else
        {
                file.createNewFile();
                fileWriter = new FileWriter(file, true);
                bw = new BufferedWriter(fileWriter);
                bw.write("FirstName");
                bw.write(",Lastname");
                bw.write(",City");
                bw.write(",State");
                bw.write(",Zipcode");
                bw.write(",Phonenumber");
                bw.newLine();
                System.out.println("Address Book Created ");
                bw.close();
                fileWriter.close();

    }


        while (true) {
            System.out.println("1) Add Person \n" + "2) Save Person \n" + "3) Delete Person \n" + "4) Search Person \n"
                    + "5) Sort ByZip \n" + "6) Sort ByName \n" + "7) Display" + "8) edit Person \n");
            int ch2 = sc.nextInt();
            switch (ch2) {
                case 1:
                    personarraylist1o=addressBookManager.addperson(fileName);
                    Iterator it = personarraylist1o.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        key = (String) pair.getKey();
                        personarraylist17 = (ArrayList<Person>) pair.getValue();
                    }
                    break;
                case 2:
                    addressBookManager.savedata(key,personarraylist17);
                    break;
                case 3:
                    addressBookManager.deleteperson();
                    break;
                case 4:
                    addressBookManager.searchperson();
                    break;
                case 5:
                    addressBookManager.sortbyzipperson();
                    break;
                case 6:
                    addressBookManager.sortbynameperson();
                    break;
                case 7:
                    addressBookManager.Display();
                    break;
                case 8:
                    addressBookManager.editperson(fileNames);
                    break;
                default:
                    System.out.println("Wrong Choice Entered Thank You....");
            }

        }

        }
}
