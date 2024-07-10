package com.bustamante.infraccionservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bustamante.infraccionservice.entity.Infraccion;
import com.bustamante.infraccionservice.repository.InfraccionRepository;
import com.bustamante.infraccionservice.service.InfraccionService;

@Service
public class InfraccionServiceImpl implements InfraccionService {

    @Autowired
    private InfraccionRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Infraccion> getAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public Infraccion get(int id) {
        try {
            return repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public Infraccion create(Infraccion infraccion) {
        try {
            return repository.save(infraccion);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public Infraccion update(Infraccion infraccion) {
        try {
            Infraccion registro = get(infraccion.getId());
            if (registro == null) {
                return null;
            } else {
                registro.setDni(infraccion.getDni());
                registro.setFecha(infraccion.getFecha());
                registro.setTipo_infraccion(infraccion.getTipo_infraccion());
                registro.setUbicacion(infraccion.getUbicacion());
                registro.setDescripcion(infraccion.getDescripcion());
                registro.setMonto_multa(infraccion.getMonto_multa());
                registro.setEstado(infraccion.getEstado());
                repository.save(registro);
                return registro;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public Infraccion delete(int id) {
        try {
            Infraccion registro = get(id);
            if (registro == null) {
                return null;
            } else {
                repository.delete(registro);
                return registro;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
