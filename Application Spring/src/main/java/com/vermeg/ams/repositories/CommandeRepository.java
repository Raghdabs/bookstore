package com.vermeg.ams.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.ams.entities.Commande;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Integer> {

}
