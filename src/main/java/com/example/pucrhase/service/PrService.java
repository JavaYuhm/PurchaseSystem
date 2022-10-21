package com.example.pucrhase.service;

import com.example.pucrhase.dto.PrDto;
import com.example.pucrhase.model.ServiceResult;

public interface PrService {

    /**
     * PR 생성
     */
    ServiceResult createPr(PrDto pr);

    /**
     * PR 수정
     */
    ServiceResult updatePr(PrDto pr);

    /**
     * PR 삭제
     */
    ServiceResult deletePr(PrDto pr);

    /**
     * PR 승인
     */
    ServiceResult signPr(PrDto pr);
}
