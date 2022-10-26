package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StLocation {
   @Id
   String stlId;

   String plantCode;
   String stlCode;

   String stlName;
}

/* SAP 저장위치
WERKS		CHAR	4		플랜트
LGORT		CHAR	4		저장 위치
LGOBE		CHAR	16		저장 위치 내역
SPART		CHAR	2		제품군
XLONG		CHAR	1		허용된 저장위치의 마이너스재고
XBUFX		CHAR	1		저장위치에서 허용된 장부재고잔고 동결
DISKZ		CHAR	1		저장위치 MRP 지시자
XBLGO		CHAR	1		자재이동활성에 대한 저장위치권한
XRESS		CHAR	1		저장위치는 자원에 할당됩니다 (저장자원)
XHUPF		CHAR	1		조정단위 소요량
PARLG		CHAR	4		조정단위의 파트너저장위치
VKORG		CHAR	4		영업조직
VTWEG		CHAR	2		유통경로
VSTEL		CHAR	4		출하 지점/입고 지점
LIFNR		CHAR	10		공급업체 계정 번호
KUNNR		CHAR	10		고객 계정번호
 */
