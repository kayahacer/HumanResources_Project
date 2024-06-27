package com.example.HR.service;

import com.example.HR.model.Employee;
import com.example.HR.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired //Spring bu alanı otomatik olarak inject/enjekte eder.
    private EmployeeRepository employeeRepository;

    //CRUD' un C harfi
    public Employee hireEmployee(Employee employee){
        //Yeni bir çalışanı veritabanına JPA' dan gelen 'save' metodu ile kaydeder.
        return employeeRepository.save(employee);
    }

    //CRUD' un R harfi
    public List<Employee> getAllEmployees(){
        //Tüm çalışanları veritabanından "findAll" metodu ile gösterilir.
        return employeeRepository.findAll();
    }


    public Optional<Employee> getEmployeeById(Long id){
        //Belirtilen kimlikteki çalışanı veri tabanından getirir.
        return employeeRepository.findById(id);
    }

    //CRUD' un U harfi
    public Employee updateEmployee(Long id, Employee employeeDetails){
        //Belirtilen kimlikte çalışanı güncelleyen metot.

        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
       //orElse yani if döngüsünün else kısmı gibi düşünebiliriz. Aradığımız çalışan bulunamadığı durumlarda
        //Kullanıcıya böyle bir metin gösteriyoruz.

        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        return employeeRepository.save(employee);
    }
    public void fireEmployee(Long id){
        //Belirtilen kimlikteki çalışanı silen metottur.

       //CRUD' un D harfi
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!"));
        //Silme işlemini yapan "delete" metodunu JPA repository içerisinden çağırarak kullandık.
        employeeRepository.delete(employee);
    }


}
