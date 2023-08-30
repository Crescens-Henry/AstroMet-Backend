package com.ApiRest.AstroMet.repositories;

import com.ApiRest.AstroMet.entities.DataTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataTutorRepository extends JpaRepository<DataTutor, Long> {
}
