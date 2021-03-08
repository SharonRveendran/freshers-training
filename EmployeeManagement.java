import java.sql.SQLException;

import com.ideas2it.employeemanagement.view.EmployeeView;

/**
 * Doing CRUD operation in database
 * @author Sharon V
 * @created 08-03-2021
 */
public class EmployeeManagement {
    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
	EmployeeView employeeView = new EmployeeView();
	employeeView.getInput();
    }
}