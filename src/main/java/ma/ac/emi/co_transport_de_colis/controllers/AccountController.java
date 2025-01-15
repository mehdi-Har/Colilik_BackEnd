package ma.ac.emi.co_transport_de_colis.controllers;

import ma.ac.emi.co_transport_de_colis.entities.Account;
import ma.ac.emi.co_transport_de_colis.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/register")
    public Account register(@RequestParam String fullName, @RequestParam String email, @RequestParam String clerkId, @RequestParam String phone) {
        return accountService.register(fullName, email, clerkId, phone);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        accountService.delete(id);
    }

//    @PostMapping("/login")
//    public Account login(@RequestParam String email, @RequestParam String password) {
//        return accountService.login(email, password);
//    }
//
//    @PostMapping("/reset-password")
//    public String resetPassword(@RequestParam String email, @RequestParam String newPassword) {
//        accountService.resetPassword(email, newPassword);
//        return "Password successfully reset";
//    }
}

