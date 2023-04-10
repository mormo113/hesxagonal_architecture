package org.exemple.ports.spi;

import org.exemple.data.ProductDto;

import java.util.List;

public interface ProductPersistencePort {

    ProductDto addProduct(ProductDto productDto);


    List<ProductDto> getProducts();

    ProductDto getProductById(Long bookId);

}
