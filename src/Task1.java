import java.util.*;

public class Task1 {
    public static void execute(int n) {
        System.out.println("--- Задание 1 ---");
        // 1. Массив случайных чисел
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) array[i] = random.nextInt(101);
        System.out.println("Массив: " + Arrays.toString(array));

        // 2. Список List
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Список: " + list);

        // 3. Сортировка по возрастанию
        Collections.sort(list);
        System.out.println("Сортировка (возр): " + list);

        // 4. В обратном порядке
        Collections.reverse(list);
        System.out.println("Обратный порядок: " + list);

        // 5. Перемешать
        Collections.shuffle(list);
        System.out.println("Перемешан: " + list);

        // 6. Циклический сдвиг на 1
        Collections.rotate(list, 1);
        System.out.println("Сдвиг на 1: " + list);

        // 7. Только уникальные элементы
        List<Integer> unique = new ArrayList<>(new HashSet<>(list));
        System.out.println("Уникальные: " + unique);

        // 8. Только дублирующиеся элементы
        List<Integer> duplicates = new ArrayList<>();
        for (Integer i : list) {
            if (Collections.frequency(list, i) > 1 && !duplicates.contains(i)) {
                duplicates.add(i);
            }
        }
        System.out.println("Дубликаты: " + duplicates);

        // 9. Получение массива из списка
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("Массив из списка: " + Arrays.toString(newArray));

        // 10. Количество вхождений каждого числа
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer i : list) counts.put(i, counts.getOrDefault(i, 0) + 1);
        System.out.println("Частота чисел: " + counts);
    }
}