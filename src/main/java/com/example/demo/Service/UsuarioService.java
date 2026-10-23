package com.example.demo.Service;

import com.example.demo.Model.Dto.UsuarioRequest;
import com.example.demo.Model.Dto.UsuarioResponse;
import com.example.demo.Model.Dto.UsuarioConsultaResponse;
import com.example.demo.Model.Dto.UsuarioCredencialesRequest;
import com.example.demo.Model.Entity.Usuario;
import com.example.demo.Model.Entity.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    //private static int id = 1;
    //private final List<Usuario> usuarios = new ArrayList<>();

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository ur){

        usuarioRepository = ur;

    }

    public UsuarioResponse crear (UsuarioRequest ur){

        Usuario usuario = Usuario.builder()
                //.id(id++)
                .nombre(ur.nombre())
                .apellido(ur.apellido())
                .email(ur.email())
                .password(ur.password())
                .edad(ur.edad())
                .build();

        usuarioRepository.save(usuario);

        return new UsuarioResponse(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getEdad());

    }

    public Optional<UsuarioConsultaResponse> consultar(UsuarioCredencialesRequest request) {

        return usuarioRepository.findByEmailAndPassword(request.email(), request.password())
                .map(usuario -> new UsuarioConsultaResponse(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEdad()
                ));

    }

}
