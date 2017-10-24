package com.ikuwow.selfstudyspring.repository;

import com.ikuwow.selfstudyspring.model.Memo;
import java.util.List;

public interface MemoRepository {
    List<Memo> findAll();
    List<Memo> findByAuthor(String author);
    void save(Memo item);
}
