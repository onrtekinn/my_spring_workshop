package com.otekin.repo;

import com.otekin.entitiy.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressesRepository extends JpaRepository<Adress,Long> {
}
