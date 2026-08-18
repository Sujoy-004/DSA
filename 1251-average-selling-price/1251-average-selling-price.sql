# Write your MySQL query statement below

SELECT 
    Prices.product_id,
    ROUND(
        COALESCE(SUM(price * units) / SUM(units), 0),
        2
    ) AS average_price
FROM Prices
LEFT JOIN UnitsSold
    ON Prices.product_id = UnitsSold.product_id
    AND purchase_date BETWEEN start_date AND end_date
GROUP BY Prices.product_id;  