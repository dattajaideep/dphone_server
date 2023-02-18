package com.bajaj.controller;

import com.bajaj.beans.ReferralBean;
import com.bajaj.service.ReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ReferralController {
    @Autowired
    private ReferralService referralService;
    @PostMapping("/referrals/add")
    public ResponseEntity<String> addReferral(@RequestBody ReferralBean referralBean)
    {
        return referralService.addReferral(referralBean);
    }
    @PostMapping("/referrals/edit")
    public ResponseEntity<ReferralBean> editReferral(@RequestBody ReferralBean referralBean)
    {
        return referralService.editReferral(referralBean);
    }
    @PostMapping("/referrals/allreferral")
    public ResponseEntity<List<ReferralBean>> allReferral()
    {
        return referralService.allReferral();
    }
}
