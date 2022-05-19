package com.example.tovar.Service;

import com.example.tovar.Model.Tovar;
import com.example.tovar.Repository.TovarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TovarService {
    @Autowired
    TovarRepository tovarRepository;

    public List<Tovar> chiqarish(){
        List<Tovar> tovarList = tovarRepository.findAll();
        return tovarList;
    }

    public Tovar chiqar(Integer id){
        Optional<Tovar> repository = tovarRepository.findById(id);
        return repository.orElse(null);
    }
    public Boolean kiritish(Tovar tovar){
        Tovar tovar1 = new Tovar();
        tovar1.setNomi(tovar.getNomi());
        tovar1.setSoni(tovar.getSoni());
        tovar1.setNarxi(tovar.getNarxi());
        tovarRepository.save(tovar1);
        return true;
    }

    public Boolean yangilash(Tovar tovar, Integer id){
        Optional<Tovar> optionalTovar = tovarRepository.findById(id);
        if (optionalTovar.isPresent()){
            Tovar tovar1 = optionalTovar.get();
            tovar1.setNarxi(tovar.getNarxi());
            tovar1.setNomi(tovar.getNomi());
            tovar1.setSoni(tovar.getSoni());
            tovarRepository.save(tovar1);
            return true;
        }
        return false;
    }
    public Boolean ochirish(Integer id){
        Optional<Tovar> optionalTovar = tovarRepository.findById(id);
        if (optionalTovar.isPresent()){
            tovarRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
