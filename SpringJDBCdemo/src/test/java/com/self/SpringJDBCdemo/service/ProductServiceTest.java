package com.self.SpringJDBCdemo.service;

import com.self.SpringJDBCdemo.dto.ProductRequestDTO;
import com.self.SpringJDBCdemo.dto.ProductResponseDTO;
import com.self.SpringJDBCdemo.model.Product;
import com.self.SpringJDBCdemo.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    ProductService productService;
    @Test
    void createProduct_shouldSaveProductAndReturnResponseDTO() {
        ProductRequestDTO requestDTO = new ProductRequestDTO();
        requestDTO.setName("Laptop");
        requestDTO.setPrice(75000.0);

        Product savedProduct = new Product();
        savedProduct.setName("Laptop");
        savedProduct.setPrice(75000.0);

        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setName("Laptop");
        responseDTO.setPrice(75000.0);

        when(productRepository.save(any(Product.class)))
                .thenReturn(savedProduct);

        when(modelMapper.map(any(Product.class), eq(ProductResponseDTO.class)))
                .thenReturn(responseDTO);

        // Act
        ProductResponseDTO result = productService.createProduct(requestDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        assertEquals(75000.0, result.getPrice());

        verify(productRepository, times(1)).save(any(Product.class));
        verify(modelMapper, times(1))
                .map(any(Product.class), eq(ProductResponseDTO.class));
    }
}