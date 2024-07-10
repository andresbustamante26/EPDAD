package com.bustamante.infraccionservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bustamante.infraccionservice.entity.Infraccion;
import com.bustamante.infraccionservice.service.InfraccionService;

@RestController
@RequestMapping("/infracciones")
public class InfraccionController {

    @Autowired
    private InfraccionService service;

    @GetMapping
    public ResponseEntity<List<Infraccion>> getAll() {
        List<Infraccion> infracciones = service.getAll();
        return new ResponseEntity<>(infracciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infraccion> get(@PathVariable("id") int id) {
        Infraccion infraccion = service.get(id);
        if (infraccion != null) {
            return new ResponseEntity<>(infraccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Infraccion> create(@RequestBody Infraccion infraccion) {
        Infraccion nuevaInfraccion = service.create(infraccion);
        return new ResponseEntity<>(nuevaInfraccion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Infraccion> update(@PathVariable("id") int id, @RequestBody Infraccion infraccion) {
        infraccion.setId(id);
        Infraccion infraccionActualizada = service.update(infraccion);
        if (infraccionActualizada != null) {
            return new ResponseEntity<>(infraccionActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Infraccion> delete(@PathVariable("id") int id) {
        Infraccion infraccion = service.delete(id);
        if (infraccion != null) {
            return new ResponseEntity<>(infraccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
