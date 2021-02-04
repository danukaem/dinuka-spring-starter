package com.dev.crudStarterPack.repository;

import com.dev.crudStarterPack.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
