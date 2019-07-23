package com.stackroute;
import com.stackroute.Configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee employee = applicationContext.getBean("employee", Employee.class);

        employee.setId(505);

        employee.setName("Harsha");

        employee.setAge(22);

        employee.setGender("male");

        CrudOperationsDemo crudOperationsDemo = applicationContext.getBean("crudOperationsDemo", CrudOperationsDemo.class);

        //create employee
        crudOperationsDemo.addEmployee(employee);

        //select employee
        crudOperationsDemo.getEmployeeDetails();

        //update employee by id
        crudOperationsDemo.updateEmployee(505, new Employee(505,"Harsha",23,"male"));

        crudOperationsDemo.getEmployeeDetails();

        //delete employee by id
        crudOperationsDemo.deleteEmployee(505);


        Employee employee1 = applicationContext.getBean("employee", Employee.class);

        employee.setId(603);

        employee.setName("Poornima");

        employee.setAge(22);

        employee.setGender("female");

        JdbcTemplateDemo jdbcTemplateDemo = applicationContext.getBean("jdbcTemplateDemo",JdbcTemplateDemo.class);

        jdbcTemplateDemo.deleteEmployee(603);

        jdbcTemplateDemo.saveEmployee(employee);

        jdbcTemplateDemo.updateEmployee(603,new Employee(603,"poori",23,"female"));
    }
}