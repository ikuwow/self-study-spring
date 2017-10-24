package com.ikuwow.selfstudyspring.controller.page;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import com.ikuwow.selfstudyspring.model.Memo;
import com.ikuwow.selfstudyspring.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Date;

@Controller
@RequestMapping("memo")
public class MemoController {

    private MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    public MemoService getMemoService() {
        return memoService;
    }

    @RequestMapping("")
    public String get(Model model) {
        model.addAttribute("items", getMemoService().readAll());
        return "memo";
    }

    @RequestMapping("{author}")
    public String get(@PathVariable String author, Model model) {
        model.addAttribute("items", getMemoService().readByAuthor("author"));
        return "memo";
    }

    @RequestMapping("param/{memo:[a-zA-Z0-9]+}")
    public String getParams(
            @PathVariable String memo,
            @RequestParam(required = false, defaultValue = "Default Author") String author,
            Model model
    ) {
        List<Memo> items = new ArrayList<>();
        items.add(getMemoService().join(memo, author));

        model.addAttribute("items", items);
        return "memo";
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public String post(@ModelAttribute Memo item, Model model) {
        getMemoService().write(item.getMemo(), item.getAuthor());
        return "redirect:/memo";
    }
}
