package com.kvent.web.service;

import com.kvent.web.entity.MixesUpload;
import com.kvent.web.repository.MixesUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MixesUploadService {
    @Autowired
    private final MixesUploadRepository mixesUploadRepository;

    public MixesUploadService(MixesUploadRepository mixesUploadRepository) {
        this.mixesUploadRepository = mixesUploadRepository;
    }

    public MixesUpload uploadMix(MixesUpload mixesUpload) {
        return mixesUploadRepository.saveAndFlush(mixesUpload);
    }

    public List<MixesUpload> uploadMixes(List<MixesUpload> mixesUploads){
        return mixesUploadRepository.saveAll(mixesUploads);
    }

    public List<MixesUpload> getAllMixes(){
        return mixesUploadRepository.findAll();
    }

    public MixesUpload getMixUpload(Long mixId) {
        return mixesUploadRepository.getOne(mixId);
    }

    public MixesUpload updateMixUpload(MixesUpload mix) {
        MixesUpload mixesUpload = mixesUploadRepository.getOne(mix.getMixId());
        return mixesUpload != null ? mixesUploadRepository.saveAndFlush(mix) : null;
    }

    public String deleteMixUpload(Long mixId) {
        mixesUploadRepository.delete(mixId);
        return "MixDeleted";
    }

    public List<MixesUpload> getMixesByStatus(String mixStatus) {
        return mixesUploadRepository.getMixesByStatus(mixStatus);
    }
}
