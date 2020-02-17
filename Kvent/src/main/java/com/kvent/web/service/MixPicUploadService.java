package com.kvent.web.service;

import com.kvent.web.entity.MixPicUpload;
import com.kvent.web.repository.MixPicUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MixPicUploadService {
    @Autowired
    private final MixPicUploadRepository mixPicUploadRepository;
    private final Pageable pageable;

    public MixPicUploadService(MixPicUploadRepository mixPicUploadRepository, Pageable pageable) {
        this.mixPicUploadRepository = mixPicUploadRepository;
        this.pageable = pageable;
    }

    Page<MixPicUpload> getAllMixUpload(){
        List<MixPicUpload> allMixes = mixPicUploadRepository.findAll();
        Page<MixPicUpload> pages = new PageImpl<>(allMixes, pageable, allMixes.size());
        return pages;
    }

    MixPicUpload getMix(Long mixId) {
        return mixPicUploadRepository.getOne(mixId);
    }

    MixPicUpload updateMix(MixPicUpload mixPicUpload) {
        MixPicUpload mixesUploadDb = mixPicUploadRepository.getOne(mixPicUpload.getMixPicId());
        return mixesUploadDb != null ? mixPicUploadRepository.saveAndFlush(mixPicUpload) : null;
    }

    String deleteMix(Long mixId) {
        MixPicUpload mixPicUpload = mixPicUploadRepository.getOne(mixId);
        if (mixPicUpload != null) {
            mixPicUploadRepository.delete(mixId);
            return "Mix Removed";
        } else {
            return "Mix Not Found";
        }
    }

    List<MixPicUpload> MixesPermPics(String param) {
        return mixPicUploadRepository.getPermittedMixPics(param);
    }

    MixPicUpload mixPicUpload(MixPicUpload mixPicUpload) {
        return mixPicUploadRepository.saveAndFlush(mixPicUpload);
    }
}
