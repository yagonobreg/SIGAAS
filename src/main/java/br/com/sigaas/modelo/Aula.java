package br.com.sigaas.modelo;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import br.com.sigaas.usertypes.StringArrayType;

import java.util.Arrays;
import java.util.List;


@Entity
@TypeDefs({ @TypeDef(name = "StringArrayType", typeClass = StringArrayType.class) })
public class Aula extends Requisicao implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Column(columnDefinition = "bpchar(8)")
	private String codDisciplina;
    
	private String nomeDisciplina;
	
	@Type(type = "StringArrayType")
	private String[] horario;

	@ManyToMany(mappedBy="aulas")
	private List<Usuario> docentes;

	public Aula() {
	}

	public String getCodDisciplina() {
		return this.codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}


	public String getNomeDisciplina() {
		return this.nomeDisciplina;
	}

	public void setNomedisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public List<Usuario> getUsuarios() {
		return this.docentes;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.docentes = usuarios;
	}
	
	public String[] getHorario() {
		return horario;
	}

	public void setHorario(String[] horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Aula [getCodDisciplina()=" + getCodDisciplina()
				+ ", getNomeDisciplina()=" + getNomeDisciplina()
				+ ", getUsuarios()=" + getUsuarios() + ", getHorario()="
				+ Arrays.toString(getHorario()) + ", getData_requisicao()="
				+ Arrays.toString(getData_requisicao()) + ", getId()="
				+ getId() + ", getMateriais()=" + getMateriais()
				+ ", getPapelusuario()=" + getPapelusuario()
				+ ", getQtdparticipantes()=" + getQtdparticipantes()
				+ ", getTipo()=" + getTipo() + ", getAmbiente()="
				+ getAmbiente() + ", getUsuario()=" + getUsuario()
				+ ", getSolicitacoesTroca()=" + getSolicitacoesTroca()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}