package idv.shawn.backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.shawn.backend.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByNameLikeIgnoreCase(String name, Pageable page);

	int countByNameLikeIgnoreCase(String name);

}
