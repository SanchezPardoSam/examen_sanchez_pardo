package com.sanchez.examen1.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanchez.examen1.model.TareaModel;
import com.sanchez.examen1.repository.TareaRepository;
import com.sanchez.examen1.services.TareaService;

@Service
public class TareaServiceImpl implements TareaService {
	@Autowired
    private TareaRepository repo;


	@Override
	public List<TareaModel> getAll() {
		return repo.getAll();
	}

	@Override
	public TareaModel getById(Integer id) {
		return repo.getById(id);
	}

	@Override
	public int create(TareaModel obj) {
	    int retorno = 0;
        retorno = repo.create(obj);
	    return retorno;
	}

	@Override
	public int update(TareaModel obj) {
	    int retorno = 0;
	    if(obj.getId() == 0){
	        repo.update(obj);
	        retorno=obj.getId();
	    }
	    return retorno;
	}

	@Override
	public void delete(int id) {
		repo.delete(id);		
	}
}
