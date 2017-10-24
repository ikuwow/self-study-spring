package com.ikuwow.selfstudyspring.repository.jdbc;

import com.ikuwow.selfstudyspring.repository.MemoRepository;
import com.ikuwow.selfstudyspring.model.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class JdbcMemoRepository implements MemoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Memo> findAll() {
        return jdbcTemplate.query(
            "select content, author from memos order by created desc;",
            (resultSet, i) -> {
                Memo item = new Memo();
                item.setMemo(resultSet.getString("content"));
                item.setAuthor(resultSet.getString("author"));
                return item;
            }
        );
    }

    @Override
    public List<Memo> findByAuthor(String author) {
        return jdbcTemplate.query(
            "select content, author from memos where author = ? order by created desc;",
            (resultSet, i) -> {
                Memo item = new Memo();
                item.setMemo(resultSet.getString("content"));
                item.setAuthor(resultSet.getString("author"));
                return item;
            },
            author
        );
    }

    @Override
    public void save(Memo item) {
        jdbcTemplate.update(
            "insert into memos (content, author, created) values (?, ?, CURRENT_TIMESTAMP);",
            item.getMemo(), item.getAuthor()
        );
    }
}
