package bozntouran.reviewmycert.entities;

import bozntouran.reviewmycert.dto.CertificateField;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private int version;

    private double price;

    @Enumerated(EnumType.STRING)
    private CertificateField field;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonBackReference
    private Company company;

    public void setCompany(Company company) {
        //company.getCertificates().add(this);
        this.company = company;
    }

    @OneToMany(mappedBy = "certificate",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Review> reviews;

}
