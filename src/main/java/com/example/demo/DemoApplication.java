package com.example.demo;

import com.example.demo.Repositories.PatientRep;
import com.example.demo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

        @Autowired
        private PatientRep pr;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("*****boucle insertion ******");
        for (int i=0;i<100;i++){
            pr.save(new Patient(null, "hassan", new Date(), Math.random()>0.5?true:false, (int)Math.random()*100));
        }

        System.out.println("*****insert ******");
        /*
        pr.save(new Patient(null, "hassan", new Date(), false, 56));
        pr.save(
                new Patient(null, "Mohammed", new Date(), true, 100));
        pr.save(
                new Patient(null, "Imane", new Date(), false, 210));
                */

        System.out.println("*****la pagination dans spring data  ******");
        Page<Patient> patients=pr.findAll(PageRequest.of(0,5));
        System.out.println("Tatal pages : "+patients.getTotalPages());
        System.out.println("Total elements:"+patients.getTotalElements());
        System.out.println("Num Page:"+patients.getNumber ());

        List<Patient> content=   patients.getContent ();
        //List<Patient> MyMALADE=   pr.findByMalade(true);
        Page<Patient> MyMALADE=   pr.findByMalade(true,PageRequest.of(0,4));


        System.out.println("*****afficher ******");
       // List<Patient> patients = pr.findAll();
        MyMALADE.forEach(p -> {
            System.out.println("=======================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
        });

        System.out.println("*****update ******");
        Patient patient = pr.findById(1L).orElse(null);
        if (patient != null) {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
            patient.setScore(870);
            pr.save(patient);
        }
        System.out.println("*****delete ******");
        pr.deleteById(1l);
    }
}
