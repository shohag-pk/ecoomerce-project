package seu.edu.bd.ecommerceproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seu.edu.bd.ecommerceproject.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findAllById(String product_id);

    // Product findByProductId(String productId);
}
