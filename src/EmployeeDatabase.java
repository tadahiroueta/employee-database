public class EmployeeDatabase {
    protected int tableSize = 11;
    private Employee[] set;
    private int size = 0;

    public EmployeeDatabase() { set = new Employee[tableSize]; }

    public EmployeeDatabase(int tableSize) {
        this.tableSize = tableSize;
        set = new Employee[tableSize];
    }

    public int size() { return size; }

    public boolean add(Employee key) {
        for (int i = key.hashCode(tableSize); i < tableSize; i++) {
            int theRealI = i % tableSize;
            Employee servant = set[theRealI];
            if (servant == null) {
                set[theRealI] = key;
                size++;
                return true;
            }
            if (servant.equals(key)) break;
        }
        return false;
    }

    public boolean contains(Employee key) {
        for (int i = key.hashCode(tableSize); i < tableSize; i++) {
            int theRealI = i % tableSize;

            if (set[theRealI] == null) break;
            if (set[theRealI].equals(key)) return true;
        }
        return false;
    }

    private boolean justRemove(Employee key) {
        for (int i = key.hashCode(tableSize); i < tableSize; i++) {
            int theRealI = i % tableSize;
            if (set[theRealI] == null) break;

            if (set[theRealI].equals(key)) {
                set[theRealI] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean remove(Employee key) {
        if (!justRemove(key)) return false;
        
        for (int i = 0; i < tableSize; i++) {
            Employee temp = set[i];
            if (temp == null) continue;

            set[i] = null;
            add(temp);
        }
        return true; 
    }

    @Override
    public String toString() {
        String output = "";
        for (Employee employee : set) output += (employee == null ? "null" : employee.name) + ", ";
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
}
