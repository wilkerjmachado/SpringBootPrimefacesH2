package org.enquete.app.dominio;

public enum EnumTipoEnquete {

	RESPOSTA("Pergunta e respostas"), VOTACAO("Pergunta com votação");
	
	private String chave;

	private EnumTipoEnquete(String chave) {
		this.chave = chave;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
	
}
