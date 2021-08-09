package Usuario.rest;

import Modelo.Usuarios;
import Usuario.Service.UsuarioService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UsuarioREST {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private ResponseEntity<List<Usuarios>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping
    private ResponseEntity<Usuarios> saveUsuarios(@RequestBody Usuarios usuarios) {
        try {
            Usuarios usuarioGuardada = usuarioService.save(usuarios);
            return ResponseEntity.created(new URI("/Desarrollo/" + usuarioGuardada.getId())).body(usuarioGuardada);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "delete/{id}")
    private ResponseEntity<Boolean> deleteUsuarios(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.ok(!(usuarioService.findById(id) != null));

    }
}
