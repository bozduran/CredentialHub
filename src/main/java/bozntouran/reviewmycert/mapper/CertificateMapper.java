package bozntouran.reviewmycert.mapper;

import bozntouran.reviewmycert.dto.CertificateDto;
import bozntouran.reviewmycert.entities.Certificate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CertificateMapper {

    CertificateMapper MAPPER = Mappers.getMapper(CertificateMapper.class);

    Certificate toCertificate(CertificateDto certificateDto);
    CertificateDto fromCertificate(Certificate certificate);
}
