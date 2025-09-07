package br.com.kaiomuniz.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Musica {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String titulo;
	private String artista;
	private String genero;
	private int duracao;
	private int anoLancamento;


}
