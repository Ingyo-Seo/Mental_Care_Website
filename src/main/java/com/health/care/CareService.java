package com.health.care;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.health.DataNotFoundException;
import com.health.user.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CareService {
	private final CareRepository careRepository;
	
    public void createHealthcare(UserEntity userEntity) {
    	CareEntity careEntity = new CareEntity();
    	careEntity.setCaredate(LocalDateTime.now());
    	careEntity.setCareauthor(userEntity);
        this.careRepository.save(careEntity);
    }
    
    public CareEntity getCareEntity(Integer careserial) {  
        Optional<CareEntity> careentity = this.careRepository.findById(careserial);
        if (careentity.isPresent()) {
            return careentity.get();
        } else {
            throw new DataNotFoundException("board not found");
        }
    }}
