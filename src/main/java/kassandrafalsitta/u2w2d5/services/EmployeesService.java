package kassandrafalsitta.u2w2d5.services;

import kassandrafalsitta.u2w2d5.entities.Employee;
import kassandrafalsitta.u2w2d5.exceptions.NotFoundException;
import kassandrafalsitta.u2w2d5.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    public Page<Employee> findAll(int page, int size, String sortBy) {
        if (page > 100) page = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.employeesRepository.findAll(pageable);
    }

    //save

    public Employee findById(UUID employeeId) {
        return this.employeesRepository.findById(employeeId).orElseThrow(() -> new NotFoundException(employeeId));
    }


}
