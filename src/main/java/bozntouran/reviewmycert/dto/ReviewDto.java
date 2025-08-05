package bozntouran.reviewmycert.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReviewDto {

    private String username;
    private short stars;
    private LocalDateTime updateDate;
    private String comment;

}
