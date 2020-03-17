package com.manager.CampChildreanHolydayManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class PersonneService {
    @Autowired
    private PersonneRepository repo;
     
    public List<Personne> listAll() {
        return repo.findAll();
    }
     
    public void save(Personne personne) {
        repo.save(personne);
    }
     
    public Personne get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
