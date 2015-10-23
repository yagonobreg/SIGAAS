package br.com.sigaas.beans;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.sigaas.util.CalendarUtil;






@ManagedBean
@SessionScoped
public class AgendaBean {
	private Date diaAgenda;
	private String view;
	
	
	public AgendaBean() {
		this.diaAgenda = new Date();
		this.view = "month";
	}
	
	public Date getDiaAgenda() {
		return diaAgenda;
	}
	public void setDiaAgenda(Date diaAgenda) {
		this.diaAgenda = diaAgenda;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public void mudarViewMes(){
		this.view = "month";
	}
	
	public void mudarViewSemana(){
		this.view = "agendaWeek";
	}
	
	public void mudarViewDia(){
		this.view = "agendaDay";
	}
	
	public void nextPrevious(String event){
		System.out.println(event);
	      int moveValue = event.equals("next")?1:-1;
	      Calendar cal = CalendarUtil.getAsCalendar(this.diaAgenda);
	      if(this.getView().equals("agendaDay"))
	         cal.add(Calendar.DAY_OF_MONTH, moveValue);
	      else if(this.getView().equals("agendaWeek"))
	         cal.add(Calendar.WEEK_OF_MONTH, moveValue);
	      else if(this.getView().equals("month"))
	         cal.add(Calendar.MONTH, moveValue);
	      this.setDiaAgenda(cal.getTime());
	   }
	public void mudarHoje(){
		this.diaAgenda = new Date();
	}
}
