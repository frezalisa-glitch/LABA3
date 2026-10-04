import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimesGenerator implements Iterable<Integer> {
    private final int count;

    public PrimesGenerator(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int found = 0;
            private int current = 2;

            @Override
            public boolean hasNext() {
                return found < count;
            }

            @Override
            public Integer next() {
                while (!isPrime(current)) {
                    current++;
                }
                found++;
                return current++;
            }

            private boolean isPrime(int n) {
                if (n < 2) return false;
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) return false;
                }
                return true;
            }
        };
    }

    public static void test(int n) {
        System.out.println("\n--- Задание 2 ---");
        PrimesGenerator gen = new PrimesGenerator(n);
        List<Integer> primes = new ArrayList<>();

        System.out.print("Прямой порядок: ");
        for (Integer p : gen) {
            System.out.print(p + " ");
            primes.add(p);
        }

        System.out.print("\nОбратный порядок: ");
        Collections.reverse(primes);
        for (Integer p : primes) System.out.print(p + " ");
        System.out.println();
    }
}