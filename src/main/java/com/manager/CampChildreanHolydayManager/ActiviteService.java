package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActiviteService {
	 @Autowired
	    private ActiviteRepository Arepo;
	     
	    public List<Activite> listAll() {
	        return Arepo.findAll();
	    }
	     
	    public void save(Activite activite) {
	        Arepo.save(activite);
	    }
	     
	    public Activite get(long id) {
	        return Arepo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        Arepo.deleteById(id);
	    }
}
