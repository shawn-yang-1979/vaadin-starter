package idv.shawn.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import idv.shawn.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
