package org.example.anoada_nohayla_tp2_1;

import org.example.anoada_nohayla_tp2_1.entities.*;
import org.example.anoada_nohayla_tp2_1.repository.ConsultationRepository;
import org.example.anoada_nohayla_tp2_1.repository.MedecinRepository;
import org.example.anoada_nohayla_tp2_1.repository.PatientRepository;
import org.example.anoada_nohayla_tp2_1.repository.RendezVousRepository;
import org.example.anoada_nohayla_tp2_1.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class AnoadaNohaylaTp21Application //implements CommandLineRunner
{
    @Autowired
    public static void main(String[] args)
    {
        SpringApplication.run(AnoadaNohaylaTp21Application.class, args);
    }

    @Bean
    CommandLineRunner start(
            IHospitalService hospitalService,
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository,
            ConsultationRepository consultationRepository
                            ){
        return args -> {
            // Ajout des patients
            Stream.of("Nohayla","Hind","Mohamed", "Hassan", "Najat")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patient.setScore(2);
                        hospitalService.savePatient(patient);
                    });
            // Ajout des médecins
            Stream.of("Dr. Mohamed", "Dr. Hassan", "Dr. Najat")
                    .forEach(name -> {
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });

            // Ajout des rendez-vous
            Patient patient = patientRepository.findById(1L).orElseThrow();
            Medecin medecin = medecinRepository.findById(1L).orElseThrow();

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRDV(rendezVous);

            // Ajout des consultations
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapport("Rapport de consultation");
            consultation.setRendezVous(rendezVous);
            hospitalService.saveConsultation(consultation);

        };
    }
    //@Override
    //public void run(String... args) throws Exception
    //{
        /*
        // Ajouter des patients
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        patientRepository.save(new Patient(null, "noha", sdf.parse("30/05/2001"), false, 0));
        patientRepository.save(new Patient(null, "salah", sdf.parse("12/08/1998"), false, 0));
        patientRepository.save(new Patient(null, "hind", sdf.parse("10/07/1985"), true, 0));
        patientRepository.save(new Patient(null, "saad", sdf.parse("02/01/2014"), false, 0));
        patientRepository.save(new Patient(null, "farah", sdf.parse("08/06/2002"), true, 0));

        // Consulter tous les patients
        List<Patient> patients= patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println();

        // Consulter un patient
        Patient patient=patientRepository.findById(3L).get();
        System.out.println(patient.getId());
        System.out.println(patient.getNom());
        System.out.println(patient.getDateNaissance());
        System.out.println(patient.isMalade());
        System.out.println(patient.getScore());
        System.out.println();

        // Chercher des patients
        List<Patient> patientsIsMalade = patientRepository.findByMalade(true);
        patientsIsMalade.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println();

        // Mettre à jour un patient
        Patient patientEdit=patientRepository.findById(2L).get();
        patientEdit.setNom("edit name");
        patientRepository.save(patientEdit);
        System.out.println(patientEdit.toString());

        //Supprimer un patient
        patientRepository.deleteById(1L);
        */
    //}
}
