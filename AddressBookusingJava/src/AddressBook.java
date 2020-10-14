import java.util.*;

public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        AddressBookManager addressBookManager = new AddressBookManager();
        System.out.println("_______WELCOME TO ADDRESS_BOOK_______");
        while (true) {
            System.out.println("1) Add Person \n" + "2) Edit Person \n" + "3) Delete Person \n" + "4) Search Person \n"
                    + "5) Sort ByZip \n" + "6) Sort ByName \n" + "7) Display");
            int ch2 = sc.nextInt();
            switch (ch2) {
                case 1:
                    addressBookManager.addperson();
                    break;
                case 2:
                    addressBookManager.editperson();
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
                default:
                    System.out.println("Wrong Choice Entered Thank You....");
            }

        }
    }
}
