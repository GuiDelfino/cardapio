package com.cardapio.menu_digital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardapio.menu_digital.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
