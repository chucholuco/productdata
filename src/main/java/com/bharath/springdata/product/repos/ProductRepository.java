package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByNameAndDesc(String name, String desc);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByDescContains(String desc);

    List<Product> findByPriceBetween(Double price1, Double price2);

    List<Product> findByDescLike(String desc);

    List<Product> findByIdIn(List<Integer> ids, Pageable pageable);

    @Query(value = "CALL GetAllProducts", nativeQuery = true)
    List<Product> findAllProductsSP();

    @Query(value = "CALL GetAllProductsByPrice (:price_in)", nativeQuery = true)
    List<Product> getAllProductsGraterByPriceSP(@Param("price_in") Double price);

    @Query(value = "CALL GetAllProductsCountByPrice (:price_in)", nativeQuery = true)
    int getAllProductsCountGreaterByPriceSP(@Param("price_in") Double price);

}
