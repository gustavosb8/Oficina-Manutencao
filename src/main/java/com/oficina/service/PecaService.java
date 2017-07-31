package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Peca;
import com.oficina.repository.Pecas;

@Service
public class PecaService {

	@Autowired
    private Pecas repository;
     
    public List<Peca> findAll() {
        return repository.findAll();
    }
     
    public Peca findOne(Integer id) {
        return repository.findOne(id);
    }
     
    public Peca save(Peca peca) {

        return repository.saveAndFlush(peca);
    }
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}
