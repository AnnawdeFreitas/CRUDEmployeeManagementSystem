package Employee.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "Employeers")
@Getter
@ToString

public class Employee {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id ;

    private String name;

    private Double salary;

    public Employee() {

    }

    public Employee(Long id , String name, Double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }


    public void setId(Long id) {
        id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
