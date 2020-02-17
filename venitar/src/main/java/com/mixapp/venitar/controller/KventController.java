package com.mixapp.venitar.controller;

import com.mixapp.venitar.entity.MixesUpload;
import com.mixapp.venitar.service.MixesUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KventController {
 @Autowired
 private final MixesUploadService mixesUploadService;

 public KventController(MixesUploadService mixesUploadService) {
  this.mixesUploadService = mixesUploadService;
 }

 @GetMapping("/getAllMixes")
 List<MixesUpload> getAllMixes() {
  return mixesUploadService.getAllMixes();
 }

 @GetMapping("/getMixById")
 MixesUpload getMix(@RequestParam(name = "MixID") Long mixId){
 return mixesUploadService.getMixUpload(mixId);
 }

 @PostMapping("/addMix")
 MixesUpload addMix(@RequestBody MixesUpload mix) {
 return mixesUploadService.uploadMix(mix);
 }

 @PutMapping("/updateMix")
 MixesUpload updateMix(@RequestBody MixesUpload mix) {
 return mixesUploadService.updateMixUpload(mix);
 }

 @DeleteMapping("/delMix")
 String deleteMix(@RequestParam(name = "mixID") Long mixId){
   MixesUpload mixesUpload = mixesUploadService.getMixUpload(mixId);
   return mixesUpload != null ? mixesUploadService.deleteMixUpload(mixId) : "No Mix Found";
  }

}
