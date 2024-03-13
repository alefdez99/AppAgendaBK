package es.ieslosmontecillos.AppAgendaBK.services;

    import es.ieslosmontecillos.AppAgendaBK.entity.Usuario;
import java.util.List;

public interface UsuarioService
{
    List<Usuario> findAll();
    public Usuario save(Usuario provincia);
    Usuario findById(Long id);
}