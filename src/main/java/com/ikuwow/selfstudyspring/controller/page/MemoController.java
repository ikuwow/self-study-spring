package com.ikuwow.selfstudyspring.controller.page;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("memo")
public class MemoController {
    @RequestMapping("")
    public String get(Model model) {
        List<Map<String, Object>> items = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("memo", "Empty Memo");
        item.put("author", "Empty Author");
        items.add(item);

        model.addAttribute("items", items);
        return "memo";
    }
}
