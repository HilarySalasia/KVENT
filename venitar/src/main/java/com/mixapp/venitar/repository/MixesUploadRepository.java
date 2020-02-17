package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.MixesUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MixesUploadRepository extends JpaRepository<MixesUpload, Long> {

    @Query(value="SELECT m FROM MixesUpload m WHERE m.mixStatus = ?1")
    List<MixesUpload> getMixesByStatus(String mixStatus);
}
