package com.example.demo.dto;

import com.example.demo.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;
@Data
public class ProductDTO {

    private Long id;

    private String name;

    private  String description;

    private  Integer price;

    private MultipartFile image;

}
