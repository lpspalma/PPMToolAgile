package io.agileintelligence.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Project Name is required")
    private String projectName;
    @NotBlank(message="Project Identifier is required")
    @Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message="Project Description is required")
    private String description;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date start_date;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date end_date;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date created_At;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date updated_At;

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }
}
