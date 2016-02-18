package br.com.gracibolos.jdbc.dao;

import java.util.List;

public interface GenericoDao <E>{
	
    public boolean inserir(E e) throws Exception;
    public boolean alterar(E e) throws Exception;
    public boolean excluir(E e) throws Exception;
    //Interface para listar objetos, retorna uma lista
    public List<E> listar() throws Exception;
    //Interface de pesquisa, é passado um parametro e é retornado uma lista
    public List<E> pesquisar(String pesquisa) throws Exception;

}
