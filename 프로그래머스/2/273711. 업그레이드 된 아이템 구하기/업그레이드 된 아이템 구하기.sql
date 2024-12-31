-- 코드를 작성해주세요
SELECT 
    T.ITEM_ID, I.ITEM_NAME, RARITY
FROM 
    ITEM_INFO I
JOIN 
    ITEM_TREE T
ON 
    I.ITEM_ID = T.ITEM_ID
WHERE 
    T.PARENT_ITEM_ID IN (SELECT ITEM_ID
                        FROM ITEM_INFO
                        WHERE RARITY = 'RARE')
ORDER BY 
    T.ITEM_ID DESC

