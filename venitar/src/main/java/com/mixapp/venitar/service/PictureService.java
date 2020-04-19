package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Picture;
import com.mixapp.venitar.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {
    @Autowired
    PictureRepository pictureRepository;

    public List<Picture> findPictures() {
        return pictureRepository.findAll();
    }

    public Picture findPicture(Long picId) {
        return pictureRepository.getOne(picId);
    }

    public Picture addPicture(Picture picture) {
        return pictureRepository.save(picture);
    }

    public void deletePicture(Long picId) {
        pictureRepository.deleteById(picId);
    }
}
