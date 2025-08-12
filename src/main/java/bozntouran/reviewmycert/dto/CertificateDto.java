package bozntouran.reviewmycert.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CertificateDto {
    private Long id;
    private String name;
    private double price;
    private CertificateField field;
    private String description;

}
