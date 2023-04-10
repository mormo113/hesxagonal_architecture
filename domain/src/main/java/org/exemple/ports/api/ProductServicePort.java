package org.exemple.ports.api;

import org.exemple.data.ProductDto;

import java.util.List;

public interface ProductServicePort {

    ProductDto addProduct(ProductDto productDto);

    List<ProductDto> getProducts();

    ProductDto getProductById(Long bookId);
}
