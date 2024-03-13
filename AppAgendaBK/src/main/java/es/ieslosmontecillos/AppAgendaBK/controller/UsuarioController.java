package es.ieslosmontecillos.AppAgendaBK.controller;

import es.ieslosmontecillos.AppAgendaBK.entity.Provincia;
import es.ieslosmontecillos.AppAgendaBK.entity.Usuario;
import es.ieslosmontecillos.AppAgendaBK.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value="/USUARIOS")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Usuario> list = usuarioService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/USUARIOS/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Usuario data = usuarioService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/USUARIOS")
    public ResponseEntity<Object> create(@RequestBody Usuario usuario){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Usuario res = usuarioService.save(usuario);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/USUARIOS/{id}")
    public ResponseEntity<Object> update(@RequestBody Usuario usuario,
                                         @PathVariable Long id){
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario currentUsuario = usuarioService.findById(id);
            if(currentUsuario != null) {
                currentUsuario.setUsername(usuario.getUsername());
                currentUsuario.setPassword(usuario.getPassword());
                Usuario res = usuarioService.save(currentUsuario);
                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {
                map.put("message", "Usuario no encontrado con id: " + id);
                return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}