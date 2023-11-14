package com.cibertec.assistanceapi.repositories;

import com.cibertec.assistanceapi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Query("SELECT e FROM Employee e " +
			"WHERE (:name IS NULL OR e.name LIKE %:name%) " +
			"AND (:dni IS NULL OR e.dni = :dni) " +
			"AND e.state = :state " +
			"AND (:area = -1 OR e.area.id_area = :area)")
	public List<Employee> listEmployeesByNameDNIEstadoArea(
			@Param("name") String name,
			@Param("dni") String dni,
			@Param("state") int state,
			@Param("area") int area
	);

	@Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
	public List<Employee> listByNameLike(@Param("name") String name);

	@Query("SELECT e FROM Employee e WHERE e.dni = :dni")
	public List<Employee> listEmployeesByDNI(@Param("dni") String dni);

}
