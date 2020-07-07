package Models;

import Commons.ReadAndWriteCSV;
import java.util.HashMap;

public class Employee {
    private static HashMap<String, Employee> employees = new HashMap<String, Employee>();
    final static String fileName="FuramaResort/src/Data/Employee.csv";
    private String idEmployee;
    private String fullName;
    private int age;
    private String address;


    public Employee() {
    }

    public Employee(String idEmployee, String fullName, int age, String address) {
        this.idEmployee = idEmployee;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public static void show(){
        Employee.readAndAddArray();
        int i=0;
        for (Employee employee:employees.values()) {
            i++;
            System.out.print(i+". ");
            System.out.println(employee.toString());
        }
    }

    public static void readAndAddArray(){
        String str = ReadAndWriteCSV.readCSV(fileName);
        if(str.length()!=0) {
            String[] arrStrEmployee = str.split("\n");
            for (String strEmployee : arrStrEmployee) {
                String[] arr = strEmployee.split(",");
                Employee employee = new Employee(arr[0], arr[1], Integer.parseInt(arr[2]),arr[3]);
                employees.put(employee.getIdEmployee(), employee);
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
