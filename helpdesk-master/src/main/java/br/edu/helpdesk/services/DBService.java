package br.edu.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.helpdesk.domain.Chamado;
import br.edu.helpdesk.domain.Cliente;
import br.edu.helpdesk.domain.Tecnico;
import br.edu.helpdesk.domain.enums.Perfil;
import br.edu.helpdesk.domain.enums.Prioridade;
import br.edu.helpdesk.domain.enums.Status;
import br.edu.helpdesk.repositories.ChamadoRepository;
import br.edu.helpdesk.repositories.ClienteRepository;
import br.edu.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instaciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Eduardo Silva", "33484545810", "eddcesilva@gmail.com",  encoder.encode("123456"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Ivoneide Silva", "47632605886", "neidinidnid@hotmail.com",  encoder.encode("123456"));
		tec2.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "14868316052", "linus@gmail.com", encoder.encode("123456"));
		
		Chamado c1 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
