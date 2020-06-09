package Factory;

/**
 *
 * @author maazh
 */
public class PersonFactory {

    public Factory.Person getPerson(String PersonType) {
        if (PersonType == null) {
            return null;
        }
        if (PersonType.equalsIgnoreCase("Student")) {
            return new StudentsClass();
        } else if (PersonType.equalsIgnoreCase("employee")) {
            return new EmployeeClass();
        } else if (PersonType.equalsIgnoreCase("dept")) {
            return new DeptClass();
        }
        return null;
    }
}
