package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio userRepository;

    @Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userEntity = userRepository.findByCorreoUsuario(username);
        System.out.println(userEntity.toString());
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return userEntity;
    }

}
