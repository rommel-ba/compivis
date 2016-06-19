package hibernate;

import java.util.List;

public interface HibernatePersist <E>{
    public void salvar (E objeto);
    public void atualizar (E objeto);
    public void deletar (E objeto);
    public List listarTodos ();
    public List listarAtivo(String nome);
}
