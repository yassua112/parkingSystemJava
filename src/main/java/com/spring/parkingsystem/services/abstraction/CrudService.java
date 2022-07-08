package com.spring.parkingsystem.services.abstraction;


import org.springframework.data.domain.Page;

public interface CrudService {
    public Page<Object> getHeader(Integer page, Object filter, Class<?> filterType);
    public Object getUpdate(Object id);
    public Object save(Object dto, Class<?> dtoType);
    public Boolean delete(Object id);
}
