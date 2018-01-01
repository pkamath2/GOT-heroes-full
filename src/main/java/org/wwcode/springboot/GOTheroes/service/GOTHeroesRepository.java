package org.wwcode.springboot.GOTheroes.service;

import org.springframework.data.repository.CrudRepository;
import org.wwcode.springboot.GOTheroes.bo.GOTHero;

public interface GOTHeroesRepository extends CrudRepository<GOTHero, Integer>{
}
