import java.util.Objects;

public class Human implements Comparable<Human> {
    String firstName, lastName;
    int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Human o) {
        int res = this.lastName.compareTo(o.lastName);
        if (res == 0) res = this.firstName.compareTo(o.firstName);
        if (res == 0) res = Integer.compare(this.age, o.age);
        return res;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " (" + age + ")";
    }

    // hashCode и equals важны для HashSet!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return age == human.age && Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}