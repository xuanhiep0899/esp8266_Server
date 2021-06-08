package com.EspServer.Esp.service;

import com.EspServer.Esp.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

}
