package br.com.kaiomuniz.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kaiomuniz.entities.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, UUID> {

}
