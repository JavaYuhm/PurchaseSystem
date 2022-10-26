package com.example.pucrhase.service;

import com.example.pucrhase.domain.RFQ;
import com.example.pucrhase.dto.RFQDto;
import com.example.pucrhase.model.ServiceResult;
import com.example.pucrhase.repository.RFQRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RFQServiceImpl implements RFQService{

    private final RFQRepository rfqRepository;


    @Override
    public ServiceResult createRFQ(RFQDto rfqDto) {

        if(rfqRepository.findByRfqNo(rfqDto.getRfqNo()).isPresent()){
            return new ServiceResult(false, "이미 존재하는 RFQ No 입니다.");
        }

        RFQ rfq = new RFQ();

        rfq.setRfqNo(rfqDto.getRfqNo());
        rfq.setRfqQty(rfqDto.getRfqQty());
        rfq.setPrNo(rfqDto.getPrNo());
        rfq.setPrItemNo(rfqDto.getItemNo());
        rfq.setValidFrom(rfqDto.getValidFrom());
        rfq.setValidTo(rfq.getValidTo());
        rfq.setAddUserId(rfqDto.getAddUserId());
        rfq.setAddDate(LocalDate.now());

        rfqRepository.save(rfq);

        return new ServiceResult(true, "RFQ No : "+rfq.getRfqNo() +"생성.");
    }

    @Override
    public ServiceResult deleteRFQ(RFQDto rfqDto) {

        Optional<RFQ> optionalRFq = rfqRepository.findByRfqNo(rfqDto.getRfqNo());

        if(!rfqRepository.findByRfqNo(rfqDto.getRfqNo()).isPresent()){
            return new ServiceResult(false, "존재하지 않는 RFQ No 입니다.");
        }
        
        RFQ deleteRFq = optionalRFq.get();
        rfqRepository.delete(deleteRFq);
        return new ServiceResult(true, "RFQ No : "+deleteRFq.getRfqNo() +"삭제.");
    }

}
