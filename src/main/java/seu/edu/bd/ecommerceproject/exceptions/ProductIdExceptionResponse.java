package seu.edu.bd.ecommerceproject.exceptions;

public class ProductIdExceptionResponse {

    private String product_id;

    public ProductIdExceptionResponse(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

}
