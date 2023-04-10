package org.exemple.service;

import org.exemple.data.ProductDto;
import org.exemple.ports.api.ProductServicePort;
import org.exemple.ports.spi.ProductPersistencePort;
import org.exemple.ports.spi.ProductRestPort;

import java.util.List;

public class ProductServiceImpl implements ProductServicePort {

    private ProductPersistencePort productPersistencePort;
    private ProductRestPort productRestPort;

    public ProductServiceImpl(ProductPersistencePort productPersistencePort, ProductRestPort productRestPort) {
        this.productPersistencePort = productPersistencePort;
        this.productRestPort = productRestPort;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return productPersistencePort.addProduct(productDto);
    }

    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> availableProducts = productPersistencePort.getProducts();
        return availableProducts.stream()
                        .map(jpaProduct -> {
                            var imagePath = productRestPort.getImagePath(jpaProduct);
                            jpaProduct.setImagePath(imagePath);
                            return jpaProduct;
                        })
                .toList();

    }

    @Override
    public ProductDto getProductById(Long bookId) {
        return productPersistencePort.getProductById(bookId);
    }
}
