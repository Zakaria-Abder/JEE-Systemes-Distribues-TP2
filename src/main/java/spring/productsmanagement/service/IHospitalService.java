package spring.productsmanagement.service;

import spring.productsmanagement.entities.Consultation;
import spring.productsmanagement.entities.Medecin;
import spring.productsmanagement.entities.Patient;
import spring.productsmanagement.entities.RendezVous;

import java.util.List;

public interface IHospitalService {

    // Sauvegarde
    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    RendezVous saveRendezVous(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);

    // Consultation
    List<Patient> listPatients();

    List<Medecin> listMedecins();

    List<RendezVous> listRendezVous();

    List<Consultation> listConsultations();

    // Recherche
    Patient getPatient(Long id);

    Medecin getMedecin(Long id);

    RendezVous getRendezVous(Long id);

    Consultation getConsultation(Long id);

    // Suppression
    void deletePatient(Long id);

    void deleteMedecin(Long id);

    void deleteRendezVous(Long id);

    void deleteConsultation(Long id);
}