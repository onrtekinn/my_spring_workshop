package com.otekin.services;

import com.otekin.dto.PersonDto;
import com.otekin.entitiy.Adress;
import com.otekin.entitiy.Employee;
import com.otekin.repo.AdressesRepository;
import com.otekin.repo.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonServicesImpl implements PersonServices{
    private final EmployeesRepository employeesRepository;
    private final AdressesRepository adressesRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        //String message;
        //Assert.isNull(personDto.getFirstname(),message="Firstname is required");
        
        Employee employee=new Employee();
        employee.setFirstname(personDto.getFirstname());
        employee.setLastname(personDto.getLastname());
        final Employee employeeDb =employeesRepository.save(employee);

        List<Adress> list=new ArrayList<>();
        personDto.getAdresses().forEach(item->{
            Adress adress=new Adress();
            adress.setAdress(item);
            adress.setAdressType(Adress.AdressType.etc);
            adress.setIsActive(true);
            adress.setEmployee(employeeDb);
            list.add(adress);
        });
        adressesRepository.saveAll(list);
        personDto.setId(employeeDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Employee> employees= employeesRepository.findAll();
        List<PersonDto>personDtos=new ArrayList<>();
        for (Employee item : employees) {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setFirstname(item.getFirstname());
            personDto.setLastname(item.getLastname());
            //personDto.setAdresses(item.getAdressesList().stream().map(Adress::getAdresses).collect(Collectors.toList());
            personDtos.add(personDto);
        }
        return personDtos;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
