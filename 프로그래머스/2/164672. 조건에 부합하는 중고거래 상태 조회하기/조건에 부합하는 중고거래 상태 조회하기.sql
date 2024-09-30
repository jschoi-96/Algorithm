-- 코드를 입력하세요
-- 1. 2022년 10월 5일에 등록된 게시글 필터링
-- 2. 거래 상태가 SALE이면 판매중, RESERVED면 예약, DONE이면 거래완료
-- 3. STATUS를 추가하여 표시
-- 4. 게시글 ID 내림차순

SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
    CASE 
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'RESERVED' THEN '예약중'
        WHEN STATUS = 'DONE' THEN '거래완료'
    END as STATUS
    FROM USED_GOODS_BOARD
    WHERE DATE_FORMAT(CREATED_DATE, '%Y-%m-%d') = '2022-10-05'
    ORDER BY BOARD_ID desc
