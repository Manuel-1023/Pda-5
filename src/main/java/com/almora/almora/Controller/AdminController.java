package com.almora.almora.Controller;

import com.almora.almora.Model.Admin;
import com.almora.almora.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable String id) { // Cambié Integer → String
        return adminService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable String id, @RequestBody Admin admin) { // Cambié Integer → String
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable String id) { // Cambié Integer → String
        adminService.deleteAdmin(id);
    }
}
