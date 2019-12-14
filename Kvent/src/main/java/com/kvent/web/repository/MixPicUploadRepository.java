package com.kvent.web.repository;

import com.kvent.web.entity.MixPicUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MixPicUploadRepository extends JpaRepository<MixPicUpload, Long> {
    @Query(value= "SELECT m FROM MixPicUpload m WHERE m.mixPicPermit = ?1")
    List<MixPicUpload> getPermittedMixPics (String mixPicPermit);
}
