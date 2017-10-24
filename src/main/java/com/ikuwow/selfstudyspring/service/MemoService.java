package com.ikuwow.selfstudyspring.service;

import com.ikuwow.selfstudyspring.model.Memo;
import com.ikuwow.selfstudyspring.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class MemoService {

    private MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public MemoRepository getMemoRepository() {
        return memoRepository;
    }

    public Memo join(String memo, String author) {
        Memo item = new Memo();
        item.setMemo(memo);
        item.setAuthor(author);
        item.setCreated(new Date());
        return item;
    }

    public List<Memo> readAll() {
        return getMemoRepository().findAll();
    }

    public List<Memo> readByAuthor(String author) {
        return getMemoRepository().findByAuthor(author);
    }

    public void write(String memo, String author) {
        Memo item = new Memo();
        item.setMemo(memo);
        item.setAuthor(author);
        getMemoRepository().save(item);
    }

}
