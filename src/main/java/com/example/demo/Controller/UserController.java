package com.example.demo.Controller;

import com.example.demo.Model.Dto.UsuarioRequest;
import com.example.demo.Model.Dto.UsuarioResponse;
import com.example.demo.Model.Dto.UsuarioConsultaResponse;
import com.example.demo.Model.Dto.UsuarioCredencialesRequest;
import com.example.demo.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuario")
public class UserController {

    private final UsuarioService usuarioService;

    public UserController(UsuarioService usuarioService){

        this.usuarioService = usuarioService;

    }

    @PostMapping("/crear")
    public UsuarioResponse crear(@Valid @RequestBody UsuarioRequest ur){

        return usuarioService.crear(ur);

    }

    @PostMapping("/consultar")
    public ResponseEntity<UsuarioConsultaResponse> consultar(
            @Valid @RequestBody UsuarioCredencialesRequest request) {

        return usuarioService.consultar(request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

}
