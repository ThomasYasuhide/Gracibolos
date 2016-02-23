package br.com.gracibolos.jdbc.teste;

import java.util.Calendar;

import br.com.gracibolos.jdbc.dao.EstoqueDao;
import br.com.gracibolos.jdbc.model.*;

//funcionando
public class EstoqueInserir {

	public static void main(String[] args) {
		
		Estoque e1 = new Estoque();
		
		Compra c= new Compra();		
		c.setId(1);
		
		MateriaPrima mp = new MateriaPrima();
		mp.setId(1);
		
		Medida m = new Medida();
		m.setId(1);
		
		e1.setQtd(33);
		e1.setPrecoUnit(null);
		e1.setVenc(Calendar.getInstance());
		e1.setTotal(null);
		e1.setCompraId(c.getId());
		e1.setMateriaPrimaId(mp.getId());
		e1.setMedidaId(m.getId());
		
		EstoqueDao dao = new EstoqueDao();
		
		try {
			if(dao.inserir(e1) == true){
				System.out.println("inserido com sucesso");
			}else{
				System.out.println("falha");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
