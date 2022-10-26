package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plant {
    @Id
    String plantCode;

    String plantName;

}
/* SAP Plant
WERKS	플랜트
NAME1	성
BWKEY	평가 영역
KUNNR	플랜트 고객번호
LIFNR	플랜트의 공급업체번호
FABKL	공장 달력 키
.INCLUDE	플랜트/지점
 */