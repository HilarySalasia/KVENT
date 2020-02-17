package com.kvent.web.controller;

import com.kvent.web.entity.MixesUpload;
import com.kvent.web.service.MixesUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KventController {
 private final MixesUploadService mixesUploadService;
@Autowired
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
