package br.com.gracibolos.jdbc.dao;

import java.util.List;

public interface GenericoDao <E>{
	
	//Padronizar os nomes dos métodos e generalizar
    //Ctrl + Shift + i, acertar a importação
    public boolean inserir(E e);
    public boolean alterar(E e);
    public void excluir(Integer id);
    
    //List<> interface do ArrayList
    public List<E> listar();

}
