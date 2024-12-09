package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Account;
import ma.ac.emi.co_transport_de_colis.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Account register(String fullName, String email, String password) {
        if (accountRepository.findByUserEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }

        Account account = new Account();
        account.setFullName(fullName);
        account.setUserEmail(email);
        account.setPassword(passwordEncoder.encode(password));
        return accountRepository.save(account);
    }

    public Account login(String email, String password) {
        Optional<Account> accountOptional = accountRepository.findByUserEmail(email);

        if (accountOptional.isEmpty()) {
            throw new IllegalArgumentException("Email not found");
        }

        Account account = accountOptional.get();
        if (!passwordEncoder.matches(password, account.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return account;
    }

    public void resetPassword(String email, String newPassword) {
        Optional<Account> accountOptional = accountRepository.findByUserEmail(email);

        if (accountOptional.isEmpty()) {
            throw new IllegalArgumentException("Email not found");
        }

        Account account = accountOptional.get();
        account.setPassword(passwordEncoder.encode(newPassword));
        accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}

