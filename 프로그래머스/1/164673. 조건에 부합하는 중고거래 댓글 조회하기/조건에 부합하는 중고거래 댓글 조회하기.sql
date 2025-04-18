-- 선택: 게시글 제목, ID, 댓글 ID, 댓글작성자 ID, 댓글 내용, 댓글 작성일
-- 테이블: BOARD JOIN REPLY
-- 조건: 2022년 10월에 작성
-- 정렬: 댓글 작성일, 게시글 제목 
SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, 
    DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM
    USED_GOODS_BOARD B
JOIN
    USED_GOODS_REPLY R ON B.BOARD_ID = R.BOARD_ID
WHERE
    B.CREATED_DATE LIKE '2022-10%'
ORDER BY
    CREATED_DATE, TITLE