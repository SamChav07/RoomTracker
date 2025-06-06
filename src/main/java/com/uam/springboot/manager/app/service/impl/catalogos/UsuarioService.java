package com.uam.springboot.manager.app.service.impl.catalogos;

import com.uam.springboot.manager.app.dto.catalogos.requestDTOs.UsuarioRequestDTO;
import com.uam.springboot.manager.app.dto.catalogos.responseDTOs.UsuarioResponseDTO;
import com.uam.springboot.manager.app.mapper.catalogos.UsuarioMapper;
import com.uam.springboot.manager.app.model.catalogos.Usuario;
import com.uam.springboot.manager.app.repository.catalogos.UsuarioRepository;
import com.uam.springboot.manager.app.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends CrudServiceImpl<Usuario, UsuarioRequestDTO, UsuarioResponseDTO, Long>
        implements UserDetailsService {

    // 1) Guarda el repositorio en un campo de instancia
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        super(repository, mapper);
        this.usuarioRepository = repository;  // así ya tienes acceso al repositorio
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 2) Aquí llamas a findByEmail sobre la instancia usuarioRepository, no sobre la clase
        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPasswordHash())
                .roles("USER")
                .build();
    }

    @Override
    public UsuarioResponseDTO create(UsuarioRequestDTO dto){

        Usuario usuario = mapper.toEntity(dto);
        System.out.println("Entidad antes de persistir: " + usuario);

        String hashedPassword = passwordEncoder.encode(usuario.getPasswordHash());

        usuario.setPasswordHash(hashedPassword);

        return mapper.toDto(repository.save(usuario));
    }

}
