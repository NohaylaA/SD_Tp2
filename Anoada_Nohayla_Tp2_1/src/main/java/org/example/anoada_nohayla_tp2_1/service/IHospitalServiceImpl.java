package org.example.anoada_nohayla_tp2_1.service;

import jakarta.transaction.Transactional;
import org.example.anoada_nohayla_tp2_1.entities.Consultation;
import org.example.anoada_nohayla_tp2_1.entities.Medecin;
import org.example.anoada_nohayla_tp2_1.entities.Patient;
import org.example.anoada_nohayla_tp2_1.entities.RendezVous;
import org.example.anoada_nohayla_tp2_1.repository.ConsultationRepository;
import org.example.anoada_nohayla_tp2_1.repository.MedecinRepository;
import org.example.anoada_nohayla_tp2_1.repository.PatientRepository;
import org.example.anoada_nohayla_tp2_1.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezvousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository,
                                MedecinRepository medecinRepository,
                                RendezVousRepository rendezvousRepository,
                                ConsultationRepository consultationRepository)
    {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezvousRepository = rendezvousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezvous) {
        rendezvous.setId(UUID.randomUUID().toString());
        return rendezvousRepository.save(rendezvous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
