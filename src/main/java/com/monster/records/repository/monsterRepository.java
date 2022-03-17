package com.monster.records.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.records.model.monster;

@Repository
public interface monsterRepository extends JpaRepository <monster, Integer>{

	List<monster> findByCreature(String creature);
}
