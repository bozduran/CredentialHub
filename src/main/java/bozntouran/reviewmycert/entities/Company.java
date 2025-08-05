package bozntouran.reviewmycert.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private String description;

    @Min(0)
    @Max(3000)
    private int yearOfFoundation;


    @OneToMany(mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Certificate> certificates;


}
/*
{
    "name":
    "description":
    "yearOfFoundation":

}



 */