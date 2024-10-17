package com.example.SeatBooking.Repositories;

import com.example.SeatBooking.Entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
  Optional<Employees> findByBemsId(Integer bemsId);

  List<Employees> findByManagerNameIsNullAndTeamLeadNameIsNull();

  List<Employees> findByTeamLeadNameIsNull();

  List<Employees> findByManagerNameIsNotNullAndTeamLeadNameIsNotNull();

  List<Employees> findByManagerName(String managerName);
}
