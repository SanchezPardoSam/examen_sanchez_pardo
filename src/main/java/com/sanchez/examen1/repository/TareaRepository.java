package com.sanchez.examen1.repository;

import java.util.List;

import com.sanchez.examen1.model.TareaModel;

public interface TareaRepository {
	public List<TareaModel> getAll();
	
	public TareaModel getById(Integer id);
	
    public int create(TareaModel obj);
    
    public void update(TareaModel obj);
    
    public void delete(int id);
}
