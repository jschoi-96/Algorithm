-- 코드를 입력하세요
SELECT 
    concat('/home/grep/src/', board_id, '/', file_id, file_name, file_ext) as FILE_PATH
from USED_GOODS_FILE
where board_id = (select board_id
                 from USED_GOODS_BOARD
                 order by views desc
                  limit 1)
order by file_id desc
