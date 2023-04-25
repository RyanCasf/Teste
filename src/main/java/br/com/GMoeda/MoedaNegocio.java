package br.com.GMoeda;

import java.io.Serializable;
import java.sql.SQLClientInfoException;

public class MoedaNegocio implements Serializable {
	
    private Moeda moeda = new Moeda();
    private MoedaInterface mDAO = new MoedaDAO();
    
    public MoedaNegocio(MoedaInterface mDAO) {
    	moeda = new Moeda();
        this.mDAO = mDAO;
    }
    
    public Long salvar() throws Exception {
        if (moeda.getSimbolo() == null || moeda.getSimbolo().trim().isEmpty()) {
            return null;
        }
        
    	return mDAO.salvar(moeda);
    }
    
    public Moeda getMoeda() {
		return moeda;
	}
    
    public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
}