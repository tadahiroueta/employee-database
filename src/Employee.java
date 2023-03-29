public class Employee {
    protected int id;
    protected String name;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int hashCode(int tableSize) {
        return id % tableSize;
    }

    public boolean equals(Object other) {
        if (other instanceof Employee) {
            Employee otherEmployee = (Employee) other;
            return this.id == otherEmployee.id && this.name == otherEmployee.name;
        }
        return false;
    }
}
