import java.util.Map; 
import java.util.Set; 
import java.util.HashMap; 
import java.util.HashSet; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Map.Entry; 
 
public class PhoneBook { 
    public static void main(String[] args) { 
        Map<String, Set<String>> phoneBook = new HashMap<>(); 
 
        // Входные данные 
        String[][] contacts = { 
            {"Alice", "123456"}, 
            {"Bob", "789012"}, 
            {"Alice", "654321"}, 
            {"Alice", "987654"}, 
            {"Bob", "345678"} 
        }; 
 
        // Заполнение телефонной книги 
        for (String[] contact : contacts) { 
            String name = contact[0]; 
            String phone = contact[1]; 
 
            if (phoneBook.containsKey(name)) { 
                phoneBook.get(name).add(phone); 
            } else { 
                Set<String> phoneSet = new HashSet<>(); 
                phoneSet.add(phone); 
                phoneBook.put(name, phoneSet); 
            } 
        } 
 
        // Сортировка по убыванию числа телефонов 
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet()); 
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size())); 
 
        // Вывод результатов 
        for (Map.Entry<String, Set<String>> entry : sortedEntries) { 
            System.out.println(entry.getKey() + ": " + entry.getValue()); 
        } 
    } 
} 