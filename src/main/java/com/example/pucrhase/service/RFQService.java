package com.example.pucrhase.service;

import com.example.pucrhase.dto.PrDto;
import com.example.pucrhase.dto.RFQDto;
import com.example.pucrhase.model.ServiceResult;

public interface RFQService {
    /**
     * PR -> RFQ 견적 생성
     */
    ServiceResult createRFQ(RFQDto rfqDto);

    /**
     * RFQ 삭제
     */
    ServiceResult deleteRFQ(RFQDto rfqDto);
}
