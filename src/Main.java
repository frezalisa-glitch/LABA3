import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Вызов 1 задания
        Task1.execute(10);

        // Вызов 2 задания
        PrimesGenerator.test(10);

        // Задание 3
        task3();

        // Задание 4
        task4("Apple banana apple Orange BANANA apple");

        // Задание 5
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One"); map.put(2, "Two");
        System.out.println("\nЗадание 5. Обмен: " + swapMap(map));
    }

    public static void task3() {
        System.out.println("\n--- Задание 3 ---");
        List<Human> humans = Arrays.asList(
                new Human("Иван", "Иванов", 20),
                new Human("Петр", "Алексеев", 25),
                new Human("Анна", "Иванова", 22)
        );

        System.out.println("HashSet (нет порядка): " + new HashSet<>(humans));
        System.out.println("LinkedHashSet (порядок добавления): " + new LinkedHashSet<>(humans));
        System.out.println("TreeSet (Comparable - фамилия+имя): " + new TreeSet<>(humans));

        TreeSet<Human> byLastName = new TreeSet<>(new HumanComparatorByLastName());
        byLastName.addAll(humans);
        System.out.println("TreeSet (по фамилии): " + byLastName);

        TreeSet<Human> byAge = new TreeSet<>(Comparator.comparingInt(h -> h.age));
        byAge.addAll(humans);
        System.out.println("TreeSet (анонимный по возрасту): " + byAge);

        /*
         Ответ на п.7:
         - HashSet: использует хеш-таблицу, порядок элементов не гарантирован.
         - LinkedHashSet: поддерживает порядок вставки элементов.
         - TreeSet: хранит элементы в отсортированном порядке (натуральном или через Comparator).
        */
    }

    public static void task4(String text) {
        System.out.println("\n--- Задание 4 ---");
        Map<String, Integer> freq = new HashMap<>();
        String[] words = text.toLowerCase().split("\\W+");
        for (String w : words) freq.put(w, freq.getOrDefault(w, 0) + 1);
        System.out.println("Частота слов: " + freq);
    }

    public static <K, V> Map<V, K> swapMap(Map<K, V> source) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : source.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }
}