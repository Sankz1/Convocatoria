package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Docente;
import com.example.demo.models.Response.RequestDocente;
import com.example.demo.models.Response.Response;
import com.example.demo.repositories.DocenteRepository;

@Service
public class DocenteService {
	@Autowired
	private DocenteRepository docenteRepository;

	public List<Docente> getall() {

		return (List<Docente>) docenteRepository.findAll();

	}

	public Docente save(RequestDocente pDocente) {
		var cedulaDocente = Integer.parseInt(pDocente.getNumeroDocumento());
		var listaDocentes = getall();
		
		for (int i = 0; i < listaDocentes.size(); i++) {
			var docente = listaDocentes.get(i);
			if (docente.getTipoDocumento().equalsIgnoreCase(pDocente.getTipoDocumento())
					&& Integer.parseInt(docente.getNumeroDocumento()) == cedulaDocente) {
				return null;
			} 

		}
		
		return docenteRepository.save(mapperDocente(pDocente));
	}

	public Docente update(Docente pDocente) {
		Optional<Docente> existeDocente = docenteRepository.findById(pDocente.getId());
		if (existeDocente.isPresent()) {
            Docente docenteActualizado = existeDocente.get();
            docenteActualizado.setApellidos(pDocente.getApellidos());
            docenteActualizado.setEmail(pDocente.getEmail());
            docenteActualizado.setNombres(pDocente.getNombres());
            docenteActualizado.setMateria(pDocente.getMateria());
            docenteActualizado.setNumeroDocumento(pDocente.getNumeroDocumento());
            docenteActualizado.setTipoDocumento(pDocente.getTipoDocumento());
            docenteActualizado.setTelefono(pDocente.getTelefono());
            
            return docenteRepository.save(docenteActualizado);
		} else {
			return null;
		}

	}

	public boolean delete(int Id) {
		try {
			return docenteRepository.existsById(Id) ? eliminarDocente(Id) : false;
		} catch (Exception ex) {
			return false;
		}

	}

	private boolean eliminarDocente(int Id) {
		docenteRepository.deleteById(Id);
		return true;
	}

	private Docente mapperDocente(RequestDocente docente) {
		
		Docente doc = new Docente();
		doc.setApellidos(docente.getApellidos());
		doc.setEmail(docente.getEmail());
		doc.setNombres(docente.getNombres());
		doc.setMateria(docente.getMateria());
		doc.setNumeroDocumento(docente.getNumeroDocumento());
		doc.setTipoDocumento(docente.getTipoDocumento());
		doc.setTelefono(docente.getTelefono());
		
		
		return doc;

	}
}