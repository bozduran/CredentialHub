package bozntouran.reviewmycert.mapper;

import bozntouran.reviewmycert.dto.ReviewDto;
import bozntouran.reviewmycert.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper MAPPER = Mappers.getMapper(ReviewMapper.class);

    @Mapping(source = "stars", target = "stars")
    @Mapping(source = "comment", target = "comment")
    @Mapping(source = "updateDate", target = "updateDate")
    @Mapping(source = "userData.username", target = "username")
    ReviewDto fromReview(Review review);

}
