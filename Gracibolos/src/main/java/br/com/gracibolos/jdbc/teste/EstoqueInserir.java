package br.com.gracibolos.jdbc.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.gracibolos.jdbc.dao.EstoqueDao;
import br.com.gracibolos.jdbc.model.*;

//funcionando

//
public class EstoqueInserir {

	public static void main(String[] args) {
		
		//cria um novo objeto de estoque
		Estoque e1 = new Estoque();
		//esse big define o valor do preço unitário, na referência e1.setPrecoUnit
		BigDecimal big = new BigDecimal(7.00);
		
		//aqui eu seto os 3 IDs (MateriaPrima, Medida e Compra)
		//e converto eles de long para int para poder setar eles na referência e1 do objeto estoque
		Compra compra = new Compra();		
		compra.setId(1L);
		Integer c = Integer.valueOf(compra.getId().toString());
		
		MateriaPrima materia = new MateriaPrima();
		materia.setId(1L);	
		Integer mp = Integer.valueOf(materia.getId().toString());
		
		Medida medida = new Medida();
		medida.setId(1L);
		Integer m = Integer.valueOf(medida.getId().toString());
		
		e1.setMateriaPrimaId(mp);
		e1.setMedidaId(m);
		e1.setCompraId(c);
		e1.setQtd(33);
		e1.setPrecoUnit(big);
		e1.setVenc(LocalDate.now());
		
		//aqui eu multiplico a quantidade de items, pelo valor do preço unitário e seto isso no e1.setTotal
		int qtd = e1.getQtd();
		BigDecimal bd = new BigDecimal(qtd);
		BigDecimal precoUnit = e1.getPrecoUnit();		
		BigDecimal total = precoUnit.multiply(bd);		
		
		e1.setTotal(total);
		
		
		
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
