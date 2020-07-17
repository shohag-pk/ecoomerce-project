package seu.edu.bd.ecommerceproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import seu.edu.bd.ecommerceproject.model.Product;
import seu.edu.bd.ecommerceproject.services.MapValidationErrorService;
import seu.edu.bd.ecommerceproject.services.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProduct(@Valid @RequestBody Product product, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if( errorMap != null) return errorMap;
        Product product1 = productService.createProduct(product);
        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Product> getAllProjects(){
        return productService.findAllProjects();
    }


    /*

    @GetMapping("/{productid}")
    public  ResponseEntity<?> getProductById(@PathVariable String productId){
        Product product = productService.findProductById(productId);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }  */

    @GetMapping("/{product_id}")
    public  ResponseEntity<?> getProductById(@PathVariable String product_id) {
      Product product =  productService.findProductById(product_id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}
