package guru.springframework.springmvc.services;

import guru.springframework.springmvc.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    List<Product> removeProductById(Integer id);
}
