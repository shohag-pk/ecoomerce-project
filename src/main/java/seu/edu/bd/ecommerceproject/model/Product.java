package seu.edu.bd.ecommerceproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message ="Product name is required")
    private String product_name;
    @NotBlank(message = "Product id is required")
    @Size(min=4, max=10, message = "Please use 4 to 10 characters")
    @Column(updatable = false, unique = true)
    private String product_id;
    @NotBlank(message ="Product price is required")
    private String price;
    @NotBlank(message = "Product description is required")
    private String description;
}
