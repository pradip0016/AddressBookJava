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
        System.out.println("How many data do you want to save in AddressBook :" + fileName);
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
          String  name = personarraylist13.get(J).getFirstname().trim();
            System.out.println("checking with number " + num + " any data present or not");
            System.out.println("---------");
            System.out.println("------------");
            File input = new File((path + key + ".csv"));
            fr = new FileReader(input);
            br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                if (str.contains(name)) {
                    flag++;
                    find = str;
                }
            }
            br.close();
            if (flag == 0) {
                bw.write(personarraylist13.get(J).toString() + "\n");
                System.out.println("Data not present with " + name + " And Data Saved in AddressBook :" + key + ".csv");
            } else {
                System.out.println("Already Data present with same Number so try with different one -->" + find);
            }

        }
        bw.close();
        fileWriter.close();
    }

    @Override
        public String editperson (String fileName) throws FileNotFoundException, IOException {
        System.out.println("Enter number for edit person data\n");
        String lineToFind = sc.next();
        File inFile = new File((path + fileName + ".csv"));
        File tempFile = new File(path + fileName + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader(inFile));
        bw = new BufferedWriter(new FileWriter(tempFile));
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.trim().contains(lineToFind)) {
                System.out.println("Data found for given number\n" + line);
                String[] persondrtails = line.split(",");
                String firstname = persondrtails[0];
                String lastname = persondrtails[1];
                System.out.println("enter the city");
                String c = sc.next();
                System.out.println("enter the State");
                String s = sc.next();
                System.out.println("enter the Zipcode");
                int z = sc.nextInt();
                String phonenumber = persondrtails[5];
                bw.write(firstname);
                bw.write("," + lastname);
                bw.write("," + c);
                bw.write("," + s);
                bw.write("," + z);
                bw.write("," + phonenumber);
                bw.newLine();
                flag++;
            } else {
                bw.write(line);
                bw.newLine();
            }

        }
        bw.close();
        br.close();
        inFile.delete();
        tempFile.renameTo(inFile);
        if (flag == 0) {
            System.out.println("Data not found in AddressBook :" + fileName);
        } else {
            System.out.println("Data Modified Successfully..");
        }

        return null;

    }

        @Override
        public String deleteperson (String fileName) throws  IOException{
            System.out.println("Enter Name for Delete");
            String lineToRemove = sc.next();
            File inFile = new File((path + fileName + ".csv"));
            File tempFile = new File(path + fileName + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            while ((line = br.readLine()) != null) {
                if (!line.trim().contains(lineToRemove)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            inFile.delete();
            System.out.println("Data deleted From AddressBook");
            tempFile.renameTo(inFile);
            System.out.println(" ");
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

