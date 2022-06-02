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

import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.model.Instructor;
@Repository
public interface CottageRepository extends JpaRepository<Cottage, Long>{
	List<Cottage> findByName(String name);
	List<Cottage> findByAddress(String address);
	List<Cottage> findByOrderByName();
	List<Cottage> findByPrice(double price);
	List<Cottage> findByGrade(double grade);
	List<Cottage> findByOrderByGradeDesc();
	List<Cottage> findByOrderByPriceDesc();
	List<Cottage> findByCottageOwner(CottageOwner cottageOwner);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select p from Cottage p where p.id = :id")
	//Postgres po defaultu poziva for update bez no wait, tako da treba dodati vrednost 0 za timeout
	//kako bismo dobili PessimisticLockingFailureException ako pri pozivu ove metode torka nije dostupna

	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
	public Cottage findOneById(@Param("id")Long id);
}
