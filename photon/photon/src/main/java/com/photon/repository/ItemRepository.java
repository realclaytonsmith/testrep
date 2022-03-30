package com.photon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.photon.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
