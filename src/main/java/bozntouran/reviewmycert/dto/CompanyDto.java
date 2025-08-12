package bozntouran.reviewmycert.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDto {

    private Long id;
    private String name;
    private int yearOfFoundation;
}
