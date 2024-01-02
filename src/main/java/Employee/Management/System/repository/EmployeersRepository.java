package Employee.Management.System.repository;

import Employee.Management.System.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeersRepository extends JpaRepository<Employee, Long > {
}
