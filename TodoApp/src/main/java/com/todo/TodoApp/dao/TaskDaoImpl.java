package com.todo.TodoApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.todo.TodoApp.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Task> getAllTask() {
		String sql = "SELECT * FROM tasks";
		return jdbcTemplate.query(sql, new TaskRowMapper());
	}

	@Override
	public void addTask(Task task) {
		String sql = "INSERT INTO tasks(task_name, task_status, start_date, due_date) VALUE(?, ?, ?, ?)";
		jdbcTemplate.update(sql, task.getTask_name(), task.getTask_status(), task.getStart_date(), task.getDue_date());
	}

	@Override
	public void updateTask(Task task) {
		String sql = "UPDATE tasks SET task_name = ?, task_status = ?, start_date = ?, due_date = ? WHERE task_id = ?";
		jdbcTemplate.update(sql, task.getTask_name(), task.getTask_status(), task.getStart_date(), task.getDue_date(),
				task.getTask_id());
	}

	@Override
	public void deleteTask(int id) {
		String sql = "DELETE FROM tasks WHERE task_id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Task findById(int id) {
		String sql = "SELECT * FROM tasks WHERE task_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new TaskRowMapper());
	}

	private static class TaskRowMapper implements RowMapper<Task> {

		@Override
		public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
			Task task = new Task();
			task.setTask_id(rs.getInt("task_id"));
			task.setTask_name(rs.getString("task_name"));
			task.setTask_status(rs.getInt("task_status"));
			task.setStart_date(rs.getDate("start_date") != null ? rs.getDate("start_date").toLocalDate() : null);
			task.setDue_date(rs.getDate("due_date") != null ? rs.getDate("due_date").toLocalDate() : null);
			return task;
		}

	}

}
