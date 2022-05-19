package com.example.tovar.Controller;

import com.example.tovar.Model.Tovar;
import com.example.tovar.Service.TovarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tovar")
public class TovarController {
    @Autowired
    TovarService tovarService;

    @GetMapping("/chiqarish")
    public HttpEntity<?> tovarniChiqarish(){
        return ResponseEntity.ok(tovarService.chiqarish());
    }


    @GetMapping("/chiqarish/{id}")
    public HttpEntity<?> tovarChiqarish(@PathVariable Integer id){
        return ResponseEntity.ok(tovarService.chiqar(id));
    }


    @PostMapping ("/kiritish")
    public HttpEntity<?> tovarniKiritish(@RequestBody Tovar tovar){
        Boolean k = tovarService.kiritish(tovar);
        if (k) return ResponseEntity.status(200).body("Joylandi!");
        return ResponseEntity.status(208).body("Joylanmadi");
    }

    @PutMapping("/yangilash/{id}")
    public HttpEntity<?> tovarniYangilash(@RequestBody Tovar tovar, @PathVariable Integer id){
        Boolean y = tovarService.yangilash(tovar, id);
        if (y) return ResponseEntity.status(200).body("Yangilandi");
        return ResponseEntity.status(208).body("Bunday tovar mavjud emas");
    }

    @DeleteMapping("/ochirish/{id}")
    public HttpEntity<?> tovarniOchirish(@PathVariable Integer id){
        Boolean o = tovarService.ochirish(id);
        if (o) return ResponseEntity.status(200).body("O'chirildi");
        return ResponseEntity.status(208).body("Bunday tovar mavjud emas");
    }
}
