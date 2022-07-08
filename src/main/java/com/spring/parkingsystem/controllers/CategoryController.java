package com.spring.parkingsystem.controllers;

import com.spring.parkingsystem.dtos.RestResponse;
import com.spring.parkingsystem.dtos.category.CategoryFilterDto;
import com.spring.parkingsystem.dtos.category.CategoryHeaderDto;
import com.spring.parkingsystem.dtos.category.UpsertCategoryDto;
import com.spring.parkingsystem.services.abstraction.CrudService;
import com.spring.parkingsystem.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Qualifier("categoryMenu")
    @Autowired
    private CrudService service;

    private List<Object> getHeaderDto(Page<Object> pageCollection){
        Stream<Object> headerStream = pageCollection.toList().stream();
        var dtos = headerStream.map(row -> {
            Object dto = new CategoryHeaderDto(
                    MapperHelper.getStringField(row, 0),
                    MapperHelper.getIntegerField(row, 1),
                    MapperHelper.getIntegerField(row, 2)
            );
            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }

    @GetMapping(value={
            "",
            "/page={page}",
            "/id={id}",
            "/page={page}&id={id}"
    })
    public ResponseEntity<RestResponse<Object>> get(@PathVariable(required = false) Integer page, @PathVariable(required = false) String id){
        page = (page == null) ? 1 : page;
        id = (id == null) ? "" : id;
        try{
            Page<Object> pageCollection = service.getHeader(page, new CategoryFilterDto(id), CategoryFilterDto.class);
            List<Object> header = getHeaderDto(pageCollection);
            return new ResponseEntity<>(new RestResponse<>((header), "Succes", "200"), HttpStatus.OK);
//            return ResponseEntity.status(HttpStatus.OK).body(header);
        } catch (Exception exception){
            return new ResponseEntity<>(new RestResponse<>(null, exception.getMessage(), "500"), HttpStatus.INTERNAL_SERVER_ERROR);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }

    @PostMapping
    public ResponseEntity<RestResponse<Object>> post(@Valid @RequestBody UpsertCategoryDto dto, BindingResult bindingResult){
        try{
            if(!bindingResult.hasErrors()){
                Object respond = service.save(dto, UpsertCategoryDto.class);
                return new ResponseEntity<>(new RestResponse<>(respond, "Succes", "201"), HttpStatus.CREATED);
//                return ResponseEntity.status(HttpStatus.CREATED).body(respond);
            } else {
                return new ResponseEntity<>(new RestResponse<>(null, "Validation error", "422"), HttpStatus.UNPROCESSABLE_ENTITY);
//                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Validation Failed, Http Request Body is not validated.");
            }
        } catch (Exception exception){
            return new ResponseEntity<>(new RestResponse<>(null, exception.getMessage(), "500"), HttpStatus.INTERNAL_SERVER_ERROR);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }

    @PutMapping
    public ResponseEntity<RestResponse<Object>> put(@Valid @RequestBody UpsertCategoryDto dto, BindingResult bindingResult){
        try{
            if(!bindingResult.hasErrors()){
                service.save(dto, UpsertCategoryDto.class);
                return new ResponseEntity<>(new RestResponse<>((dto), "Succes", "200"), HttpStatus.OK);
//                return ResponseEntity.status(HttpStatus.OK).body(dto);
            } else {
                return new ResponseEntity<>(new RestResponse<>(null, "Validation error", "422"), HttpStatus.UNPROCESSABLE_ENTITY);
//                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Validation Failed, Http Request Body is not validated.");
            }
        }catch (Exception exception){
            return new ResponseEntity<>(new RestResponse<>(null, exception.getMessage(), "500"), HttpStatus.INTERNAL_SERVER_ERROR);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable(required = true) String id){
        try{
            service.delete(id);
            return new ResponseEntity<>(new RestResponse<>((id + " is deleted."), "Succes", "200"), HttpStatus.OK);
//            return ResponseEntity.status(HttpStatus.OK).body(id + " is deleted.");
        }catch (Exception exception){
            return new ResponseEntity<>(new RestResponse<>(null, exception.getMessage(), "500"), HttpStatus.INTERNAL_SERVER_ERROR);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }
}
