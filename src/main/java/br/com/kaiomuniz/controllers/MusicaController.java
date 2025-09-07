package br.com.kaiomuniz.controllers;

import br.com.kaiomuniz.entities.Musica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

	private final Map<UUID, Musica> bancoMusicas = new HashMap<>();

	@GetMapping
	public ResponseEntity<List<Musica>> getAll() {
		return ResponseEntity.ok(new ArrayList<>(bancoMusicas.values()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Musica> getById(@PathVariable UUID id) {
		Musica musica = bancoMusicas.get(id);
		if (musica == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(musica);
	}

	@PostMapping
	public ResponseEntity<Musica> create(@RequestBody Musica musica) {
		UUID id = UUID.randomUUID();
		musica.setId(id);
		bancoMusicas.put(id, musica);
		return ResponseEntity.ok(musica);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Musica> update(@PathVariable UUID id, @RequestBody Musica musicaAtualizada) {
		Musica musicaExistente = bancoMusicas.get(id);
		if (musicaExistente == null) {
			return ResponseEntity.notFound().build();
		}
		musicaExistente.setTitulo(musicaAtualizada.getTitulo());
		musicaExistente.setArtista(musicaAtualizada.getArtista());
		musicaExistente.setGenero(musicaAtualizada.getGenero());
		musicaExistente.setDuracao(musicaAtualizada.getDuracao());
		musicaExistente.setAnoLancamento(musicaAtualizada.getAnoLancamento());

		bancoMusicas.put(id, musicaExistente);
		return ResponseEntity.ok(musicaExistente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		if (!bancoMusicas.containsKey(id)) {
			return ResponseEntity.notFound().build();
		}
		bancoMusicas.remove(id);
		return ResponseEntity.noContent().build();
	}
}
