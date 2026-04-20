package com.almora.almora.Repository;

import com.almora.almora.Model.Donante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonanteRepository extends MongoRepository<Donante, String> {
    // Puedes agregar consultas personalizadas si lo necesitas, por ejemplo:
    // Optional<Donante> findByCorreo(String correo);
}
