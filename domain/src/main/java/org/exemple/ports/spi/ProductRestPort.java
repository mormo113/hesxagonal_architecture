package org.exemple.ports.spi;

import org.exemple.data.ProductDto;

import java.util.List;

public interface ProductRestPort {

    String getImagePath(ProductDto productDto);
}
