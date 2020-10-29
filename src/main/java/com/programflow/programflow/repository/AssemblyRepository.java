package com.programflow.programflow.repository;


import jdk.internal.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssemblyRepository extends JpaRepository <String, Integer> {

    Optional<Event> getAssemblyByAssemblyId(String assemblyId);


}
