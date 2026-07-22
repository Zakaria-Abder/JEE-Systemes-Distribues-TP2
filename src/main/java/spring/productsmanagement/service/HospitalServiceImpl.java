package spring.productsmanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.productsmanagement.entities.Consultation;
import spring.productsmanagement.entities.Medecin;
import spring.productsmanagement.entities.Patient;
import spring.productsmanagement.entities.RendezVous;
import spring.productsmanagement.repositories.ConsultationRepository;
import spring.productsmanagement.repositories.MedecinRepository;
import spring.productsmanagement.repositories.PatientRepository;
import spring.productsmanagement.repositories.RendezVousRepository;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private final PatientRepository patientRepository;
    private final MedecinRepository medecinRepository;
    private final RendezVousRepository rendezVousRepository;
    private final ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,
                               MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository,
                               ConsultationRepository consultationRepository) {

        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    // =======================
    // Save
    // =======================

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    // =======================
    // List
    // =======================

    @Override
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Medecin> listMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public List<RendezVous> listRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public List<Consultation> listConsultations() {
        return consultationRepository.findAll();
    }

    // =======================
    // Get By Id
    // =======================

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin getMedecin(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public RendezVous getRendezVous(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public Consultation getConsultation(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    // =======================
    // Delete
    // =======================

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }
}