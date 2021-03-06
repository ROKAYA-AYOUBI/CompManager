package com.manager.CampChildreanHolydayManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ProgrammeAlimentaireService {
	 @Autowired
	    private ProgrammeAlimentaireRepository PArepo;
	     
	    public List<ProgrammeAlimentaire> listAll() {
	        return PArepo.findAll();
	    }
	     
	    public void save(ProgrammeAlimentaire programmealimentaire) {
	        PArepo.save(programmealimentaire);
	    }
	     
	    public ProgrammeAlimentaire get(long id) {
	        return PArepo.findById(id).get();
	    }
	     
	    public void delete(long id) {
	        PArepo.deleteById(id);
	    }

}

   
