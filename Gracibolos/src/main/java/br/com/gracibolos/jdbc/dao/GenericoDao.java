package br.com.gracibolos.jdbc.dao;

import java.util.List;

public interface GenericoDao <E>{
	
	//Padronizar os nomes dos m�todos e generalizar
    //Ctrl + Shift + i, acertar a importa��o
    public boolean inserir(E e);
    public boolean alterar(E e);
    public void excluir(Integer id);
    
    //List<> interface do ArrayList
    public List<E> listar();

}
