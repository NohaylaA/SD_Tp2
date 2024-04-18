package org.example.anoada_nohayla_tp2_1.repository;

import org.example.anoada_nohayla_tp2_1.entities.Medecin;
import org.example.anoada_nohayla_tp2_1.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long>
{
    List<Patient> findByMalade(boolean malade);
    List<Patient> findByNom(String nom);
}
