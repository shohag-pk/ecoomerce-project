package seu.edu.bd.ecommerceproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.edu.bd.ecommerceproject.exceptions.ProductIdException;
import seu.edu.bd.ecommerceproject.model.Product;
import seu.edu.bd.ecommerceproject.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Product createProduct (Product product){
        try{
            product.setProduct_id(product.getProduct_id().toUpperCase());
            return productRepository.save(product);
        }
        catch (Exception e) {
            throw new ProductIdException("product Id" + product.getProduct_id().toUpperCase() + "already exists");
        }
    }


    public Iterable<Product> findAllProjects(){
        return productRepository.findAll();
    }


    /*
    public Product findProductById(String productId){
        Product product = productRepository.findByProductId(productId.toUpperCase());
        if (product == null){
            throw new ProductIdException("Product ID"+productId+"does not exist");
        }

        return  product;
    }  */

    public Product findProductById(String product_id){
       Product product = productRepository.findAllById(product_id.toUpperCase());
        if (product == null){
            throw new ProductIdException("Product ID"+product_id+"does not exist");
        }

        return  product;
    }


}
