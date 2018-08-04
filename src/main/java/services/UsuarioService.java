package services;

import daos.UsuarioDAO;
import entities.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
 
    @Autowired
    UsuarioDAO usuarioDAO;

    public void insert(Funcionario usuario) {
        usuarioDAO.insert(usuario);
    }

    public void update(Funcionario usuario) {
        usuarioDAO.update(usuario);
    }

    public void delete(Funcionario usuario) {
        usuarioDAO.delete(usuario);
    }

    public List<Funcionario> find() {
        return usuarioDAO.find(new Funcionario());
    }
    
    public List<Funcionario> find(Funcionario usuario) {
        return usuarioDAO.find(usuario);
    }

    public Funcionario loginUsuario( String login, String senha ) {
        return usuarioDAO.loginUsuario( login, senha );
    }

}
