package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.MixesUpload;
import com.mixapp.venitar.repository.MixesUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MixesUploadService {

    private MixesUploadRepository mixesUploadRepository;



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
        mixesUploadRepository.deleteById(mixId);
        return "MixDeleted";
    }

    public List<MixesUpload> getMixesByStatus(String mixStatus) {
        return mixesUploadRepository.getMixesByStatus(mixStatus);
    }
}
