SELECT c.name, p.project_count FROM (
SELECT client_id, COUNT(client_id) AS project_count FROM project
GROUP BY client_id
HAVING COUNT(client_id)=(SELECT MAX(mycount) FROM
(SELECT client_id, COUNT(client_id) mycount
FROM project GROUP  BY client_id))) AS p INNER JOIN client AS c ON p.client_id=c.id