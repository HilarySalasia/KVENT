package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.MixesUpload;
import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.models.FileUpload;
import com.mixapp.venitar.repository.MixesUploadRepository;
import lombok.val;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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



    public FileUpload upload(MultipartFile file, Long userId) throws IOException {
        checkSavedFolder(userId);
        Users user = usersService.findUser(userId);
        String folderLink = user.getFolderLink();
        // Get the file and save it somewhere
        byte[] bytes = file.getBytes();
        String mixLink = (folderLink + "/" + file.getOriginalFilename());
        Path path = Paths.get("." + mixLink);
        Files.write(path, bytes);
        FileUpload fileUpload = new FileUpload();
        fileUpload.setUserId(userId);
        fileUpload.setFileLink(mixLink);
        fileUpload.setMessage("Upload Successful!!");
        System.out.println("File Name: " + file.getOriginalFilename());
        return fileUpload;
    }

    public void checkSavedFolder(Long userId) throws IOException {
        Users chckUser = usersService.findUser(userId);
        String Link = chckUser.getFolderLink();
        if (Link == null || !checkFolderLink(Link)) {
            val addFolder = ("/temp/user/" + userId);
            chckUser.setFolderLink(addFolder);
            usersService.createFolderLink(addFolder);
            usersService.editUsers(chckUser);
        }
    }

    public boolean checkFolderLink(String folderLink) throws IOException {
        return FileUtils.isSymlink(new java.io.File("." + folderLink));
    }

    public MixesUpload addMix(MixesUpload mixesUpload) {
        return mixesUploadRepository.save(mixesUpload);
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
