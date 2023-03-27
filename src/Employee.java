public class Employee {
    protected int id;
    protected String name;
    final protected static int TABLE_SIZE = 10; // TODO change once there is more information 

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int hashCode() {
        return id;
    }

    public boolean equals(Object other) {
        if (other instanceof Employee) {
            Employee otherEmployee = (Employee) other;
            return this.id == otherEmployee.id;
        }
        return false;
    }
}
