package AtendimentoHospitalar;

import Repositorio.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class Principal {

	public static void Deletar() {
		
		String CPF;
		int opt = 0;
		
		CPF = JOptionPane.showInputDialog("Informe seu CPF: ");
		
		PacienteRepositorio prepos = new PacienteRepositorio();
		UsuarioRepositorio urepos = new UsuarioRepositorio();
		ProfissionalRepositorio prorepos = new ProfissionalRepositorio();

		
		if(prepos.List("Select * from Paciente where CPF = '"+CPF+"'") != null) {
			
			CartaoSUSRepositorio cartaorepos = new CartaoSUSRepositorio();
			AcompanhanteRepositorio acompanharepos = new AcompanhanteRepositorio();
			
			cartaorepos.Delete("Delete from Cartao_SUS where CPF_Paciente = '"+CPF+"'");
			acompanharepos.Delete("Delete from Acompanhante where CPF_do_Paciente = '"+CPF+"'");
			urepos.Delete("Delete from Usuario where CPF_Paciente = '"+CPF+"'");
			
			prepos.Delete("Delete from Paciente where CPF = '"+CPF+"'");
		}
		
		
		if(prorepos.List("Select * from Profissional where CPF = '"+CPF+"'") != null) {
		
			do {
			
			JOptionPane.showInputDialog("Informe sua função "
					+ "\n "
					+ "1. Atendente"
					+ "\n"
					+ "2. Medico"
					+ "\n"
					+ "3. Enfermeiro"
					+ "\n"
					+ "4. Coordenador");
			
			switch(opt) {
			
			case 1:
				prorepos.Delete("Delete from Atendente where CPF = '"+CPF+"'");
				break;
				
			case 2: 
				prorepos.Delete("Delete from Medico where CPF = '"+CPF+"'");
				break;
			case 3:
				prorepos.Delete("Delete from Enfermeiro where CPF = '"+CPF+"'");
				break;
			case 4:
				prorepos.Delete("Delete from Coordenador where CPF = '"+CPF+"'");
				break;
				
			}
			
			}while(opt!=1 && opt!=2 && opt!=3 && opt!=4);
			
			urepos.Delete("Delete from Usuario where CPF_Profissional = '"+CPF+"'");
			prorepos.Delete("Delete from Profissional where CPF = '"+CPF+"'");
			
		}
		
	}
	
	
	public static void Editar() {
		
		String CPF;
		int opt = 0;
		
		CPF = JOptionPane.showInputDialog("Informe seu CPF: ");
		
		PacienteRepositorio prepos = new PacienteRepositorio();
		
		ProfissionalRepositorio prorepos = new ProfissionalRepositorio();

		
		if(prepos.List("Select * from Paciente where CPF = '"+CPF+"'") != null) {
			
			
			
			do {
			JOptionPane.showInputDialog("O que deseja alterar?"
					+ "\n"
					+ "1. Nome"
					+ "2. Telefone "
					+ "3. Email");
		
		switch(opt) {
		
		case 1: 
	
			String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
			prepos.Update("Update Paciente set Nome = '"+nome+"' where CPF ='"+CPF+"'");
			break;
		
		case 2: 
			
			String telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
			prepos.Update("Update Telefone_Paciente set Telefone = '"+telefone+"' where CPF ='"+CPF+"'");
			break;
			
		case 3:
			String email = JOptionPane.showInputDialog("Digite o novo email: ");
			prepos.Update("Update Email_Paciente set Email = '"+email+"' where CPF ='"+CPF+"'");
			break;
		}		
			
			}while(opt!=1 && opt!=2 && opt!=3);
		
		}
		
		if(prorepos.List("Select * from Profissional where CPF = '"+CPF+"'") != null) {
			
			do {
				JOptionPane.showInputDialog("O que deseja alterar?"
						+ "\n"
						+ "1. Nome"
						+ "2. Telefone "
						+ "3. Email");
			
			switch(opt) {
			
			case 1: 
		
				String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
				prepos.Update("Update Profissional set Nome = '"+nome+"' where CPF ='"+CPF+"'");
				break;
			
			case 2: 
				
				String telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
				prepos.Update("Update Telefone_Profissional set Telefone = '"+telefone+"' where CPF ='"+CPF+"'");
				break;
				
			case 3:
				String email = JOptionPane.showInputDialog("Digite o novo email: ");
				prepos.Update("Update Email_Profissional set Email = '"+email+"' where CPF ='"+CPF+"'");
				break;
			}		
				
				}while(opt!=1 && opt!=2 && opt!=3);
			
			}
			
			
		}
		
	
	public static void Cadastro() {

		int opcao = 0, tipo = 0, possuicartao = 1, possuiacompanhante = 1, possuiparentesco = 1;
		String user = "", password = "", opt = null;
		String CPF, Nome, DataNascimento, Telefone, Email, Codigo;
		String numCartao, sexo, parentesco = null;
		UsuarioRepositorio user_repos;
		Profissional profissional;
		boolean check;

		do {

			String grupo = JOptionPane.showInputDialog("1. Paciente" + "\n" + "2. Profissional");

			tipo = Integer.parseInt(grupo);

		} while (tipo != 1 && tipo != 2);

		if (tipo == 1) {

			PacienteRepositorio pacirepos = new PacienteRepositorio();

			CPF = JOptionPane.showInputDialog("Informe seu CPF: ");
			Nome = JOptionPane.showInputDialog("Informe seu nome: ");
			DataNascimento = JOptionPane.showInputDialog("Informe sua data de nascimento: (dd/MM/AA)");
			Telefone = JOptionPane.showInputDialog("Informe seu telefone: ");
			Email = JOptionPane.showInputDialog("Informe seu email: ");

			Paciente paciente = new Paciente();
			paciente.CPF = CPF;
			paciente.Nome = Nome;
			paciente.setDataNascimento(DataNascimento);
			paciente.Telefone = Telefone;
			paciente.Email = Email;

			pacirepos.Insert(paciente);

			possuicartao = JOptionPane.showConfirmDialog(null, "Possui cartão do SUS?");

			if (possuicartao == 0) {

				CartaoSUSRepositorio cartaorepos = new CartaoSUSRepositorio();

				numCartao = JOptionPane.showInputDialog("Número do cartão: ");
				sexo = JOptionPane.showInputDialog("Sexo: ");

				CartaoSUS cartaoSUS = new CartaoSUS(numCartao, sexo, paciente.getDataNascimento(), paciente.getCPF());

				cartaorepos.Insert(cartaoSUS);

			}

			possuiacompanhante = JOptionPane.showConfirmDialog(null, "Possui acompanhante?");

			if (possuiacompanhante == 0) {

				AcompanhanteRepositorio acompanharepos = new AcompanhanteRepositorio();

				CPF = JOptionPane.showInputDialog("Informe o CPF do acompanhante: ");
				Nome = JOptionPane.showInputDialog("Nome do acompanhante: ");
				possuiparentesco = JOptionPane.showConfirmDialog(null, "Possui algum parentesco?");

				if (possuiparentesco == 0) {
					parentesco = JOptionPane.showInputDialog("Informe qual o parentesco: ");
				}

				Acompanhante acompanhante = new Acompanhante(CPF, Nome, parentesco, paciente.getCPF());
				acompanharepos.Insert(acompanhante);

			}

			do {
				JOptionPane.showMessageDialog(null, "Por último, cadastraremos seu usuario e sua senha");
				user = JOptionPane.showInputDialog("Usuario à ser cadastrado: ");
				password = JOptionPane.showInputDialog("Senha à ser cadastrado: ");

				user_repos = new UsuarioRepositorio();

				check = (user_repos
						.List("Select * from Usuario where login_user = " + user + " and senha = " + password) == null);

			} while (check == false);

			user_repos.Insert(new Usuario(user, password, paciente.getCPF(), null));

		} else if (tipo == 2) {

			ProfissionalRepositorio prorepos = new ProfissionalRepositorio();

			CPF = JOptionPane.showInputDialog("Informe seu CPF: ");
			Nome = JOptionPane.showInputDialog("Informe seu nome: ");
			DataNascimento = JOptionPane.showInputDialog("Informe sua data de nascimento: (dd/MM/AA)");
			Telefone = JOptionPane.showInputDialog("Informe seu telefone: ");
			Email = JOptionPane.showInputDialog("Informe seu email: ");

			int randomCode = ThreadLocalRandom.current().nextInt();
			Codigo = String.valueOf(randomCode);
			JOptionPane.showMessageDialog(null, "Seu código é: " + Codigo);

			profissional = new Profissional();
			profissional.CPF = CPF;
			profissional.Nome = Nome;
			profissional.Telefone = Telefone;
			profissional.Email = Email;
			profissional.setCodigo(Codigo);
			profissional.setDataNascimento(DataNascimento);

			prorepos.Insert(profissional);

			opt = JOptionPane.showInputDialog("Deseja cadastrar-se como: " + "\n " + "\n" + "1. Atendente" + "\n"
					+ "2. Medico" + "\n" + "3. Enfermeiro" + "\n" + "4. Coordenador");

			opcao = Integer.parseInt(opt);

			switch (opcao) {

			case 1:

				AtendenteRepositorio atendrepos = new AtendenteRepositorio();

				String setor = JOptionPane.showInputDialog("Informe seu setor: ");
				Atendente atendente = new Atendente(profissional.getCPF(), profissional.getDataNascimento(),
						profissional.getCodigo(), setor);
				atendrepos.Insert(atendente);
				break;

			case 2:

				MedicoRepositorio medicorepos = new MedicoRepositorio();

				String CRM = JOptionPane.showInputDialog("Informe seu CRM: ");
				Medico medico = new Medico(profissional.getCPF(), profissional.getDataNascimento(),
						profissional.getCodigo(), CRM);
				medicorepos.Insert(medico);
				break;

			case 3:
				EnfermeiroRepositorio enferepos = new EnfermeiroRepositorio();

				String CIF = JOptionPane.showInputDialog("Informe seu CIF: ");
				Enfermeiro enfermeiro = new Enfermeiro(profissional.getCPF(), profissional.getDataNascimento(),
						profissional.getCodigo(), CIF);
				enferepos.Insert(enfermeiro);
				break;

			case 4:
				CoordenadorRepositorio coordrepos = new CoordenadorRepositorio();

				String depart = JOptionPane.showInputDialog("Departamento: ");
				Coordenador coord = new Coordenador(profissional.getCPF(), profissional.getDataNascimento(),
						profissional.getCodigo(), depart);
				coordrepos.Insert(coord);
				break;

			}

			do {
				JOptionPane.showMessageDialog(null, "Por último, cadastraremos seu usuario e sua senha");
				user = JOptionPane.showInputDialog("Usuario à ser cadastrado: ");
				password = JOptionPane.showInputDialog("Senha à ser cadastrado: ");

				user_repos = new UsuarioRepositorio();

				check = (user_repos
						.List("Select * from Usuario where login_user = '"+ user+"' and senha ='"+password+"'") == null);

			} while (check == true);

			user_repos.Insert(new Usuario(user, password, null, profissional.getCPF()));
		}

	}

	public static void main(String[] args) {

		int opcao = 0, contadorTriagem = 0, controle = 1;
		String user = "", password = "", opt = null;
		boolean check = false;

		do {

			opt = JOptionPane.showInputDialog(
					"" + "Para logar-se à plataforma, digite 1" + "\n" + "Para cadastrar-se, digite 2 "+ "\n" 
			+ "Para editar dados cadastrais, digite 3"
			+ "\n"
			+ "Para apagar conta, digita 4");

			opcao = Integer.parseInt(opt);

			switch (opcao) {

			case 1:

				do {

					user = JOptionPane.showInputDialog("Usuario: ");
					password = JOptionPane.showInputDialog("Senha:");

					UsuarioRepositorio user_repos = new UsuarioRepositorio();

					check = (user_repos.List(
							"Select * from Usuario where login_user ='"+user+"'and senha ='"+password+"'") == null);

					System.out.println(check);
				} while (user.equals(null) || user.equals("") || password.equals(null) || password.equals("")
						|| check == true);

				JOptionPane.showMessageDialog(null,
						"Seja bem vindo " + "ao Sistema de Triagem para Atendimento Hospitalar");

				JOptionPane.showMessageDialog(null,
						"Queremos saber sobre sua situação, por favor, responda com 'Sim' ou 'Não' as perguntas a seguir");
				
				
				opcao = JOptionPane.showConfirmDialog(null, "O paciente encontra-se consciente?");
				
				if(opcao == 1)
					contadorTriagem+=20;
				
				opcao = JOptionPane.showConfirmDialog(null, "Está com alguma fratura aberta?");
					
				if(opcao == 0)
					contadorTriagem+=20;
				
				opcao = JOptionPane.showConfirmDialog(null, "O paciente possui alguma comorbidade? Diabetes, Hipertensão, Asma, etc..");
				
				if(opcao == 0)
					contadorTriagem+=12;
				
				opcao = JOptionPane.showConfirmDialog(null, "Está com falta de ar?");
				
				if(opcao == 0)
					contadorTriagem+=15;
					
				opcao = JOptionPane.showConfirmDialog(null, "Está com febre?");
				
				if(opcao == 0)
					contadorTriagem+=10;
				
				opcao = JOptionPane.showConfirmDialog(null, "O paciente já teve Covid-19?");
				
				if(opcao == 0)
					contadorTriagem+=8;
				
				opcao = JOptionPane.showConfirmDialog(null, "O paciente está com Covid-19?");
				
				if(opcao == 0)
					contadorTriagem+=15;
				
				opcao = JOptionPane.showConfirmDialog(null, "É idoso?");
				
				if(opcao == 0)
					contadorTriagem+=10;
				
				opcao = JOptionPane.showConfirmDialog(null, "O paciente tem alguma alergia?");
				
				if(opcao == 0)
					contadorTriagem+=10;
				
				opcao = JOptionPane.showConfirmDialog(null, "O paciente toma remédio frequentemente?");
				
				if(opcao == 0)
					contadorTriagem+=14;
				
						
				if(contadorTriagem >= 60) {
					
					JOptionPane.showMessageDialog(null, "Você possui preferência na fila, em breve um enfermeiro entrará em contato para verificar melhor a situação");
				
				}else if(contadorTriagem >= 45) {
					JOptionPane.showMessageDialog(null, "Aguarde alguns minutos, logo um profissional de saúde entrará em contato");
				
				}else if(contadorTriagem <= 30) {
					JOptionPane.showMessageDialog(null, "Dados obtidos com sucesso. Dirija-se ao hospital para que o profissional possa atendê-lo.");
				}	
				break;

			case 2:
				Cadastro();
				break;
			
			case 3:
				Editar();
				break;
			case 4: 
				Deletar();

			}

		} while (opcao != 1 && opcao != 2);

	}
}
