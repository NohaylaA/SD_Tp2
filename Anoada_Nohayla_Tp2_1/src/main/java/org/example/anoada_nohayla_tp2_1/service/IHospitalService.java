package org.example.anoada_nohayla_tp2_1.service;

import org.example.anoada_nohayla_tp2_1.entities.Consultation;
import org.example.anoada_nohayla_tp2_1.entities.Medecin;
import org.example.anoada_nohayla_tp2_1.entities.Patient;
import org.example.anoada_nohayla_tp2_1.entities.RendezVous;

public interface IHospitalService
{
    Patient savePatient (Patient patient);
    Medecin saveMedecin (Medecin medecin);
    RendezVous saveRDV (RendezVous rendezvous);
    Consultation saveConsultation (Consultation consultation);
}
