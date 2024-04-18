package org.example.anoada_nohayla_tp2_1.repository;

import org.example.anoada_nohayla_tp2_1.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin,Long>
{
    List<Medecin> findByNom(String nom);
}
