package com.spring.parkingsystem.controllers;

import com.spring.parkingsystem.dtos.RestResponse;
import com.spring.parkingsystem.dtos.arsip.ArsipFilterDto;
import com.spring.parkingsystem.dtos.arsip.ArsipHeaderDto;
import com.spring.parkingsystem.services.abstraction.CrudService;
import com.spring.parkingsystem.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/arsip")
public class ArsipController {
    @Qualifier("arsipMenu")
    @Autowired
    private CrudService service;

    private List<Object> getHeaderDto(Page<Object> pageCollection){
        Stream<Object> headerStream = pageCollection.toList().stream();
        var dtos = headerStream.map(row -> {
            Object dto = new ArsipHeaderDto(
                    MapperHelper.getIntegerField(row, 0),
                    MapperHelper.getLocalDateTimeField(row, 1),
                    MapperHelper.getLocalDateTimeField(row, 2),
                    MapperHelper.getIntegerField(row, 3),
                    MapperHelper.getStringField(row, 4)
            );
            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }


    @GetMapping(value={
            "",
            "/page={page}",
            "/keterangan={keterangan}",
            "/page={page}&keterangan={keterangan}"
    })
    public ResponseEntity<RestResponse<Object>> get(@PathVariable(required = false) Integer page, @PathVariable(required = false) String keterangan){
        page = (page == null) ? 1 : page;
        keterangan = (keterangan == null) ? "" : keterangan;
        try{
            Page<Object> pageCollection = service.getHeader(page, new ArsipFilterDto(keterangan), ArsipFilterDto.class);
            List<Object> header = getHeaderDto(pageCollection);
            return new ResponseEntity<>(new RestResponse<>((header), "Succes", "200"), HttpStatus.OK);
//            return ResponseEntity.status(HttpStatus.OK).body(header);
        } catch (Exception exception){
            return new ResponseEntity<>(new RestResponse<>(exception.getMessage(),"There is a run-time error on the server.", "500"), HttpStatus.INTERNAL_SERVER_ERROR);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }
}
