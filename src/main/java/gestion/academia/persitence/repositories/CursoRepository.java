package gestion.academia.persitence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.academia.persitence.entities.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long>{//Long es el tipo de Id

}
