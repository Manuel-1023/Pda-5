package com.almora.almora.Services.impl;

import com.almora.almora.Model.Donacion;
import com.almora.almora.Repository.DonacionRepository;
import com.almora.almora.Services.DonacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionServiceImpl implements DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    @Override
    public Donacion guardarDonacion(Donacion donacion) {
        return donacionRepository.save(donacion);
    }

    @Override
    public List<Donacion> listarDonaciones() {
        return donacionRepository.findAll();
    }

    @Override
    public Optional<Donacion> obtenerPorId(String id) {
        return donacionRepository.findById(id);
    }

    @Override
    public void eliminarDonacion(String id) {
        donacionRepository.deleteById(id);
    }
}
