package org.example.adapters;

import org.exemple.data.ProductDto;
import org.exemple.ports.spi.ProductRestPort;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class ProductRestAdapter implements ProductRestPort {

    private final WebClient webClient;

    public ProductRestAdapter(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8089").build();
    }

    @Override
    public String getImagePath(ProductDto productDto) {
        return this.webClient.get().uri("/image/path").retrieve().bodyToMono(String.class).block();
    }
}
