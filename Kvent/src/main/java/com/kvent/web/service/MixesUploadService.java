package com.kvent.web.service;

import com.kvent.web.entity.MixesUpload;
import com.kvent.web.repository.MixesUploadRepository;

import java.util.List;

public class MixesUploadService {
    private final MixesUploadRepository mixesUploadRepository;

    public MixesUploadService(MixesUploadRepository mixesUploadRepository) {
        this.mixesUploadRepository = mixesUploadRepository;
    }
    MixesUpload uploadMix(MixesUpload mixesUpload) {
        return mixesUploadRepository.saveAndFlush(mixesUpload);
    }

    List<MixesUpload> uploadMixes(List<MixesUpload> mixesUploads){
        return mixesUploadRepository.saveAll(mixesUploads);
    }

    List<MixesUpload> getAllMixes(){
        return mixesUploadRepository.findAll();
    }

    MixesUpload getMixUpload(Long mixId) {
        return mixesUploadRepository.getOne(mixId);
    }

    MixesUpload updateMixUpload(MixesUpload mix) {
        MixesUpload mixesUpload = mixesUploadRepository.getOne(mix.getMixId());
        return mixesUpload != null ? mixesUploadRepository.saveAndFlush(mix) : null;
    }

    void deleteMixUpload(Long mixId) {
        mixesUploadRepository.deleteById(mixId);
    }

    List<MixesUpload> getMixesByStatus(String mixStatus) {
        return mixesUploadRepository.getMixesByStatus(mixStatus);
    }
}
