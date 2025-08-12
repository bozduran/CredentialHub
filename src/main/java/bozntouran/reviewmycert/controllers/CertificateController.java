package bozntouran.reviewmycert.controllers;


import bozntouran.reviewmycert.dto.CertificateDto;
import bozntouran.reviewmycert.dto.CertificateField;
import bozntouran.reviewmycert.entities.Certificate;
import bozntouran.reviewmycert.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CertificateController {

    private static final String CERTIFICATE_URL = "/api/certificate";
    private static final String CERTIFICATE_ID_URL = "/api/certificate/{id}";

    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService){
        this.certificateService = certificateService;
    }

    @GetMapping(CERTIFICATE_URL)
    public Page<CertificateDto> getCertificates(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Double startingRangePrice,
            @RequestParam(required = false) Double endRangePrice,
            @RequestParam(required = false) CertificateField certificateField,
            @RequestParam(required = false) Long companyId
            ){

        return this.certificateService.findAll(id,name,startingRangePrice,endRangePrice, certificateField,pageNumber,companyId);
    }

    @GetMapping(CERTIFICATE_ID_URL)
    public Certificate getCertificate(@PathVariable Long id){
        return certificateService.getCertificate(id).orElse(null);
    }

    //only admins
    @PostMapping(CERTIFICATE_URL + "-new")
    public ResponseEntity createNewCertificate(  Authentication authentication,
                                               @Validated @RequestBody Certificate certificate){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        System.out.println(userDetails.getUsername()+"/"+userDetails.getAuthorities());
        Certificate newCertificate = certificateService.saveNewCertificate(certificate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", CERTIFICATE_URL + "/"
        + newCertificate.getId());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    //only admins
    @DeleteMapping(CERTIFICATE_URL+ "-delete/{id}")
    public ResponseEntity deleteCertificate(@PathVariable Long id){

        if(!certificateService.deleteCertificateById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(CERTIFICATE_URL+"-patch")
    public ResponseEntity<Certificate> updateCertificate(@RequestBody Certificate updateCertificate){
        try {
            certificateService.updateCertificate(updateCertificate);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
