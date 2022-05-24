package com.example.tovar.Controller;

import com.example.tovar.Model.Tovar;
import com.example.tovar.Service.TovarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tovar")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TovarController {
    @Autowired
    TovarService tovarService;
//    @PreAuthorize(value = "hasAnyRole('ADMIN', 'SUPERUSER')")
    @PreAuthorize(value = "hasAuthority('TOVARNICHIQARISH')")
    @GetMapping("/chiqarish")
    public HttpEntity<?> tovarniChiqarish(){
        return ResponseEntity.ok(tovarService.chiqarish());
    }


//    @PreAuthorize(value = "hasAnyRole('ADMIN', 'SUPERUSER','USER')")
    @PreAuthorize(value = "hasAuthority('TOVARCHIQARISH')")
    @GetMapping("/chiqarish/{id}")
    public HttpEntity<?> tovarChiqarish(@PathVariable Integer id){
        return ResponseEntity.ok(tovarService.chiqar(id));
    }


//    @PreAuthorize(value = "hasRole('ADMIN')")
    @PreAuthorize(value = "hasAuthority('TOVARNIKIRITISH')")
    @PostMapping ("/kiritish")
    public HttpEntity<?> tovarniKiritish(@RequestBody Tovar tovar){
        Boolean k = tovarService.kiritish(tovar);
        if (k) return ResponseEntity.status(200).body("Joylandi!");
        return ResponseEntity.status(208).body("Joylanmadi");
    }
//    @PreAuthorize(value = "hasRole('ADMIN')")
    @PreAuthorize(value = "hasAuthority('TOVARNIYANGILASH')")
    @PutMapping("/yangilash/{id}")
    public HttpEntity<?> tovarniYangilash(@RequestBody Tovar tovar, @PathVariable Integer id){
        Boolean y = tovarService.yangilash(tovar, id);
        if (y) return ResponseEntity.status(200).body("Yangilandi");
        return ResponseEntity.status(208).body("Bunday tovar mavjud emas");
    }
//    @PreAuthorize(value = "hasRole('ADMIN')")
    @PreAuthorize(value = "hasAuthority('TOVARNIOCHIRISH')")
    @DeleteMapping("/ochirish/{id}")
    public HttpEntity<?> tovarniOchirish(@PathVariable Integer id){
        Boolean o = tovarService.ochirish(id);
        if (o) return ResponseEntity.status(200).body("O'chirildi");
        return ResponseEntity.status(208).body("Bunday tovar mavjud emas");
    }
}
