SELECT 'oldest' AS type, name, birthday
FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker)
UNION ALL
SELECT 'youngest' AS type, name, birthday
FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker)
GROUP BY birthday