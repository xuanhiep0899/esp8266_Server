package com.EspServer.Esp.detail_service.service;

import com.EspServer.Esp.detail_service.detail.AccountDetail;
import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.entities.RoleName;
import com.EspServer.Esp.repository.AccountRepository;
import exception.AccountDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;


    private PasswordEncoder passwordEncoder;

    public AccountDetailService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByAccountName(s);
        if (account == null){
            throw new AccountDoesNotExistsException("Not exists");
        }

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(account.getRoleName().toString()));
        UserDetails accountDetails = new AccountDetail(account.getAccountName(),
                passwordEncoder.encode(account.getPassword()), list.stream().collect(Collectors.toSet()));
        return accountDetails;
    }
}
