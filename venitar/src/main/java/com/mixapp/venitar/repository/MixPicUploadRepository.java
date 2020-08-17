package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.MixPicUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MixPicUploadRepository extends JpaRepository<MixPicUpload, Long> {
    @Query(value= "SELECT m FROM MixPicUpload m WHERE m.mixPicPermit = ?1")
    List<MixPicUpload> getPermittedMixPics (String mixPicPermit);
}
