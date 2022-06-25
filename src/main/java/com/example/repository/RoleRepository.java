package com.example.repository;

import com.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.id = :id")
    Role getRoleById(@Param("id") long id);

    @Query("SELECT r FROM Role r WHERE r.name = :name")
    Role getRoleByName(@Param("name") String name);
}
