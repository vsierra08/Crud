package com.ejemplo1.ejemplo1;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface UsuarioRepositorio extends Repository< Usuario, Integer> {

    List<Usuario> findAll();

    Usuario findOne(int id);

    Usuario save(Usuario u);

    Void delete(Usuario u);

}
