
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class phoneBook{
    private static HashMap<String,ArrayList> contacts = new HashMap<>();
    ArrayList<String[]> arrayStrings = new ArrayList<>();
        public static void main(String[] args){
            addContact("Иванов", "67589000-5");
            addContact("Петрова", "879000-5");
            addContact("Иванов", "75800-5");
            addContact("Иванов", "67392000-5");
            addContact("Васильев", "6433300-5");
            addContact("Мазур", "6000-5");

            printContacts();
    }

    public static void addContact(String name, String phoneNumber){
        if (contacts.containsKey(name)){
        ArrayList phoneNumbers = contacts.get(name);
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    } else {
        ArrayList phoneNumbers = new ArrayList();
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }
    }
  
    public static void printContacts(){
        ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList<>(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>(){
            @Override
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2){
            return o2.getValue().size() - o1.getValue().size();
            }
            });
            for(Map.Entry<String, ArrayList> entry: list){
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
    }
}    