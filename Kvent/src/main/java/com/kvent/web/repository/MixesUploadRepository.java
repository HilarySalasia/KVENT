package com.kvent.web.repository;

import com.kvent.web.entity.MixesUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MixesUploadRepository extends JpaRepository<MixesUpload, Long> {

    @Query(value="SELECT m FROM MixesUpload m WHERE m.mixStatus = ?1")
    List<MixesUpload> getMixesByStatus(String mixStatus);
}
