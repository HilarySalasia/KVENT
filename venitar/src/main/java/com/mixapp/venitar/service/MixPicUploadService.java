package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.MixPicUpload;
import com.mixapp.venitar.repository.MixPicUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MixPicUploadService {

    @Autowired
    private MixPicUploadRepository mixPicUploadRepository;

    Page<MixPicUpload> getAllMixUpload(Pageable pageable){
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
            mixPicUploadRepository.deleteById(mixId);
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
