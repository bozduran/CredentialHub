package bozntouran.credentialhub.controllers;


import bozntouran.credentialhub.entities.Certificate;
import bozntouran.credentialhub.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    public List<Certificate> getAllCertificates(){
        return this.certificateService.getCertificates();

    }

    @GetMapping(CERTIFICATE_ID_URL)
    public Certificate getCertificate(@PathVariable Long id){
        return certificateService.getCertificate(id).orElse(null);
    }

    @PostMapping(CERTIFICATE_URL + "-new")
    public ResponseEntity createNewCertificate(@Validated @RequestBody Certificate certificate){
        System.out.println(certificate.toString());
        Certificate newCertificate = certificateService.saveNewCertificate(certificate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", CERTIFICATE_URL + "/"
        + newCertificate.getId());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping(CERTIFICATE_URL+ "-delete/{id}")
    public ResponseEntity deleteCertificate(@PathVariable Long id){

        if(!certificateService.deleteCertificateById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
