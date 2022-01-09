package com.isa.ISAproject.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.isa.ISAproject.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{
	Instructor findByFirstNameAndLastName(String firstName, String lastName);
	List<Instructor> findByOrderByFirstName();
	List<Instructor> findByOrderByGradeDesc();
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select p from Instructor p where p.id = :id")
	//Postgres po defaultu poziva for update bez no wait, tako da treba dodati vrednost 0 za timeout
	//kako bismo dobili PessimisticLockingFailureException ako pri pozivu ove metode torka nije dostupna

	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
	public Instructor findOneById(@Param("id")Long id);
}
