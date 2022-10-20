package com.example.pucrhase.service;

import com.example.pucrhase.domain.PuchasingRequest;
import com.example.pucrhase.dto.PrDto;
import com.example.pucrhase.model.ServiceResult;
import com.example.pucrhase.repository.MemberRepository;
import com.example.pucrhase.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;


    @Override
    public ServiceResult createPr(PrDto pr) {
        Optional<PuchasingRequest> optionalPr = orderRepository.findByPrNo(pr.getPrNo());
        if(optionalPr.isPresent()){
            throw new IllegalArgumentException("이미 존재하는 PR번호 입니다.");
        }

        PuchasingRequest puchasingRequest = new PuchasingRequest();

        puchasingRequest = dtoInsertEntity(puchasingRequest, pr);
        puchasingRequest.setAddUserId(pr.getAddUserId());
        puchasingRequest.setAddDate(LocalDate.now());

        orderRepository.save(puchasingRequest);
        return null;
    }

    @Override
    public ServiceResult updatePr(PrDto pr) {
        Optional<PuchasingRequest> optionalPr = orderRepository.findByPrNo(pr.getPrNo());
        if(!optionalPr.isPresent()){
            throw new IllegalArgumentException("존재하지 않은 PR번호 입니다.");
        }
        PuchasingRequest puchasingRequest = optionalPr.get();

        puchasingRequest = dtoInsertEntity(puchasingRequest, pr);
        puchasingRequest.setChangeDate(LocalDate.now());
        puchasingRequest.setChangeUserId(pr.getChangeUserId());

        orderRepository.save(puchasingRequest);
        return null;
    }

    @Override
    public ServiceResult deletePr(PrDto pr) {
        Optional<PuchasingRequest> optionalPr = orderRepository.findByPrNo(pr.getPrNo());
        if(!optionalPr.isPresent()){
            throw new IllegalArgumentException("존재하지 않은 PR번호 입니다.");
        }

        orderRepository.delete(optionalPr.get());
        return null;
    }

    @Override
    public ServiceResult signPr(PrDto pr) {
        Optional<PuchasingRequest> optionalPr = orderRepository.findByPrNo(pr.getPrNo());
        if(!optionalPr.isPresent()){
            throw new IllegalArgumentException("존재하지 않은 PR번호 입니다.");
        }

        PuchasingRequest puchasingRequest = optionalPr.get();
        if(prStatusCheck(puchasingRequest)){
            puchasingRequest.setPrStatus(pr.getPrStatus());
            orderRepository.save(puchasingRequest);
            return new ServiceResult(true, "PR 상태 업데이트");
        }
        else {
            return new ServiceResult(false, "PR 처리불가능한 상태입니다.");
        }

    }

    public PuchasingRequest dtoInsertEntity(PuchasingRequest puchasingRequest, PrDto pr){
        puchasingRequest.setPrNo(pr.getPrNo());
        puchasingRequest.setPrItemNo(pr.getPrItemNo());
        puchasingRequest.setItemNo(pr.getItemNo());
        puchasingRequest.setItemDescription(pr.getItemDescription());
        puchasingRequest.setCompanyCode(pr.getCompanyCode());
        puchasingRequest.setPlantCode(pr.getPlantCode());

        return  puchasingRequest;
    }

    private boolean prStatusCheck(PuchasingRequest puchasingRequest){

        if(puchasingRequest.getPrStatus().equals("CONFIRM")){
            return false;
        }
        return true;
    }
}
