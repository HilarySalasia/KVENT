package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.MixesUpload;
import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.repository.MixesUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Service
public class MixesUploadService {
    @Autowired
    private MixesUploadRepository mixesUploadRepository;
    @Autowired
    private UsersService usersService;



    public MixesUpload uploadMix(MixesUpload mixesUpload, MultipartFile file) throws IOException {
        Users user = usersService.findUser(mixesUpload.getUserId());
        String folderLink = user.getFolderLink();
        // Get the file and save it somewhere
        byte[] bytes = file.getBytes();
        mixesUpload.setMixLink(folderLink + "/" + file.getOriginalFilename());
        Path path = Paths.get("." + mixesUpload.getMixLink());
        Files.write(path, bytes);
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

    public void deleteMixUpload(Long mixId) {
        mixesUploadRepository.deleteById(mixId);
    }

    public List<MixesUpload> getMixesByStatus(String mixStatus) {
        return mixesUploadRepository.getMixesByStatus(mixStatus);
    }
}
