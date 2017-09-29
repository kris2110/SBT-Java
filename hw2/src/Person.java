/**
 * Created by user on 29.09.2017.
 */
public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean marry(Person person) {
        if (this.spouse == person || this.man == person.man) {
            return false;
        }
        if (this.spouse != null) {
            this.divorce();
        }
        if (person.spouse != null) {
            person.divorce();
        }
        this.spouse = person;
        person.spouse = this;
        return true;
    }

    public boolean divorce() {
        if (this.spouse != null) {
            this.spouse.spouse = null;
            this.spouse = null;
            return true;
        }
        else return true;
    }

    public static void main(String[] args) {

    }
}