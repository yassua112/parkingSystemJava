package com.spring.parkingsystem.services.implementation;

import com.spring.parkingsystem.dtos.arsip.ArsipFilterDto;
import com.spring.parkingsystem.repositories.ArsipRepository;
import com.spring.parkingsystem.services.abstraction.CrudService;
import com.spring.parkingsystem.utility.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("arsipMenu")
public class ArsipImplementationService implements CrudService {

    @Autowired
    private ArsipRepository arsipRepository;

    private final int rowsInPage = 10;

    @Override
    public Page<Object> getHeader(Integer page, Object filter, Class<?> filterType) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        String keterangan = MapperHelper.getStringField(filter, "keterangan", ArsipFilterDto.class);
        Page<Object> header = arsipRepository.findAll(keterangan, pagination);
        return header;
    }

    @Override
    public Object getUpdate(Object id) {
        return null;
    }

    @Override
    public Object save(Object dto, Class<?> dtoType) {
        return null;
    }

    @Override
    public Boolean delete(Object id) {
        return null;
    }
}
