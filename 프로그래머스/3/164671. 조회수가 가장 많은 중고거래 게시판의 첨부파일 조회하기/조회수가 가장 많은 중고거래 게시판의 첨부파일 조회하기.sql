-- 코드를 입력하세요
SELECT 
    concat('/home/grep/src/', B.board_id, '/', file_id, file_name, file_ext) as FILE_PATH
FROM USED_GOODS_BOARD B
JOIN USED_GOODS_FILE F ON B.BOARD_ID = F.BOARD_ID
WHERE B.BOARD_ID = (SELECT BOARD_ID
                    FROM USED_GOODS_BOARD
                    ORDER BY VIEWS DESC
                    LIMIT 1)
ORDER BY FILE_ID DESC