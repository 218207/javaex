package com.example.exc44;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CalcoolatorService {

    private final CalcoolatorRepository calcoolatorRepository;


    public List<Calcoolator> showAllResult(){
        return calcoolatorRepository.findAll();
    }

    @Transactional
    public void saveNewResult(Calcoolator calcoolator){
        calcoolatorRepository.save(calcoolator);
    }

    @Transactional
    public void deleteAllResult(){
        calcoolatorRepository.deleteAll();
    }
}
