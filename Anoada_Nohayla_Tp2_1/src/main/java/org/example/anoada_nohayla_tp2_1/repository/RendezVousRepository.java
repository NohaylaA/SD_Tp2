package org.example.anoada_nohayla_tp2_1.repository;

import org.example.anoada_nohayla_tp2_1.entities.Consultation;
import org.example.anoada_nohayla_tp2_1.entities.Patient;
import org.example.anoada_nohayla_tp2_1.entities.RendezVous;
import org.example.anoada_nohayla_tp2_1.entities.StatusRDV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,String>
{
    List<RendezVous> findByDate(Date date);
}
