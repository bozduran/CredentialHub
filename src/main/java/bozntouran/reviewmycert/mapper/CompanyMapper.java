package bozntouran.reviewmycert.mapper;

import bozntouran.reviewmycert.dto.CompanyDto;
import bozntouran.reviewmycert.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);

    Company toCompany(CompanyDto companyDto);
    CompanyDto fromCompany(Company company);
}
