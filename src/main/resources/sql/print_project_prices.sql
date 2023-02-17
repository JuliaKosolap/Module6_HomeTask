SELECT concat('Project', ' ', id) AS name, SUM(salary) * diff AS price FROM
(SELECT p.id, datediff(month, p.start_date, p.finish_date) AS diff, w.name, w.salary
FROM project AS p, worker AS w, project_worker AS pw
WHERE pw.project_id=p.id AND pw.worker_id=w.id)
GROUP BY id