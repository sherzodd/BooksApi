package com.example.SpringBook.repository;

import com.example.SpringBook.models.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("author"));
    }

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM Book";
        return jdbcTemplate.query(sql, BookJdbcRepository::mapRow);
    }

    public void createBook(String title, String description, String author) {
        String sql = "INSERT INTO Book (title, description, author) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, title, description, author);
    }

    public void updateBook(Book book) {
        String sql = "UPDATE Book SET title=?, description=?, author=? WHERE id=?";
        jdbcTemplate.update(sql, book.getTitle(), book.getDescription(), book.getAuthor());
    }

    public void deleteBook(Book book) {
        String sql = "DELETE FROM Book WHERE id=?";
        jdbcTemplate.update(sql, book.getId());
    }

    public Book getBook(int id) {
        String sql = "SELECT * FROM Book WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BookJdbcRepository::mapRow);
    }
}
