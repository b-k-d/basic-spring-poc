package com.bkdas.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Slf4j
public class Service<E,ID> implements BaseService<E,ID> {

    JpaRepository<E,ID> baseRepository;
    public Service(final JpaRepository baseRepository){
        this.baseRepository = baseRepository;
    }
    @Override
    public E create(E entity) {
        return baseRepository.save(entity);
    }

    @Override
    public E read(ID id) {
        return  baseRepository.findById(id).get();
    }

    @Override
    public E update(E entity) {
        return baseRepository.save(entity);
    }

    @Override
    public Boolean delete(ID id) {
        try {
            E entity = baseRepository.getOne(id);
            baseRepository.delete(entity);
            return Boolean.TRUE;
        }catch (final Exception ex){
            log.error("error in deleting entity");
            return Boolean.FALSE;
        }
    }

    @Override
    public List<E> all() {
        return baseRepository.findAll();
    }
}
