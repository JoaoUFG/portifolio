package br.ufg.sep.views.questoes.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.EventListenerList;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;

import br.ufg.sep.data.services.ProvaService;
import br.ufg.sep.data.services.QuestaoService;
import br.ufg.sep.entity.Prova;
import br.ufg.sep.entity.Questao;
import br.ufg.sep.views.questoes.NovaQuestaoObjetivaView;
import br.ufg.sep.views.questoes.VisualizarQuestaoObjetivaView;
import br.ufg.sep.views.questoes.QuestoesProvaView;

public class VisualizarQuestaoObjetivaPresenter {
	private ProvaService provaService;
	private QuestaoService questaoService;
	private VisualizarQuestaoObjetivaView view;
	
	public VisualizarQuestaoObjetivaPresenter(ProvaService provaService,
			QuestaoService questaoService, VisualizarQuestaoObjetivaView view) {
		
		this.provaService = provaService;
		this.questaoService = questaoService;
		this.view = view;
		
		//chama o diálogo para confirmar o envio da questao
		view.getEnviarButton().addClickListener( e->{
			view.getEnvioDialogo().getDialog().open();
		});
		
		//se confirmar o envio, chama o método que irá salvar e enviar a questão
		view.getEnvioDialogo().getEnviarDialogButton().addClickListener(e->{
			view.getEnvioDialogo().getDialog().close();
			enviarQuestao(e);
		});
		
		//se cancelar o envio, simplesmente fecha o diálogo
		view.getEnvioDialogo().getcancelarDialogButton().addClickListener(e->{
			view.getEnvioDialogo().getDialog().close();
		});
				
		view.getVoltarButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				voltar(event);
			}
		});
		
	}
	
	private void enviarQuestao(ClickEvent<Button> event) {
		//pegando a questao que está na view e chamando o método de envio
		view.getQuestaoObjetiva().enviarParaRevisao(null);
		
		questaoService.salvarEnvio(view.getQuestaoObjetiva());	
		
		/*Operacao bem sucedida*/
		Notification notification = Notification
		        .show("Questão enviada para Revisão 1");
		notification.setPosition(Position.TOP_CENTER);
		notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
		
		//volta para a página anterior
		voltar(event);
	}
	
	private void voltar(ClickEvent<Button> event) {
		
		Long idProva = view.getQuestaoObjetiva().getProva().getId();
		
		event.getSource().getUI().ifPresent(ui -> ui.navigate(QuestoesProvaView.class, idProva));
	}

}
