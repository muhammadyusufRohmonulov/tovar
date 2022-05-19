package com.example.tovar.Repository;

import com.example.tovar.Model.Tovar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TovarRepository extends JpaRepository<Tovar, Integer> {
}
