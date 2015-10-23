package modelo2;

import java.util.Date;

import org.primefaces.model.ScheduleEvent;

public class RequisicaoEvent implements ScheduleEvent{
	
	private Requisicao2 requisicao;
	private String eventID;
	
	public RequisicaoEvent(Requisicao2 requisicao) {
		this.requisicao = requisicao;
	}
	
	@Override
	public Object getData() {
		return this.requisicao;
	}

	@Override
	public String getDescription() {
		return this.requisicao.getDescricao();
	}

	@Override
	public Date getEndDate() {
		return this.requisicao.getHorarioFinal();
	}

	@Override
	public Date getStartDate() {
		return this.requisicao.getHorarioInicio();
	}

	@Override
	public String getStyleClass() {
		return this.requisicao.getStatusRequisicao();
	}

	@Override
	public String getTitle() {
		return this.requisicao.getTitulo();
	}

	@Override
	public boolean isAllDay() {
		return false;
	}

	@Override
	public boolean isEditable() {
		return true;
	}
	
	@Override
	public String getId() {
		return this.eventID;
	}

	@Override
	public void setId(String arg0) {
		this.eventID = arg0;
	}
	
	public Requisicao2 getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao2 requisicao) {
		this.requisicao = requisicao;
	}

}
