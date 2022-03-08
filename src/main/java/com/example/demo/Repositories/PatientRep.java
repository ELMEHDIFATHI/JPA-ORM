package com.example.demo.Repositories;

import com.example.demo.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;

public interface PatientRep extends JpaRepository<Patient,Long> {
    public List<Patient> findByMalade (boolean m);
    Page<Patient> findByMalade(Boolean m, Pageable pageble);
    /*
    List<Patient> findByMaladeAndScoreLessThan(boolean m,int score);
    List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    List<Patient> findByDateNaissanceBetweenAAndMaIadeIsTrue00rNomLike (Date d1, Date d2, String mc);
    */


    /*
   @Query("select   p from Patient p where p.dateNaissance between :x and :y or p.score <: z")
    List<Patient>  chercherPatients (@Param("x") Date d1, @Param("y") Date d2, @Param ("z") int score);


    @Query ("select p from Patient p where p.nom like :x and p.score<:y")
    List<Patient> chercherPatiente(@Param("x") String nom, @Param ("y")int scoreMin);
    */




}
