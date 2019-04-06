package com.company.repository;

import com.company.domain.*;
import com.company.validation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCRUDRepository<ID, E extends HasID<ID>> implements CRUDRepository<ID, E>{
    Map<ID, E> entities;
    Validator<E> validator;

    public AbstractCRUDRepository(Validator validator) {
        entities = new HashMap<ID, E>();
        this.validator = validator;
    }

    @Override
    public E findOne(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID-ul nu poate fi null! \n");
        }
        else {
            return entities.get(id);
        }
    }

    @Override
    public Iterable<E> findAll() { return entities.values(); }

    @Override
    public E save(E entity) throws ValidationException {
        validator.validate(entity);
        return entities.putIfAbsent(entity.getID(), entity);
    }

    @Override
    public E delete(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID-ul nu poate fi nul! \n");
        }
        else {
            return entities.remove(id);
        }
    }

    @Override
    public E update(E entity) {
        validator.validate(entity);
        return entities.replace(entity.getID(), entity);
    }
}
