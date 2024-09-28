-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.contents,
DATE_FORMAT(r.created_date, '%Y-%m-%d') as CREATED_DATE
FROM USED_GOODS_BOARD b
JOIN USED_GOODS_REPLY r on b.board_id = r.board_id
where DATE_FORMAT(b.created_date, '%Y-%m') = '2022-10'
order by r.created_date, b.title