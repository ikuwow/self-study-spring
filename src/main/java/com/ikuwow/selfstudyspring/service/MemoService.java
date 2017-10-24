package com.ikuwow.selfstudyspring.service;

import com.ikuwow.selfstudyspring.model.Memo;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class MemoService {

    public Memo join(String memo, String author) {
        Memo item = new Memo();
        item.setMemo(memo);
        item.setAuthor(author);
        item.setCreated(new Date());
        return item;
    }

}
