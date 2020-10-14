import java.io.*;
import java.util.*;

public class AddressBookManager implements AddressBookInterface {

    public String firstname;
    public String lastname;
    public String city;
    public String state;
    public int zipcode;
    public String phonenumber;
    public String str;
    public String num,find;
    int flag = 0;
    public  Scanner sc = new Scanner(System.in);
    public String fileName;
    public  String path = "E:\\Pradip\\CSV\\";
    public FileReader fr;
    public  FileWriter fileWriter;
    public  File file;
    public  BufferedWriter bw;
    public  BufferedReader br;
    public ArrayList<Person> personarraylist1 = new ArrayList<Person>(100);
    public HashMap<String, ArrayList<Person>> personarraylist11 = new HashMap<>(100);
    public HashMap<String, ArrayList<Person>> personarraylist1o = new HashMap<>(100);


    @Override
    public HashMap<String, ArrayList<Person>> addperson(String fileName) {
        System.out.println("How many data want to save in AddressBook :" + fileName);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter First Name :");
            firstname = sc.next();
            System.out.println("Enter Last Name :");
            lastname = sc.next();
            System.out.println("Enter City :");
            city = sc.next();
            System.out.println("Enter State :");
            state = sc.next();
            System.out.println("Enter Zip Code :");
            zipcode = sc.nextInt();
            System.out.println("Enter Phone Number :");
            phonenumber = sc.next();

            personarraylist1.add(
                    new Person(firstname + ",", lastname + ",", city + ",", state + ",", zipcode, "," + phonenumber));
            personarraylist11.put(fileName, personarraylist1);
        }
		return personarraylist11;
}


    @Override
    public void savedata(String key, ArrayList<Person> personarraylist13) throws IOException {
        fileWriter = new FileWriter(path + key + ".csv", true);
        bw = new BufferedWriter(fileWriter);
        for (int J = 0; J < personarraylist13.size(); J++) {
            num = personarraylist13.get(J).getPhonenumber().trim();
            System.out.println("checking with number " + num + " any data present or not");
            System.out.println("---------");
            System.out.println("------------");
            File input = new File((path + key + ".csv"));
            fr = new FileReader(input);
            br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                if (str.contains(num)) {
                    flag++;
                    find = str;
                }
            }
            br.close();
            if (flag == 0) {
                bw.write(personarraylist13.get(J).toString() + "\n");
                System.out.println("Data not present with " + num + " And Data Saved in AddressBook :" + key + ".csv");
            } else {
                System.out.println("Already Data present with same Number so try with different one -->" + find);
            }

        }
        bw.close();
        fileWriter.close();
    }




    @Override
        public String editperson () {
            return null;
        }

        @Override
        public String deleteperson () {
            return null;
        }

        @Override
        public String searchperson () {
            return null;
        }

        @Override
        public String sortbyzipperson () {
            return null;
        }

        @Override
        public String sortbynameperson () {
            return null;
        }

        @Override
        public String Display () {
            return null;
        }


    }

