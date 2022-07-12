package com.integrador.digitalBooking.controller;

import com.integrador.digitalBooking.exceptions.BadRequestsExceptions;
import com.integrador.digitalBooking.exceptions.ResourceNotFoundException;
import com.integrador.digitalBooking.model.dto.UsuarioDTO;
import com.integrador.digitalBooking.service.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    private final IUsuarioService service;
    private final PasswordEncoder passwordEncoder;
    public UsuarioController(IUsuarioService service, PasswordEncoder passwordEncoder){
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }


    @Operation(summary = "Crear un usuario.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @PostMapping
    public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuario, BindingResult bindingResult) throws BadRequestsExceptions {
        if(bindingResult.hasErrors())
            throw new BadRequestsExceptions("Campos mal diligenciados o email inválido.");
        if (service.existsByEmail(usuario.getEmail()))
            throw new BadRequestsExceptions("El correo ya se encuentra registrado.");

        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombre(),usuario.getApellido(),usuario.getEmail(),usuario.getCiudad(),passwordEncoder.encode(usuario.getClave()), usuario.getRol());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.agregarUsuario(usuarioDTO));
    }

    @Operation(summary = "Buscar usuario por su ID.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        UsuarioDTO usuarioDTO = service.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @Operation(summary = "Buscar usuario por email.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping("/user/{email}")
    public ResponseEntity<UsuarioDTO> buscarPorEmail(@PathVariable String email) throws ResourceNotFoundException {
        UsuarioDTO usuarioDTO = service.listarPorEmail(email);
        return ResponseEntity.ok(usuarioDTO);
    }

    @Operation(summary = "Actualizar los datos de un usuario.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @PutMapping
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws BadRequestsExceptions {
        return ResponseEntity.ok(service.actualizarUsuario(usuarioDTO));
    }

    @Operation(summary = "Eliminar un usuario por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) throws ResourceNotFoundException {
        service.eliminarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado exitosamente.");
    }

    @Operation(summary = "Listar Usuarios.")
    @CrossOrigin(origins = "https://barbimt.github.io")
    @GetMapping
    public ResponseEntity<Collection<UsuarioDTO>> listarUsuarios(){
        Collection<UsuarioDTO> listaDeUsuarios = service.listarUsuarios();
        return ResponseEntity.ok(listaDeUsuarios);
    }

}
