package org.enquete.framework.dominio;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@MappedSuperclass
public class Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "dataCriacao", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Transient
	private final String uuid = UUID.randomUUID().toString();

	@Version
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getUuid() {
		return uuid;
	}

	@PrePersist
	protected void onPrePersist() {
		if (this.dataCriacao == null) {
			this.setDataCriacao(Calendar.getInstance());
		}
	}
	
	@Override
	public int hashCode() {
		if (this.getId() != null) {
			return this.hashCodePeloId();
		}
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object objeto) {

		if (this == objeto) {
			return Boolean.TRUE;
		}
		
		if (objeto == null) {
			return Boolean.FALSE;
		}
		
		if (this.getClass() != objeto.getClass()) {
			return Boolean.FALSE;
		}

		if (this.getId() != null) {
			return this.equalsPeloId(objeto);
		}

		final Entidade other = (Entidade) objeto;

		if (this.uuid == null) {
			if (other.uuid != null) {
				return Boolean.FALSE;
			}

		} else if (!this.uuid.equals(other.uuid)) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	private int hashCodePeloId() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	private boolean equalsPeloId(final Object objeto) {

		final Entidade other = (Entidade) objeto;

		if (this.getId() == null) {
			if (other.getId() != null) {
				return Boolean.FALSE;
			}

		} else if (!this.getId().equals(other.getId())) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

}
